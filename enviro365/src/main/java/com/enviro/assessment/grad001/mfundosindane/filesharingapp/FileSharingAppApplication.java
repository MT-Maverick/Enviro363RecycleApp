package com.enviro.assessment.grad001.mfundosindane.filesharingapp;

/*Name: main
 * 
 * Purpose: to excecute the Springboot App
*/

//imported libraries:
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class FileSharingAppApplication {
  /* main function for application */
  public static void main(String[] args) {
    SpringApplication.run(FileSharingAppApplication.class, args);
  }

  /*
   * Java library to convert html post,delete,put or patch requests if
   * needed
   */
  @Bean
  public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
    return new HiddenHttpMethodFilter();
  }

}
