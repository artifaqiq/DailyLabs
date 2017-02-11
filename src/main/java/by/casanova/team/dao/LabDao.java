package by.casanova.team.dao;

import by.casanova.team.models.labs.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artifaqiq on 2/11/17.
 */
@Repository
@Transactional
public class LabDao {

    @Autowired
    private EntityManager entityManager;

    public long persist(Lab lab) {

        entityManager.getTransaction().begin();
        entityManager.persist(lab);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return lab.getId();

    }

    public List<Lab> getAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Lab> from = criteriaQuery.from(Lab.class);

        CriteriaQuery<Object> select = criteriaQuery.select(from);

        entityManager.getTransaction().begin();
        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();
        entityManager.getTransaction().commit();

        List<Lab> labs = new ArrayList<>();
        for(Object obj : resultList) {
            labs.add((Lab) obj);
        }

        return labs;

    }
}
