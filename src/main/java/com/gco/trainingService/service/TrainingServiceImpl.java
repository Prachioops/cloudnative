package com.gco.trainingService.service;

import java.util.*;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.gco.trainingService.entities.Training;
import com.gco.trainingService.entities.EnrolledCourses;
import com.gco.trainingService.entities.Payment;
import com.gco.trainingService.exception.NoSuchTrainingException;

import com.gco.trainingService.repository.EnrolledCoursesRepository;

import com.gco.trainingService.repository.PaymentRepository;

import com.gco.trainingService.repository.TrainingRepository;



@Service
@Transactional
public class TrainingServiceImpl implements TrainingService{
	
	Logger log = LoggerFactory.getLogger(TrainingServiceImpl.class);
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private EnrolledCoursesRepository enrolledCoursesRepository;
	
	@Autowired
	TrainingServiceImpl t;
   
	//view all trainings
	@Override
	public List<Training> findAllTraining() {
		
		log.debug("findAllTraining service in student service is invoked");
		
		//List<Training> list = trainingRepository.findAll();
		//if(list.isEmpty())
		//	throw new UserListEmptyException("User List is empty!!");
		return trainingRepository.findAll();
	}

	//view training by training name  
	@Override
	public List<Training> findTraining(String trainingName) {
		// TODO Auto-generated method stub
		//System.out.println(trainingName);
		
		log.debug("findTraining service in student service is invoked");
		return trainingRepository.findTrainingByName(trainingName);
	}

	
	
   // to enroll for training
	@Override
	public EnrolledCourses enrolTraining(EnrolledCourses enrolledCourses) throws NoSuchTrainingException {
//		// TODO Auto-generated method stub
		log.debug("enrolTraining service in training service is invoked");
	    enrolledCourses.setTraining(trainingRepository.findTrainingById(enrolledCourses.getTraining().getTrainingId()));
		return enrolledCoursesRepository.save(enrolledCourses);
	}

	//to add payment
	public Payment addPayment(Payment payment)
	{
		log.debug("addPayment service in training service is invoked");
		payment.setEnrolledCourses(enrolledCoursesRepository.findEnrolledCourses(payment.getEnrolledCourses().getEnrollmentId()));
		return paymentRepository.save(payment);
	}
	
	//add training
	@Override
	public Training addTraining(Training training) {
		log.debug("addTraining service in training service is invoked");
		return trainingRepository.save(training);
	}

	//remove training
    @Override
	public boolean removeTraining(int trainingId) throws NoSuchTrainingException {
    	
    	log.debug("removeTraining service in training service is invoked");
		try {
			Training training = findTrainingById(trainingId);
			if (training != null) {
				trainingRepository.delete(training);
				return true;
			}
		}catch( NoSuchElementException e) {
			throw new NoSuchTrainingException("Training with "+trainingId+" Not found!!");
		}
		return false;
	}

    //modify training
    @Override
	public void modifyTraining(int trainingId,Training training){
    	log.debug("modifyTraining service in training service is invoked");
   
		Training t = trainingRepository.findById(trainingId).get();
		t=training;
		trainingRepository.save(t);
		}
	
 
  

	
   //find training by training id
	@Override
	public Training findTrainingById(int trainingId) throws NoSuchTrainingException {
		log.debug("findTrainingById service in training service is invoked");
		
		try {
			Optional<Training> training = trainingRepository.findById(trainingId);
			if(training.get()!=null) {
				return training.get();
			}
		}catch(NoSuchElementException e) {
			throw new NoSuchTrainingException("Training with "+trainingId+" Not found!!!");
		}
		return null;
	}
	

	//view enrolled courses(admin)
	@Override
	public EnrolledCourses viewEnrolledCourses(int enrollmentId) 
	{
	log.debug("viewEnrolledCourses service in admin service is invoked");	
		
	EnrolledCourses enrolledCourses= enrolledCoursesRepository.findById(enrollmentId).get();
	return  enrolledCourses;
	}
	
	
//view payment by transaction Id(admin)
   @Override
   public Payment viewPayment(int transactionId) 
	{
	log.debug("viewPayment service in training service is invoked");   
	Payment payment= paymentRepository.findById(transactionId).get();
	return  payment;
	}
	
	
}

