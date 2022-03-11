package com.example.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "approval_level")

public class Approve {
	
	@Id
	@GeneratedValue
	private int approve_id;
	
	@Column(name="level")
	private String level;
	
	@Column(name="report_to")
	private String reportingTo;

	@Column(name="threshold")
	private String threshold;
	
	@Column(name="sub_process_approval_id")
	private String subProcessApprovalId;
	

}
