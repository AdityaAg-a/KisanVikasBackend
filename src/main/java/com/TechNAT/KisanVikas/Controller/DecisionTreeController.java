package com.TechNAT.KisanVikas.Controller;

import com.TechNAT.KisanVikas.Service.AiModel.DecisionTree;
import com.TechNAT.KisanVikas.Service.AiModel.FileName;
import com.TechNAT.KisanVikas.Service.AiModel.ML;
import com.TechNAT.KisanVikas.DAO.CropRecommendation;
import com.TechNAT.KisanVikas.Service.DecisionTreeService;
import com.TechNAT.KisanVikas.Service.FileFactory;
import com.TechNAT.KisanVikas.Service.LoadData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import weka.core.Instances;


@RestController
@RequestMapping("/AIModel")
public class DecisionTreeController {

    @Autowired
    DecisionTreeService decisionTreeService;

    @Autowired
    LoadData loadData;

    @Autowired
    FileFactory fileFactory;

    @ResponseBody
    @RequestMapping(value ="/decisiontree", method={RequestMethod.GET})
    public String getDecisionTreeAccuracy(DecisionTree decisionTree) throws Exception{
        return decisionTreeService.getDecisionTreeInformation(decisionTree);
    }

    @ResponseBody
    @RequestMapping(value = "/regressiontree", method = {RequestMethod.GET})
    public String getRegressionTree(DecisionTree decisionTree) throws Exception {
        return decisionTreeService.handleRegressionTree(decisionTree);
    }

    @ResponseBody
    @RequestMapping(value="/decisiontree/test", method={RequestMethod.GET})
    public String testingError(DecisionTree decisionTree) throws Exception{
        return decisionTreeService.handleSplitData(decisionTree, 1, "");
    }

    @ResponseBody
    @RequestMapping(value="/decisiontree/model", method={RequestMethod.POST})
    public void createModel(DecisionTree decisionTree) throws Exception{
        decisionTreeService.createModel(decisionTree);
    }

    @PostMapping(path = "/PredictCropRecommendation")
    public String getModel(@RequestBody CropRecommendation crp) throws Exception{
    	DecisionTree decisionTree=new DecisionTree();
    	decisionTree.setFileName(ML.Files.Crop_recommendation);
        return decisionTreeService.getModel(decisionTree,crp);
    }

    @ResponseBody
    @RequestMapping(value ="/createArff", method={RequestMethod.POST})
    public void createArff(@RequestBody FileName fileName) throws Exception{
        Instances instances = loadData.getDataFromCsvFile(fileName.getFileName() + ".csv");
        loadData.saveToArff(instances, fileName.getFileName() + ".arff");
    }

    @ResponseBody
    @RequestMapping(value ="/discretize", method={RequestMethod.POST})
    public void discretizeCensus() throws Exception{
        fileFactory.saveDiscretizedArff();
    }
}