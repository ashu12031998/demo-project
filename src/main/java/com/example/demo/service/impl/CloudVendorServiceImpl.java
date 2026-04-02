package com.example.demo.service.impl;

import com.example.demo.exception.CloudVendorNotFoundException;
import com.example.demo.model.CloudVendor;
import com.example.demo.repository.CloudAPIService;
import com.example.demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{

    public CloudVendorServiceImpl(CloudAPIService cloudAPIService) {
        CloudAPIService = cloudAPIService;
    }

    CloudAPIService CloudAPIService;

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        CloudAPIService.save(cloudVendor);
        return "success";
    }
    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        CloudAPIService.save(cloudVendor);
        return "Updated Successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        CloudAPIService.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(CloudAPIService.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Cloud Vendor Not Found");
        return CloudAPIService.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {

        return CloudAPIService.findAll();
    }
}
