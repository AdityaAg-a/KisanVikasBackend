package com.TechNAT.KisanVikas.Service;

import com.TechNAT.KisanVikas.DAO.CropRecommendation;
import com.TechNAT.KisanVikas.Service.AiModel.DecisionTree;
import com.TechNAT.KisanVikas.Service.AiModel.ML;
import com.TechNAT.KisanVikas.Service.AiModel.Options;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;

import weka.classifiers.meta.AdaBoostM1;

import weka.classifiers.trees.J48;
import weka.classifiers.trees.REPTree;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.Random;

@Service
public class DecisionTreeService {

    private LoadData loadData;
    private FileFactory fileFactory;
    private EvaluationService evaluationService;

    public DecisionTreeService(FileFactory fileFactory, LoadData loadData, EvaluationService evaluationService){
        this.fileFactory = fileFactory;
        this.loadData = loadData;
        this.evaluationService = evaluationService;
    }

    public String getDecisionTreeInformation(DecisionTree decisionTree) throws Exception{
        if (decisionTree.getTreeType() == DecisionTree.TreeType.J48) {
            return handleJ48(decisionTree);
        }
        return null;
    }

    public Classifier buildJ48(DecisionTree decisionTree, Instances data) throws Exception{
        //uses information gain ratio
        J48 j48 = new J48();
        if (decisionTree.getUnpruned() != null){
            j48.setUnpruned(decisionTree.getUnpruned());
        }
        if (decisionTree.getConfidence() != null){
            j48.setOptions(new String[]{"-C", decisionTree.getConfidence()});
        }
        if (decisionTree.getMinNumObj() != null){
            j48.setMinNumObj(decisionTree.getMinNumObj());
        }
        if (decisionTree.isBoost()){
            AdaBoostM1 adaBoostM1 = new AdaBoostM1();
            adaBoostM1.setUseResampling(false);
            adaBoostM1.setClassifier(j48);
            adaBoostM1.buildClassifier(data);
            return adaBoostM1;
        } else {
            j48.buildClassifier(data);
            return j48;
        }
    }
   
    
    public String evaluateDataForCropRecommendation(FileFactory.TrainTest data, Classifier classifier, DecisionTree decisionTree,CropRecommendation crp) throws Exception {
    	String predictedCrop="";
    	Instances dataa = data.test;
        dataa.setClassIndex(dataa.numAttributes() - 1); // Set class attribute

        // Create an empty instance with attributes
        Instance instance = new DenseInstance(8); // 7 is the number of attributes
        instance.setDataset(dataa);
        instance.setValue(dataa.attribute("N"), Integer.parseInt(crp.getN()));
        instance.setValue(dataa.attribute("P"), Integer.parseInt(crp.getP()));
        instance.setValue(dataa.attribute("K"), Integer.parseInt(crp.getK()));
        instance.setValue(dataa.attribute("temperature"), Integer.parseInt(crp.getTemperature()));
        instance.setValue(dataa.attribute("humidity"), Integer.parseInt(crp.getHumidity()));
        instance.setValue(dataa.attribute("ph"), Integer.parseInt(crp.getPh()));
        instance.setValue(dataa.attribute("rainfall"), Integer.parseInt(crp.getRainfall()));
        
        double prediction = classifier.classifyInstance(instance);
        predictedCrop = dataa.classAttribute().value((int) prediction);
    	
    	return predictedCrop;

    }

    public String evaluateData(FileFactory.TrainTest data, Classifier classifier, DecisionTree decisionTree) throws Exception{
        Evaluation evaluation = new Evaluation(data.train);

        if (decisionTree.getTestType() == DecisionTree.TestType.CrossValidation){
            evaluation.crossValidateModel(classifier, data.train, 10, new Random(1));
        } else if (decisionTree.getTestType() == DecisionTree.TestType.Train){
            FileFactory.TrainTest d;
            if (decisionTree.getFileName() == ML.Files.Census){
                d = fileFactory.handlePublicCensus(0, new Options(decisionTree.isFeatureSelection()));
            } else {
                d = fileFactory.handlePublicCar(0);
            }
            evaluation.evaluateModel(classifier, d.train);
        } else {
            evaluation.evaluateModel(classifier, data.test);
        }
        String retString = "";
        retString += evaluation.toSummaryString() + " \n";
        retString += evaluation.toClassDetailsString() + " \n";
        //retString += evaluation.toMatrixString() + " \n";
        return retString;
    }

    public void createModel(DecisionTree decisionTree) throws Exception{
        FileFactory.TrainTest data = fileFactory.getInstancesFromFile(decisionTree.getFileName(), new Options(decisionTree.isFeatureSelection()));
        Classifier cls = buildJ48(decisionTree, data.train);
        loadData.saveModel(cls, getString(decisionTree));
    }

    public String getModel(DecisionTree decisionTree,CropRecommendation crp) throws Exception{
        FileFactory.TrainTest data = fileFactory.getInstancesFromFile(decisionTree.getFileName(), new Options(decisionTree.isFeatureSelection()));
        Classifier cls = loadData.getModel(getString(decisionTree));
        decisionTree.setTestType(ML.TestType.TestData);
        return evaluateDataForCropRecommendation(data, cls, decisionTree,crp);
    }

    private String getString(DecisionTree decisionTree){
        String dString = "decisionTree-minNumObj=" +
                decisionTree.getMinNumObj().toString() +
                "-Boosted=" + decisionTree.isBoost() +
                "-C=" + decisionTree.getConfidence() +
                "-file=" + decisionTree.getFileName().toString();
        if (decisionTree.isFeatureSelection()){
            dString += "-feature=true";
        }
        return dString + ".model";
    }

    public String handleSplitData(DecisionTree decisionTree, int num, String retString) throws Exception{
        if (num <= 100){
            retString += "Amount " + Integer.toString(num) + "\n";
            FileFactory.TrainTest data;
            if (decisionTree.getFileName() == ML.Files.Census){
                data = fileFactory.handlePublicCensus(num, new Options(decisionTree.isFeatureSelection()));
            } else {
                data = fileFactory.handlePublicCar(num);
            }
            Classifier cls = buildJ48(decisionTree, data.train);
            Instances d;
            if (decisionTree.getTestType() == ML.TestType.Train){
                if (decisionTree.getFileName() == ML.Files.Car){
                    d = fileFactory.handlePublicCar(0).train;
                } else {
                    d = fileFactory.handlePublicCensus(0, new Options(decisionTree.isFeatureSelection())).train;
                }
            } else {
                d = data.test;
            }
            return handleSplitData(decisionTree, num==1 ? num+9 : num+10, retString + "\n \n" + evaluationService.evaluateData(data.train, cls, d));
        }
        return retString;
    }

    public String handleRegressionTree(DecisionTree decisionTree) throws Exception{
        REPTree repTree = new REPTree();
        FileFactory.TrainTest trainTest = fileFactory.getInstancesFromFile(ML.Files.Boston, new Options());
        repTree.buildClassifier(trainTest.train);

        Evaluation evaluation = new Evaluation(trainTest.train);
        evaluation.crossValidateModel(repTree, trainTest.train, 10, new Random(1));
        return repTree.toString();
    }


    private String handleJ48(DecisionTree decisionTree) throws Exception{
        FileFactory.TrainTest data = fileFactory.getInstancesFromFile(decisionTree.getFileName(), new Options(decisionTree.isFeatureSelection()));
        Classifier j48 = buildJ48(decisionTree, data.train);
        return evaluateData(data, j48, decisionTree) + "\n \n " + j48.toString();
    }

}