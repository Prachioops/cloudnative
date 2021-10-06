package com.gco.trainingService.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Component /*it will detect our custom beans*/
@Scope(scopeName = "prototype") /* keeping this as prototype*/
@Entity /* Creating table*/
@Table(name = "Payment") /* Specifying table name*/
public class Payment {
	
	
	@Id /* defining primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* generating value automatically*/
    @Column(name = "tansaction_Id") // specifying column name
	private int transactionId;
	

	@Column(name="mode_of_payment" ,length=100)
	private String modeOfPayment;
	
   
	
	
	@OneToOne(targetEntity = EnrolledCourses.class, cascade = CascadeType.ALL)
	private EnrolledCourses enrolledCourses;

	
//	public Payment() {
//
//	}



	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public String getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	public EnrolledCourses getEnrolledCourses() {
		return enrolledCourses;
	}


	public void setEnrolledCourses(EnrolledCourses enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}


	
	
	
}

