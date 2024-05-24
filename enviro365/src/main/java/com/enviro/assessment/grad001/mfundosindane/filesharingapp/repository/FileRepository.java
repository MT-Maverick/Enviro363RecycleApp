package com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository;

/*Name: FileRepository
 * 
 * Purpose: To act as a interface for the webapp and the database
*/


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.wasteModel;


//Repository for wasteModel 
@Repository
public interface FileRepository extends CrudRepository<wasteModel,Integer>{
}

