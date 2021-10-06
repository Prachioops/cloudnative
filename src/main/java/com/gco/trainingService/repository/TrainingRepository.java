package com.gco.trainingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gco.trainingService.entities.Training;
import java.util.List;




@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
	
	@Query( value = "SELECT u FROM Training u WHERE u.trainingName =:trainingName")
	List<Training> findTrainingByName(@Param("trainingName") String trainingName);
	
	@Query( value = "SELECT u FROM Training u WHERE u.trainingId =?1")
	Training findTrainingById(int trainingId);


//	 List<Training> Trainings(String string);

}