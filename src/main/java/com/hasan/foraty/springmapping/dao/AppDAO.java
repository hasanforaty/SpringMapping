package com.hasan.foraty.springmapping.dao;


import com.hasan.foraty.springmapping.entity.Course;
import com.hasan.foraty.springmapping.entity.Instructor;
import com.hasan.foraty.springmapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO  {
  void save(Instructor theInstructor);
  Instructor findInstructorById(int theId);
  void deleteInstructorById(int theId);

  InstructorDetail findInstructorDetailById(int theId);
  void deleteInstructorDetailById(int theId);


  List<Course> findCoursesByInstructorId(int theId);

  Instructor findInstructorByIdJoinFetch(int theId);

}
