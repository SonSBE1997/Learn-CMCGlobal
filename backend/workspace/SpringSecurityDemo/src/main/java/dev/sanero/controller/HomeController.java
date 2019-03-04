/**
 * Project name: Exam
 * Package name: dev.sanero.controller
 * File name: HomeController.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:38:35 PM
 */

package dev.sanero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:38:35 PM
 * Description: TODO - 
 */
@Controller
public class HomeController {
  @RequestMapping("/")
  public String home() {
    return "home";
  }
}
