package com.gco.trainingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gco.trainingService.entities.EnrolledCourses;
import com.gco.trainingService.entities.Training;


@Repository
public interface EnrolledCoursesRepository extends JpaRepository<EnrolledCourses,Integer> {
	
	@Query( value = "SELECT u FROM EnrolledCourses u WHERE u.enrollmentId =?1")
	EnrolledCourses findEnrolledCourses(int enrollmentId);


}