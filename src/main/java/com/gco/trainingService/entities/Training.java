package com.gco.trainingService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Training") /* Specifying table name*/
public class Training {
	
	@Id /* defining primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* generating value automatically*/
    @Column(name="training_id")
	private int trainingId;
	
	/* specifying column name, giving length and giving
    constraint as not null*/
	@Column(name="training_name", length=25,nullable=false)
	private String trainingName;
	
	@Column(name="training_cost", length=10,nullable=false)
	private double trainingCost;
	
	@Column(name="training_duration", length=25,nullable=false)
	private String trainingDuration;
//	
//	public Training() {
//		
//	}



	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public double getTrainingCost() {
		return trainingCost;
	}

	public void setTrainingCost(double trainingCost) {
		this.trainingCost = trainingCost;
	}

	public String getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(String trainingDuration) {
		this.trainingDuration = trainingDuration;
	}

	public Training get() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

