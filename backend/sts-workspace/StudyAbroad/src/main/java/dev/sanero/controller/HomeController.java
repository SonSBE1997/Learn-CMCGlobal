/**
 * Project name: StudyAbroad
 * Package name: dev.sanero.controller
 * File name: HomeController.java
 * Author: Sanero.
 * Created date: Jan 9, 2019
 * Created time: 12:58:34 PM
 */

package dev.sanero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Sanero.
 * Created date: Jan 9, 2019
 * Created time: 12:58:34 PM
 * Description: TODO - Home controller.
 */
@Controller
@RequestMapping("/")
public class HomeController {
  @GetMapping
  public String hello(ModelMap model) {
    model.addAttribute("user", "Samy");
    return "index";
  }
}
