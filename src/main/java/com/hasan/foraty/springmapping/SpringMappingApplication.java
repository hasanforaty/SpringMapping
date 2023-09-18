package com.hasan.foraty.springmapping;

import com.hasan.foraty.springmapping.dao.AppDAO;
import com.hasan.foraty.springmapping.entity.Course;
import com.hasan.foraty.springmapping.entity.Instructor;
import com.hasan.foraty.springmapping.entity.InstructorDetail;
import com.hasan.foraty.springmapping.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMappingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMappingApplication.class, args);
  }


  @Bean
  public CommandLineRunner commandLineRunner (AppDAO appDAO){
    return runner ->{
//      createInstructor(appDAO);
//      findInstructor(appDAO);
//      deleteInstructor(appDAO);
//      findInstructorDetail(appDAO);
//      deleteInstructorDetail(appDAO);
//      createInstructorWithCourses(appDAO);
//      findInstructorWithCourses(appDAO);
//      findCoursesForInstructor(appDAO);
//      findInstructorWithCoursesJoinFetch(appDAO);
//      updateInstructor(appDAO);
//      updateCourse(appDAO);
//      deleteCourseById(appDAO);
//      createCourseWithReview(appDAO);
//      retriveCourseAndReviews(appDAO);
//      deleteCourseAndReviews(appDAO);
    };
  }

  private void deleteCourseAndReviews(AppDAO appDAO) {
    int theId =10;
    System.out.println("deleting course id :"+theId);
    appDAO.deleteCourseById(theId);
  }

  private void retriveCourseAndReviews(AppDAO appDAO) {
    int theId = 10;
    System.out.println("Finding Course and reviews with id :"+theId);
    Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);
    System.out.println(tempCourse);
    System.out.println(tempCourse.getReviews());
    System.out.println("Done.......");

  }

  private void createCourseWithReview(AppDAO appDAO) {
    Course tempCourse = new Course("Pacman - how to score one Million Points");


    tempCourse.add(new Review("Great Course ... loved it "));
    tempCourse.add(new Review("cool Course , job well done."));
    tempCourse.add(new Review("what a dumb course , are you an idiot"));
    System.out.println("saving the course");
    System.out.println(tempCourse);
    System.out.println(tempCourse.getReviews());
    appDAO.save(tempCourse);
    System.out.println("Done.....");
  }

  private void deleteCourseById(AppDAO appDAO) {
    int theId = 10;
    System.out.println("Deleting course by Id : "+theId);
    appDAO.deleteCourseById(theId);
    System.out.println("Done....");
  }

  private void updateCourse(AppDAO appDAO) {
    int theId= 10;
    System.out.println("Finding course by Id : "+theId);
    Course tempCourse = appDAO.findCourseById(theId);
    System.out.println("Current Course : "+tempCourse);
    tempCourse.setTitle("Enjoy the simple things");
    appDAO.update(tempCourse);
  }

  private void updateInstructor(AppDAO appDAO) {
    int theId= 1;
    System.out.println("Finding Instructor id : "+theId);
    Instructor tempInstructor = appDAO.findInstructorById(theId);
    tempInstructor.setLastName("Tester");
    appDAO.update(tempInstructor);
    System.out.println("Updated....");
  }

  private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
    int theId = 1;
    System.out.println("Finding Instructor id : "+theId);
    Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
    System.out.println("Found Instructor : "+tempInstructor);
    System.out.println("The associated Courses "+tempInstructor.getCourses());

  }

  private void findCoursesForInstructor(AppDAO appDAO) {
    int id = 1;
    Instructor tempInstructor = appDAO.findInstructorById(id);
    System.out.println("TempInstructor : "+tempInstructor);

    System.out.println("Find courses by Instructor id : "+id);
    List<Course> courses = appDAO.findCoursesByInstructorId(id);
    tempInstructor.setCourses(courses);

    System.out.println("Finished Instructor " +tempInstructor+" With Courses : "+tempInstructor.getCourses());

    System.out.println("Done....!");
  }

  private void findInstructorWithCourses(AppDAO appDAO) {
    int id = 1;
    Instructor tempInstructor = appDAO.findInstructorById(id);
    System.out.println("TempInstructor : "+tempInstructor);
    System.out.println("the associated course : "+tempInstructor.getCourses());
    System.out.println("Done...!");
  }

  private void createInstructorWithCourses(AppDAO appDAO) {

    Instructor tempInstructor = new Instructor("Susan","Pofay","SusanPufforay@Gmail.com");

    InstructorDetail tempInstructorDetail = new InstructorDetail(
        "http://www.luv2code.com/youtube",
        "Gaming!"
    );



//    Instructor tempInstructor = new Instructor("hasan","forat","forat@luv2code.com");
//
//    InstructorDetail tempInstructorDetail = new InstructorDetail(
//        "http://www.hasanforaty.com/youtube",
//        "Chess,programming "
//    );

    tempInstructor.setInstructorDetail(tempInstructorDetail);
    Course tempCourse1 = new Course("Air bag making guide");
    Course tempCourse2 = new Course("Spring with charley");
    tempInstructor.add(tempCourse1);
    tempInstructor.add(tempCourse2);



    System.out.println("Saving Instructor "+tempInstructor);
    System.out.println("The courses : "+tempInstructor.getCourses());
    appDAO.save(tempInstructor);


    System.out.println("Done....");
  }

  private void deleteInstructorDetail(AppDAO appDAO) {
    int theId = 3;
    System.out.println("Delete Instructor Detail with Id : "+theId);
    appDAO.deleteInstructorDetailById(theId);
    System.out.println("Done....");
  }

  private void findInstructorDetail(AppDAO appDAO) {
    int theId = 2;
    System.out.println("Finding instructor detail with id : "+theId);
    InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
    System.out.println("Instructor Detail : "+instructorDetail);
    System.out.println("Associated Instructor : "+instructorDetail.getInstructor());

  }

  private void deleteInstructor(AppDAO appDAO) {
    int theId= 1;
    System.out.println("deleting instructor with id : "+theId);
    appDAO.deleteInstructorById(theId);
    System.out.println("Done.....");

  }

  private void findInstructor(AppDAO appDAO) {
    int theId =1;
    System.out.println("Find instructor with id : "+theId);
    Instructor tempInstructor = appDAO.findInstructorById(theId);
    System.out.println("temp instructor : "+tempInstructor);
    System.out.println("the associated InstructorDetail : "+tempInstructor.getInstructorDetail());


  }

  private void createInstructor(AppDAO appDAO) {
    Instructor tempInstructor = new Instructor("chand","Darby","darby@luv2code.com");

    InstructorDetail tempInstructorDetail = new InstructorDetail(
        "http://www.luv2code.com/youtube",
        "Luv 2 code !!!"
    );



//    Instructor tempInstructor = new Instructor("hasan","forat","forat@luv2code.com");
//
//    InstructorDetail tempInstructorDetail = new InstructorDetail(
//        "http://www.hasanforaty.com/youtube",
//        "Chess,programming "
//    );

    tempInstructor.setInstructorDetail(tempInstructorDetail);



    System.out.println("Saving Instructor "+tempInstructor);
    appDAO.save(tempInstructor);


    System.out.println("Done....");
  }

  /*
   * TODO 4 : create Main App
   */


}
