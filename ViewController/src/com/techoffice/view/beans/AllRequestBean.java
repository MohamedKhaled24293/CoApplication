package com.techoffice.view.beans;

import com.techoffice.Services.client.CoRequestClient;
import com.techoffice.Services.client.CoRequestClientImpl;
import com.techoffice.Services.client.GeneralClient;
import com.techoffice.Services.client.GeneralClientImpl;
import com.techoffice.Services.dto.CoRequestDTO;

import com.techoffice.Services.dto.CoRequestPartyDTO;

import com.techoffice.Services.dto.generic.SearchDTO;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "allRequestBean")
public class AllRequestBean {
    List<CoRequestDTO> reqDtoList =new ArrayList<>();
    Map<String,Long>countries=new HashMap<>();
    CoRequestClient reqClient=new CoRequestClientImpl();
    GeneralClient genClient=new GeneralClientImpl();
    CoRequestDTO reqDto=new CoRequestDTO();
    CoRequestPartyDTO reqPartyDto=new CoRequestPartyDTO(); 
    String searchName=null;
    String requestNumber=null;
    SearchDTO searchDto = new SearchDTO();
    @PostConstruct
    public void init() {

        reqDtoList=reqClient.findAllRequests(searchDto);    
      
    }
    
    public String search()     
    {   
        
        reqDtoList=reqClient.findRequestByName(searchName);
       return null;
    }
    public String searchByRequest()
    {
        reqDtoList=reqClient.findAllRequests(searchDto); 
        return null;
    }
    public String edit(CoRequestDTO reqEdit) {
        reqDto = reqEdit;
        return null;
    }

    public void setReqDtoList(List<CoRequestDTO> reqDtoList) {
        this.reqDtoList = reqDtoList;
    }

    public List<CoRequestDTO> getReqDtoList() {
        return reqDtoList;
    }

    public void setReqClient(CoRequestClient reqClient) {
        this.reqClient = reqClient;
    }

    public CoRequestClient getReqClient() {
        return reqClient;
    }

    public void setCountries(Map<String, Long> countries) {
        this.countries = countries;
    }

    public Map<String, Long> getCountries() {
        return countries;
    }

    public void setReqDto(CoRequestDTO reqDto) {
        this.reqDto = reqDto;
    }

    public CoRequestDTO getReqDto() {
        return reqDto;
    }


    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setSearchDto(SearchDTO searchDto) {
        this.searchDto = searchDto;
    }

    public SearchDTO getSearchDto() {
        return searchDto;
    }
}
