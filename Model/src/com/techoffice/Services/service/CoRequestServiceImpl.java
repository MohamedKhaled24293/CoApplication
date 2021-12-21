package com.techoffice.Services.service;

import com.techoffice.Services.dao.CoRequestDAO;
import com.techoffice.Services.dao.CoRequestDAOImpl;
import com.techoffice.Services.dto.CoRequestDTO;

import com.techoffice.Services.dto.CoRequestPartyDTO;

import com.techoffice.Services.dto.generic.SearchDTO;

import java.util.Collections;
import java.util.List;

public class CoRequestServiceImpl implements CoRequestService {
    CoRequestDAO dao = new CoRequestDAOImpl();
    @Override
    public List<CoRequestDTO> findPetitonId(String petNumber) {
        return dao.findPetitonId(petNumber);
    }

    @Override
    public CoRequestDTO add(CoRequestDTO reqDto) {
        if(reqDto.getId() == null){
        int rand = (int)Math.floor(Math.random()*(100-1+1)+1);
        String split="/2019";
        reqDto.setRequestNumber(rand+split);
        }
        return dao.add(reqDto);
    }

    @Override
    public List<CoRequestDTO> findAllRequests(SearchDTO searchDto) {
        return dao.findAllRequests(searchDto);
    }

    @Override
    public List<CoRequestDTO> findRequestByName(String accuseName) {
        // TODO Implement this method
        return dao.findRequestByName(accuseName);
    }

    @Override
    public CoRequestDTO findById(long id) {
        
        return dao.findById(id);
    }

    @Override
    public List<CoRequestDTO> findByRequestNumber(String requestNumber) {
        
        return dao.findByRequestNumber(requestNumber);
    }
}
