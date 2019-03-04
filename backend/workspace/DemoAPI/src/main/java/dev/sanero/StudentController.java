/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: StudentController.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 4:36:35 PM
 */

package dev.sanero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @author Sanero.
 * Created date: Feb 9, 2019
 * Created time: 4:36:35 PM
 * Description: TODO - 
 */
@Controller
public class StudentController {
  @Autowired
  StudentService service;

  @RequestMapping("student")
  @ResponseBody
  public List<Student> getAll() {
    return service.findAll();
  }
}
