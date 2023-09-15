package com.hasan.foraty.springmapping;

import com.hasan.foraty.springmapping.dao.AppDAO;
import com.hasan.foraty.springmapping.entity.Instructor;
import com.hasan.foraty.springmapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
      deleteInstructor(appDAO);
    };
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
//    Instructor tempInstructor = new Instructor("chand","Darby","darby@luv2code.com");
//
//    InstructorDetail tempInstructorDetail = new InstructorDetail(
//        "http://www.luv2code.com/youtube",
//        "Luv 2 code !!!"
//    );



    Instructor tempInstructor = new Instructor("hasan","forat","forat@luv2code.com");

    InstructorDetail tempInstructorDetail = new InstructorDetail(
        "http://www.hasanforaty.com/youtube",
        "Chess,programming "
    );

    tempInstructor.setInstructorDetail(tempInstructorDetail);



    System.out.println("Saving Instructor "+tempInstructor);
    appDAO.save(tempInstructor);


    System.out.println("Done....");
  }


}
