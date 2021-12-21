package com.techoffice.Services.dao;

import com.techoffice.Mapping.ConvertUtil;
import com.techoffice.Services.dto.CoRequestPartyDTO;
import com.techoffice.Services.entity.CoRequestParty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CoRequestPartyDAOImpl implements CoRequestPartyDAO {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("Model");
    
    @Override
    public CoRequestPartyDTO add(CoRequestPartyDTO reqDto) {
           EntityManager em=emf.createEntityManager();   
         em.getTransaction().begin();
        CoRequestParty coRec =ConvertUtil.convertToEntity(reqDto, CoRequestParty.class);
         em.persist(coRec);
        em.close();
        return ConvertUtil.convertToDto(coRec, CoRequestPartyDTO.class);
    }
}

