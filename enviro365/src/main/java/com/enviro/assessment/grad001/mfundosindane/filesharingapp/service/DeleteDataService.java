package com.enviro.assessment.grad001.mfundosindane.filesharingapp.service;

/**
 * Name: DeleteDataService
 * 
 * Purpose: to serve as an abstractor between the file repository and the delete method:
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository.FileRepository;

@Service
public class DeleteDataService {

    // file repository object **DO NOT DELETE**
    @Autowired
    private FileRepository fileRepository;

    public void DeleteById(Integer id) {
        fileRepository.deleteById(id);
        ;
    }

}
