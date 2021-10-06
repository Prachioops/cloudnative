package com.gco.trainingService.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import com.gco.trainingService.entities.Training;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Data
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
@Component /*it will detect our custom beans*/
@Scope(scopeName = "prototype") /* keeping this as prototype*/
@Entity /* Creating table*/
@Table(name = "EnrolledCourses") /* Specifying table name*/
public class EnrolledCourses {
	
	@Id /* defining primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* generating value automatically*/
    @Column(name = "Enrollment_id") // specifying column name
	private int enrollmentId;
	
	
	private int studentId;
	
	
	
	@OneToOne(targetEntity = Training.class, cascade = CascadeType.ALL)
	private Training training;
	
	public EnrolledCourses(){
		
	}




	public int getStudentId() {
		return studentId;
	}




	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}




	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	
	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	
	
	
	


}

