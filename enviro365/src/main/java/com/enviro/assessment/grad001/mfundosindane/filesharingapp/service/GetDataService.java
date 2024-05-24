package com.enviro.assessment.grad001.mfundosindane.filesharingapp.service;
/**
 * Name: GetDataService
 * 
 * Purpose: to serve as an abstractor between the file repository and the get method:
 */
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.wasteModel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository.FileRepository;


@Service
public class GetDataService {

    //file repository object **DO NOT DELETE**
    @Autowired
    private FileRepository fileRepository;

    public List<wasteModel> geAlltData(){
        return(List<wasteModel>) fileRepository.findAll();
    }

    
}