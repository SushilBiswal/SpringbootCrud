package com.example.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@javax.persistence.Id
	
	private String id;
	private String courseId;
	private int roll;
	private double totalMarks;
	private boolean passInd;
	
	


}
