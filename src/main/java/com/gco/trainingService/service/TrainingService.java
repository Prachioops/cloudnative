package com.gco.trainingService.service;

import java.util.List;

import com.gco.trainingService.entities.EnrolledCourses;
import com.gco.trainingService.entities.Payment;
import com.gco.trainingService.entities.Training;
import com.gco.trainingService.exception.NoSuchTrainingException;
import com.gco.trainingService.TrainingServiceApplication;

public interface TrainingService {

    public Training addTraining(Training training);
	
	public boolean removeTraining(int trainingId)throws NoSuchTrainingException;
	
	public void modifyTraining(int trainingId,Training training);
	
	public List<Training> findAllTraining();
	
	public Training findTrainingById(int trainingId)throws NoSuchTrainingException;
	
    public EnrolledCourses viewEnrolledCourses(int enrollmentId);
	
	public Payment viewPayment(int transactionId) ;
	
   public List<Training> findTraining(String trainingName)throws NoSuchTrainingException;
	
	public EnrolledCourses enrolTraining(EnrolledCourses enrolledCourses) throws NoSuchTrainingException;
	
	public Payment addPayment(Payment payment);



}
