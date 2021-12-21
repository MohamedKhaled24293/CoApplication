package com.techoffice.Services.service;

import com.techoffice.Services.dto.CoRequestDTO;

import com.techoffice.Services.dto.CoRequestPartyDTO;

import com.techoffice.Services.dto.generic.SearchDTO;

import java.util.List;

public interface CoRequestService {
    List<CoRequestDTO> findPetitonId(String petNumber);
    public CoRequestDTO add(CoRequestDTO reqDto);
    List<CoRequestDTO> findAllRequests(SearchDTO searchDto);
    List<CoRequestDTO> findRequestByName(String accuseName);
    List<CoRequestDTO> findByRequestNumber(String requestNumber);
    CoRequestDTO findById(long id);



}
