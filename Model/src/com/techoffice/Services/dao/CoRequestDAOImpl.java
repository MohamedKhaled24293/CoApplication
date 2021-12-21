package com.techoffice.Services.dao;

import com.techoffice.Mapping.ConvertUtil;
import com.techoffice.Services.dto.CoRequestDTO;
import com.techoffice.Services.dto.generic.SearchDTO;
import com.techoffice.Services.entity.CoRequest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class CoRequestDAOImpl implements CoRequestDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Model");
    static EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("Model");

    @Override
    public List<CoRequestDTO> findPetitonId(String petNumber) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sqlquery = ("select e from CoRequest e where e.petitionNumber='" + petNumber + "'");
        Query query = em.createQuery(sqlquery);
        List<CoRequestDTO> result = query.getResultList();
        em.close();


        return result;
    }

//public static void main(String[] args) {
//       EntityManager em = emf2.createEntityManager();
//       em.getTransaction().begin();
//       String sqlquery = ("Select e from CoRequest e where e.id =:id");
//       Query query = em.createQuery(sqlquery);
//       query.setParameter("id", 818L);
//       List<CoRequest> result =  query.getResultList();
//       CoRequest req = result.get(0);
////       em.getTransaction().rollback();
//       req.getCoPartyList().get(0).setName("belal3");
////       em.merge(req);
////       em.getTransaction().commit();
//      em.close();
//      add1(req);
//       
//   }
    @Override
    public CoRequestDTO add(CoRequestDTO reqDto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CoRequest coRec = ConvertUtil.convertToEntity(reqDto, CoRequest.class);
        em.merge(coRec);
        em.getTransaction().commit();
        em.close();
        return ConvertUtil.convertToDto(coRec, CoRequestDTO.class);
    }
    public  CoRequestDTO add1(CoRequest coRec) {
        EntityManager em = emf2.createEntityManager();
        em.getTransaction().begin();
        em.merge(coRec);
        em.getTransaction().commit();
        em.close();
        return ConvertUtil.convertToDto(coRec, CoRequestDTO.class);
    }

    //    @Override
    //    public List<CoRequestDTO> findAllRequests() {
    //        EntityManager em = emf.createEntityManager();
    //        em.getTransaction().begin();
    //        Query query = em.createQuery("select e from CoRequest e , e.coPartyList b,e.coApplicanstList c where b.id != null and c.id != null");
    //        List<CoRequest> list = query.getResultList();
    //        em.close();
    //        return ConvertUtil.convertToDtoList((List) list, (Class) CoRequestDTO.class);
    //    }
    @Override
    public List<CoRequestDTO> findAllRequests(SearchDTO searchDto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        StringBuilder build = new StringBuilder();
        build.append("select e from CoRequest e , e.coPartyList b,e.coApplicanstList c where b.id != null and c.id != null");
        if (searchDto != null) {
            if (searchDto.getAccusedName() != null && !searchDto.getAccusedName().isEmpty())
                build.append(" and b.name LIKE :accuseName");
                if (searchDto.getApplicantName() != null && !searchDto.getApplicantName().isEmpty())
                build.append(" and c.name LIKE :applicantName");
                if (searchDto.getRequestNumber() != null && !searchDto.getRequestNumber().isEmpty())
                build.append(" and e.requestNumber LIKE :reqnum");
        }
        System.err.println(build.toString());
        Query query = em.createQuery(build.toString());
        if (searchDto != null) {
            if (searchDto.getAccusedName() != null && !searchDto.getAccusedName().isEmpty())
                query.setParameter("accuseName", searchDto.getAccusedName());
            if (searchDto.getApplicantName() != null && !searchDto.getApplicantName().isEmpty())
                query.setParameter("applicantName", searchDto.getApplicantName());
            if (searchDto.getRequestNumber() != null && !searchDto.getRequestNumber().isEmpty())
                query.setParameter("reqnum", searchDto.getRequestNumber());

        }
        System.err.println(query.toString());
        List<CoRequest> list = query.getResultList();
        em.close();
        return ConvertUtil.convertToDtoList((List) list, (Class) CoRequestDTO.class);
    }

    @Override
    public List<CoRequestDTO> findRequestByName(String accuseName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sqlquery =
            ("Select e from CoRequest e ,e.coApplicanstList c, e.coPartyList b where b.name LIKE :accuseName");
        Query query = em.createQuery(sqlquery);
        query.setParameter("accuseName", accuseName);
        List<CoRequest> req = query.getResultList();
        em.close();
        return ConvertUtil.convertToDtoList((List) req, (Class) CoRequestDTO.class);
    }


    @Override
    public CoRequestDTO findById(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sqlquery = ("Select e from CoRequest e where e.id =:id");
        Query query = em.createQuery(sqlquery);
        query.setParameter("id", id);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<CoRequest> result =  query.getResultList();
        if(result.isEmpty())
        return null;
        
        CoRequestDTO resultDto = ConvertUtil.convertToDto(result.get(0), CoRequestDTO.class);
        return resultDto;

    }

    @Override
    public List<CoRequestDTO> findByRequestNumber(String requestNumber) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sqlquery =
            ("Select e from CoRequest e ,e.coApplicanstList c, e.coPartyList b where e.requestNumber=:requestNumber");
        Query query = em.createQuery(sqlquery);
        query.setParameter("requestNumber", requestNumber);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<CoRequest> req = query.getResultList();
        em.close();
        return ConvertUtil.convertToDtoList((List) req, (Class) CoRequestDTO.class);
    }
}
