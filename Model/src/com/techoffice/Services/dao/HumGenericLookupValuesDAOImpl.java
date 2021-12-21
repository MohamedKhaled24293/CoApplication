package com.techoffice.Services.dao;

import com.techoffice.Services.entity.HumGenericLookupValues;

import java.math.BigDecimal;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HumGenericLookupValuesDAOImpl implements HumGenericLookupValuesDAO {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Model");
    @Override
    public Map<String, Long> incommingEntity() {
EntityManager em=emf.createEntityManager();
em.getTransaction().begin();
               Map<String,Long> incommingEntity=new HashMap<>();
               String sqlquery = "SELECT e.valueTitle, e.id from HumGenericLookupValues e WHERE e.humGenericLookup.id=116";
               Query query =em.createQuery(sqlquery);
               List<Object[]> result = query.getResultList();
               for (Object[] res : result)
                   incommingEntity.put((String) res[0], ((Long)res[1]).longValue());
               em.close();
                return incommingEntity;
           }
    public Map<String, Long> receivingTypes() {
               EntityManager em=emf.createEntityManager();
               em.getTransaction().begin();
               Map<String,Long> receivingType=new HashMap<>();
               String sqlquery = "SELECT e.valueTitle, e.id from HumGenericLookupValues e WHERE e.humGenericLookup.id=56";
               Query query =em.createQuery(sqlquery);
               List<Object[]> result = query.getResultList();
               for (Object[] res : result)
                   receivingType.put((String) res[0], ((Long)res[1]).longValue());
               em.close();
                return receivingType;
           }
    
    public Map<String, Long> applicantTypes() {
        EntityManager em=emf.createEntityManager();
            em.getTransaction().begin();
        Map<String,Long> applicants=new HashMap<>();
        Query query=em.createQuery("SELECT e.valueTitle, e.id from HumGenericLookupValues e WHERE e.humGenericLookup.id= 50");
        List<Object[]> result = query.getResultList();
        for (Object[] res : result)
            applicants.put((String) res[0], ((Long)res[1]).longValue());
        em.close();
         return applicants;

    }


    @Override
    public Map<String, Long> applicantNationality() {
            EntityManager em=emf.createEntityManager();
            em.getTransaction().begin();
        Map<String,Long> nationality=new HashMap<>();
        Query query=em.createQuery("SELECT e.valueTitle, e.id from HumGenericLookupValues e WHERE e.humGenericLookup.id= 6");
        List<Object[]> result = query.getResultList();
        for (Object[] res : result)
            nationality.put((String) res[0], ((Long)res[1]).longValue());
        em.close();
         return nationality;
    }

    @Override
    public Map<String, Long> applicantGender() {
EntityManager em=emf.createEntityManager();
em.getTransaction().begin();
        Map<String,Long> gender=new HashMap<>();
        Query query=em.createQuery("SELECT e.valueTitle, e.id from HumGenericLookupValues e WHERE e.humGenericLookup.id= 7");
        List<Object[]> result = query.getResultList();
        for (Object[] res : result)
            gender.put((String) res[0], ((Long)res[1]).longValue());
        em.close();
        return gender;
    }
    
    
}
