package com.enviro.assessment.grad001.mfundosindane.filesharingapp.service;

/**
 * Name: PostDataService
 * 
 * Purpose: to serve as an abstractor between the file repository and the post method:
 */
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.wasteModel;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository.FileRepository;

@Service
public class PostDataService {

    // file repository object **DO NOT DELETE**
    @Autowired
    private FileRepository fileRepository;

    public void saveData(String wasteType, String wasteName, String wasteDescription, String disposalGuidelines,
            String recycleTips) throws IOException {
        wasteModel model = new wasteModel();
        model.setWasteName(wasteName);
        model.setWasteType(wasteType);
        model.setWasteDesription(wasteDescription);
        model.setDisposalGuidelines(disposalGuidelines);
        model.setRecycleTips(recycleTips);

        fileRepository.save(model);

    }

}
