package com.techoffice.Services.client;

import com.techoffice.Services.dto.CoRequestDTO;

import com.techoffice.Services.dto.CoRequestPartyDTO;
import com.techoffice.Services.dto.generic.SearchDTO;
import com.techoffice.Services.service.CoRequestService;

import com.techoffice.Services.service.CoRequestServiceImpl;

import java.util.Collections;
import java.util.List;

public class CoRequestClientImpl implements CoRequestClient{
    CoRequestService service=new CoRequestServiceImpl();
    @Override
    public List<CoRequestDTO> findPetitonId(String petNumber) {
        
        return service.findPetitonId(petNumber);
        
    }

    @Override
    public CoRequestDTO add(CoRequestDTO reqDto) {
        
        return service.add(reqDto);
    }

    @Override
    public List<CoRequestDTO> findAllRequests(SearchDTO searchDto) {
        // TODO Implement this method
        return service.findAllRequests(searchDto);
    }

    @Override
    public List<CoRequestDTO> findRequestByName(String accuseName) {
        
        return service.findRequestByName(accuseName);
    }

    @Override
    public CoRequestDTO findById(long id) {
        
        return service.findById(id);
    }

    @Override
    public List<CoRequestDTO> findByRequestNumber(String requestNumber) {
        
        return service.findByRequestNumber(requestNumber);
    }
}
