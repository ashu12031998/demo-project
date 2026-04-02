package com.example.demo.controller;

import com.example.demo.model.CloudVendor;
import com.example.demo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIController {
    public CloudAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // private CloudVendor cloudVendor;
    CloudVendorService cloudVendorService;
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorID) {
        return cloudVendorService.getCloudVendor(vendorID);
    }
    //all cloud vendor in DB
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        //this.cloudVendor=cloudVendor;
        return "Cloud vendor Updated Successfully";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
       // this.cloudVendor=cloudVendor;
        return "Update Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorID){
        cloudVendorService.deleteCloudVendor(vendorID);
       // this.cloudVendor=null;
        return "Delete Sucessfully";
    }

}

