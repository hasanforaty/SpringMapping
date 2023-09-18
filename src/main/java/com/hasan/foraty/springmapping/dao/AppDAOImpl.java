package com.hasan.foraty.springmapping.dao;

import com.hasan.foraty.springmapping.entity.Course;
import com.hasan.foraty.springmapping.entity.Instructor;
import com.hasan.foraty.springmapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AppDAOImpl implements AppDAO {

  private final EntityManager entityManager;

  public AppDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Instructor theInstructor) {
    entityManager.persist(theInstructor);
  }

  @Override
  public Instructor findInstructorById(int theId) {
    return entityManager.find(Instructor.class,theId);
  }

  @Override
  @Transactional
  public void deleteInstructorById(int theId) {
    entityManager.remove(findInstructorById(theId));
  }

  @Override
  public InstructorDetail findInstructorDetailById(int theId) {
    return entityManager.find(InstructorDetail.class,theId);
  }

  @Override
  @Transactional
  public void deleteInstructorDetailById(int theId) {
    InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,theId);
    System.out.println("Start disconnecting Instructor ");
    instructorDetail.getInstructor().setInstructorDetail(null);
    System.out.println("Start removing Instructor Detail");
    entityManager.remove(instructorDetail);
  }

  @Override
  public List<Course> findCoursesByInstructorId(int theId) {

    TypedQuery<Course> result = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
    result.setParameter("data",theId);

    return result.getResultList();
  }

  @Override
  public Instructor findInstructorByIdJoinFetch(int theId) {

    TypedQuery<Instructor> query = entityManager.createQuery(
            "select i from Instructor i " +
                    "join fetch i.courses " +
                    "join fetch i.instructorDetail "+
                    "where i.id=:data"
            ,Instructor.class);
    query.setParameter("data",theId);

    return query.getSingleResult();
  }
}
