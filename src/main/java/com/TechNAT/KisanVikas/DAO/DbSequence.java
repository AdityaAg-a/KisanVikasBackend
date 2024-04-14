package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="db_sequence")
public class DbSequence {
	
	private static final String SEQUENCE_NAME	= "crop_sequence";
	@Id
	private String id;
	private int seqNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	
	
}
