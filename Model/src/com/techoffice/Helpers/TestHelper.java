package com.techoffice.Helpers;

import com.techoffice.Mapping.ConvertUtil;
import com.techoffice.Services.client.CoRequestClient;
import com.techoffice.Services.client.CoRequestClientImpl;
import com.techoffice.Services.client.GeneralClient;
import com.techoffice.Services.client.GeneralClientImpl;

import com.techoffice.Services.dao.CoRequestDAO;
import com.techoffice.Services.dao.CoRequestDAOImpl;
import com.techoffice.Services.dto.CoRequestDTO;

import com.techoffice.Services.entity.CoRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestHelper {
    public static void main(String[] args) {
//        Map<String,Long> countries =new HashMap<>();
//        GeneralClient genClient=new GeneralClientImpl();
//        System.out.println(genClient.fetchCountry());
        CoRequestClient cli =new CoRequestClientImpl();
        CoRequestDTO dto = cli.findById(818L);
          dto.getCoPartyList().get(0).setName("Khaled6");
//        System.err.println(";;; "+dto.getCoapplicantList().get(0).getId());
//          dto.getCoapplicantList().get(0).setName("momo");
          CoRequestDAOImpl d = new CoRequestDAOImpl();
          CoRequest r = ConvertUtil.convertToEntity(dto, CoRequest.class);
          System.err.println(r.getCoapplicantList().size());
         d.add1(r);
    }
}
