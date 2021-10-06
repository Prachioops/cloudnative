package com.gco.trainingService.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gco.trainingService.entities.*;


import com.gco.trainingService.entities.Training;

import com.gco.trainingService.exception.NoSuchTrainingException;
import com.gco.trainingService.service.TrainingServiceImpl;





@RestController
@RequestMapping("/TrainingController")
public class TrainingController {
	
	Logger log = LoggerFactory.getLogger(TrainingController.class);
	
	@Autowired
	private TrainingServiceImpl trainingService;
	
	
	
	//	Get all training
	@GetMapping(path = "/all",  consumes="application/json", produces = "application/json")
		public ResponseEntity<List<Training>> findAllTraining() {
			
		log.info("getStudent method of StudentController called ");
		
		  List<Training> training=trainingService.findAllTraining();
		  
		  log.info("getStudent method of StudentController ends");
			
			return new ResponseEntity<>(training, HttpStatus.OK);
		}

	// View training by name
		@GetMapping(path="/training/{trainingName}", consumes = "application/json", produces = "application/json")
		public ResponseEntity<List<Training>> getTraining(@PathVariable String trainingName) {
			
			log.info("getStudent method of StudentController called ");
			List<Training> training=trainingService.findTraining(trainingName);
			
			if(training!= null) {
				
				return new ResponseEntity<List<Training>>(training, HttpStatus.OK);
			}
			
			log.info("getStudent method of StudentController ends"); 
			return new ResponseEntity<List<Training>>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
		//enroll training
		@PostMapping(path = "/enrolTraining", consumes = "application/json", produces = "application/json")
		public ResponseEntity<EnrolledCourses> enrolTraining(@RequestBody EnrolledCourses enrolledCourses) throws NoSuchTrainingException{
			
			log.info("postStudent method of StudentController called ");
			EnrolledCourses result = trainingService.enrolTraining(enrolledCourses);
			if(enrolledCourses != null) {
				return new ResponseEntity<EnrolledCourses>(result, HttpStatus.ACCEPTED);
			}
			
			log.info("postStudent method of StudentController ends");
			return new ResponseEntity<EnrolledCourses>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

				
			
	//view enrolled courses by id(not working))
		  
    @GetMapping(path="/viewEnrolledCourses/{enrollmentId}",consumes ="application/json")
			
	public ResponseEntity<EnrolledCourses> viewEnrolledCourses(@PathVariable("enrollmentId") int enrollmentId) {
				
				log.info("get Admin method of Admin Controller to get enrolled courses by Id is called");
				
				EnrolledCourses result = trainingService.viewEnrolledCourses(enrollmentId);
				if(result != null)
					return new ResponseEntity<EnrolledCourses>(result,HttpStatus.FOUND);
				else
					log.info("get Admin method of Admin Controller to get enrolled courses by Id ends");
					return new ResponseEntity<EnrolledCourses>(result,HttpStatus.BAD_REQUEST);
				
			}
		
		//Add Payment
		@PostMapping(path = "/addPayment", consumes = "application/json", produces = "application/json")
		public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
			
			log.info("postStudent method of StudentController called ");
			Payment newPayment = trainingService.addPayment(payment);
			if(payment != null) {
				return new ResponseEntity<Payment>(newPayment, HttpStatus.ACCEPTED);
			}
			 
			log.info("postStudent method of StudentController ends ");
			return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//add training
		@PostMapping(path="/addTraining")
		// http://localhost:9090/GetCertifiedOnline-api/Admins/addTraining
		public ResponseEntity<Training> addTraining(@RequestBody Training training){
			
			log.info("postAdmin method of AdminController called");
			ResponseEntity<Training> response= null;
			
			Training result = trainingService.addTraining(training);
			if(result != null) 
				response = new ResponseEntity<>(result,HttpStatus.CREATED);
			else
				response = new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
			log.info("postAdmin method of AdminController ends");
			return response;
		}
		
		//view training by id
		@GetMapping(path="/findTrainingById/{trainingId}")
		// http://localhost:9090/GetCertifiedOnline-api/Admins/findTrainingById/
		public ResponseEntity<Training> getTrainingById(@PathVariable("trainingId") int trainingId) throws NoSuchTrainingException{
			
			log.info("get Admin method of Admin Controller to get training by Id is called");
			
			ResponseEntity<Training> response= null;
			Training result = trainingService.findTrainingById(trainingId);
			if(result != null)
				response = new ResponseEntity<Training>(result,HttpStatus.FOUND);
			else
				response = new ResponseEntity<Training>(result,HttpStatus.BAD_REQUEST);
			
			log.info("get Admin method of Admin Controller to get training by Id ends");
			return response;
		}
		
		//view all training
		@GetMapping(path="/findAllTraining")
		// http://localhost:9090/GetCertifiedOnline-api/Admins/findAllTraining
		public ResponseEntity<List<Training>> getAllTraining(){
			
			log.info("get Admin method of Admin Controller to get all training  is called");
			
			ResponseEntity<List<Training>> response = null;
			List<Training>  result= trainingService.findAllTraining();
			if(result != null)
				response = new ResponseEntity<List<Training>>(result,HttpStatus.FOUND);
			else
				response = new ResponseEntity<List<Training>>(result,HttpStatus.BAD_REQUEST);
			
			log.info("get Admin method of Admin Controller to get all trainings ends");
			return response;
		}
		
		//delete training by id
		@DeleteMapping(path="/deleteTrainingById/{trainingId}")
		// http://localhost:9090/GetCertifiedOnline-api/Admins/deleteTrainingById/{trainingId}
		public ResponseEntity<Boolean> deleteTrainingById(@PathVariable("trainingId")int trainingId) throws NoSuchTrainingException{
			
			log.info("deleteAdmin method of Admin Controller called");
			ResponseEntity<Boolean> response=null;
			boolean result = trainingService.removeTraining(trainingId);
			if(result)
				response = new ResponseEntity<Boolean>(result,HttpStatus.OK);
			else
				response = new ResponseEntity<Boolean>(result,HttpStatus.BAD_REQUEST);
			
			log.info("deleteAdmin method of Admin Controller ends");
			return response;
		}
		
		//update training
		@PutMapping(path="/updateTraining" ,consumes = "application/json", produces = "application/json")
		// http://localhost:9090/GetCertifiedOnline-api/Admins/updateTraining
		public ResponseEntity<Training> updateTraining(@RequestBody Training training){
			
			log.info("putAdmin method of Admin Controller called");
			
			ResponseEntity<Training> response = null;
			trainingService.modifyTraining(training.getTrainingId(),training);
			
			log.info("putAdmin method of Admin Controller ends");
			return new ResponseEntity<>(training, HttpStatus.OK);
			
		}
		
		//view payment by transaction id
		  
		@GetMapping(path="/viewPayment/{transactionId}",consumes ="application/json")
			
		public ResponseEntity<Payment> viewPayment(@PathVariable("transactionId") int transactionId) {
				
			 log.info("get Admin method of Admin Controller to get payment by Id is called");
			
				Payment result = trainingService.viewPayment(transactionId);
				if(result != null)
					return new ResponseEntity<Payment>(result,HttpStatus.FOUND);
				else
				log.info("get Admin method of Admin Controller to get payment by Id ends");
				return new ResponseEntity<Payment>(result,HttpStatus.BAD_REQUEST);
				
		}
		
}
