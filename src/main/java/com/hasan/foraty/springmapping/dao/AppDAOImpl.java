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

    Instructor tempInstructor = entityManager.find(Instructor.class,theId);
    List<Course> courses = tempInstructor.getCourses();
    for (Course course : courses){
      course.setInstructor(null);
    }
    entityManager.remove(tempInstructor);
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

  @Override
  @Transactional
  public void update(Instructor tempInstructor) {
    entityManager.merge(tempInstructor);
  }

  @Override
  @Transactional
  public void update(Course tempCourse) {
    entityManager.merge(tempCourse);
  }

  @Override
  public Course findCourseById(int theId) {
    return entityManager.find(Course.class,theId);
  }

  @Override
  @Transactional
  public void deleteCourseById(int theId) {
    Course tempCourse = entityManager.find(Course.class,theId);
    entityManager.remove(tempCourse);
  }

  @Override
  @Transactional
  public void save(Course theCourse) {
    entityManager.persist(theCourse);
  }

  @Override
  public Course findCourseAndReviewByCourseId(int theId) {
    TypedQuery<Course> query = entityManager.createQuery(
            "select i from Course i " +
                    " join fetch i.reviews " +
                    " where i.id =:data",
            Course.class
    );
    query.setParameter("data",theId);
    return query.getSingleResult();
  }
}
