package com.jpworks.datajdbc.service;

import org.apache.cxf.feature.Features;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.jpworks.employee.*;

@Service

@Features(features = "org.apache.cxf.ext.logging.LoggingFeature")
public class EmployeeEndpoint implements EmployeeServicePortType{

    BackendService backendService;
    private Logger logger=LoggerFactory.getLogger(EmployeeEndpoint.class);

    public EmployeeEndpoint (BackendService backendService){
        this.backendService = backendService;
    }

    @Override
    public EmployeesResponse getEmployeesByName(EmployeeByNameRequest parameters) {
        EmployeesResponse employeesResponse = new EmployeesResponse();
        try{
            employeesResponse.getEmployee().addAll(backendService.getEmployeesByName(parameters.getFirstname(), parameters.getLastname()));
        }
        catch (Exception e){
        	logger.error("Error while setting values for employee object", e);
        }
        return employeesResponse;
    }

    @Override
    public EmployeeResponse getEmployeeById(EmployeeByIdRequest parameters) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        try{
            employeeResponse.setEmployee(backendService.getEmployeeById(parameters.getId()));
        }
        catch (Exception e){
        	logger.error("Error while setting values for employee object", e);
        }
        return employeeResponse;
    }
}
