package com.enviro.assessment.grad001.mfundosindane.filesharingapp.service;

/**
 * Name: UpdateDataService
 * 
 * Purpose: to serve as an abstractor between the file repository and the put method:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.wasteModel;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository.FileRepository;

@Service
public class UpdateDataService {

   // file repository object **DO NOT DELETE**
   @Autowired
   private FileRepository fileRepository;

   public void updateData(Integer id, String wasteType, String wasteName, String wasteDescription,
         String disposalGuidelines, String recycleTips) {

      wasteModel newModel = fileRepository.findById(id).get();

      newModel.setWasteType(wasteType);
      newModel.setWasteName(wasteName);
      newModel.setWasteDesription(wasteDescription);
      newModel.setDisposalGuidelines(disposalGuidelines);
      newModel.setRecycleTips(recycleTips);

      fileRepository.save(newModel);

   }

}