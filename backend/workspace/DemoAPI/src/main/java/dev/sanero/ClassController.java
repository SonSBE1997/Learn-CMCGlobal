/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: ClassController.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 12:03:27 PM
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
 * Created time: 12:03:27 PM
 * Description: TODO - 
 */
@Controller
public class ClassController {
  @Autowired
  ClassService service;

  @RequestMapping("/class")
  @ResponseBody
  public List<Class> getAll() {
    return service.findAll();
  }
}
