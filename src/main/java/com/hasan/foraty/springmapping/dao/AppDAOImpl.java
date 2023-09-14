package com.hasan.foraty.springmapping.dao;

import com.hasan.foraty.springmapping.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
}
