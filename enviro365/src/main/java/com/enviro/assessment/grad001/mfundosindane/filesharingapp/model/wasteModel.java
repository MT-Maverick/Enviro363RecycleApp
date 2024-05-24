package com.enviro.assessment.grad001.mfundosindane.filesharingapp.model;
/*Name: wasteModel
 * 
 * Purpose: To create a class object for the data uploaded and retrieved, also to link the designed object to the in-memory database:
 * 
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wasteData")

public class wasteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer wasteLogId;
    private String wasteName;
    private String wasteType;
    private String wasteDescription;
    private String dispoaslGuidelines;
    private String recycleTips;

    // get method for waste id
    public Integer getWasteLogId() {
        return this.wasteLogId;
    }

    // get method for waste name:
    public String getWasteName() {
        return this.wasteName;
    }

    // get method for waste type:
    public String getWasteType() {
        return this.wasteType;
    }

    // get method for waste description:
    public String getWasteDescription() {
        return this.wasteDescription;
    }

    // get method for disposal guidelines:
    public String getDispoaslGuidelines() {
        return this.dispoaslGuidelines;
    }

    // get method for recycle tips:
    public String getRecyleTips() {
        return this.recycleTips;

    }

    // set method for waste id
    public void setWasteLogId(Integer id) {
        this.wasteLogId = id;
    }

    // set method for waste name:
    public void setWasteName(String name) {
        this.wasteName = name;
    }

    // set method for waste type:
    public void setWasteType(String type) {
        this.wasteType = type;
    }

    // set method for waste description:
    public void setWasteDesription(String description) {
        this.wasteDescription = description;

    }

    // set method for disposal guidelines:
    public void setDisposalGuidelines(String guidelines) {
        this.dispoaslGuidelines = guidelines;
    }

    // set method for recycle tips:
    public void setRecycleTips(String tips) {
        this.recycleTips = tips;
    }
}