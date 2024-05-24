package com.enviro.assessment.grad001.mfundosindane.filesharingapp.controller;

/*
 * Name: AppController
 * 
 * Purpose: to manage the get,post,put and delete requests from the website
*/
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.wasteModel;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.service.DeleteDataService;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.service.GetDataService;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.service.PostDataService;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.service.UpdateDataService;

@RestController
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    // objects from the service classes for the required methods to handle user
    // inputs:
    @Autowired
    private PostDataService PDS;

    @Autowired
    private GetDataService GDS;

    @Autowired
    private DeleteDataService DDS;

    @Autowired
    private UpdateDataService UDS;

    // Get request for waste page table:
    @GetMapping("/waste")
    public ResponseEntity<List<wasteModel>> getWaste() {
        logger.info("Fetching all waste data");
        return ResponseEntity.ok().body(GDS.geAlltData());
    }

    // Get request for disposal page table:
    @GetMapping("/disposal")
    public ResponseEntity<List<wasteModel>> getDisposal() {
        logger.info("Fetching all disposal data");
        return ResponseEntity.ok().body(GDS.geAlltData());
    }

    // Get request for recycling page table:
    @GetMapping("/recycle")
    public ResponseEntity<List<wasteModel>> getRecycle() {
        logger.info("Fetching all recycle data");
        return ResponseEntity.ok().body(GDS.geAlltData());
    }

    // Get request for admin page table:
    @GetMapping("/admin")
    public ResponseEntity<List<wasteModel>> getAdmin() {
        logger.info("Fetching all admin data");
        return ResponseEntity.ok().body(GDS.geAlltData());
    }

    // Get request for delete page table:
    @GetMapping("/delete")
    public ResponseEntity<List<wasteModel>> getDelete() {
        logger.info("Fetching all data marked for deletion");
        return ResponseEntity.ok().body(GDS.geAlltData());
    }

    // Get request for update page table:
    @GetMapping("/update")
    public ResponseEntity<List<wasteModel>> getUpdate() {
        logger.info("Fetching all data to update");
        return ResponseEntity.ok().body(GDS.geAlltData());
    }

    // delete request to remove a row selected using the id given:
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Integer id) {
        logger.info("Deleting entity with id: {}", id);
        try {
            DDS.DeleteById(id);
            return ResponseEntity.ok().body("Model successfully deleted");
        } catch (Exception e) {
            logger.error("Error deleting the model with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting the model: " + e.getMessage());
        }
    }

    // put request to update a selected row using a given id for the specified
    // properties for the model:
    @PutMapping("update/{id}/{type}/{name}/{description}/{guideline}/{tips}")
    public ResponseEntity<String> updateEntity(@PathVariable Integer id, @PathVariable String type,
            @PathVariable String name, @PathVariable String description, @PathVariable String guideline,
            @PathVariable String tips) {
        logger.info("Updating entity with id: {}", id);
        try {
            UDS.updateData(id, type, name, description, guideline, tips);
            return ResponseEntity.ok().body("Data successfully updated");
        } catch (Exception e) {
            logger.error("Error updating the model with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating the model: " + e.getMessage());
        }
    }

    // post request used to upload the specified properties for the model:
    @PostMapping("/admin")
    public ResponseEntity<String> postEntity(@RequestParam String wasteType, @RequestParam String wasteName,
            @RequestParam String wasteDescription, @RequestParam String disposalGuidelines,
            @RequestParam String recycleTips) {
        logger.info("Uploading data for wasteType: {}, wasteName: {}", wasteType, wasteName);
        try {
            PDS.saveData(wasteType, wasteName, wasteDescription, disposalGuidelines, recycleTips);
            return ResponseEntity.ok().body("Data successfully uploaded");
        } catch (IOException e) {
            logger.error("Error uploading data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading data: " + e.getMessage());
        }
    }

    // Exception Handlers:
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        logger.warn("File size exceeds the limit", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File size exceeds the limit");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        logger.error("Internal server error", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Internal Server Error: " + ex.getMessage());
    }

}
