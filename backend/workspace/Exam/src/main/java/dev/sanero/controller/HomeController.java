/**
 * Project name: Exam
 * Package name: dev.sanero.controller
 * File name: HomeController.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:38:35 PM
 */

package dev.sanero.controller;

import dev.sanero.utils.Constants;
import javax.servlet.http.HttpSession;

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

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:27:57 PM
   * Description: TODO - logout.
   * @param session - http session.
   * @return
   */
  @RequestMapping("/admin/logout")
  public String handleLogout(HttpSession session) {
    if (session.getAttribute(Constants.SESSION_NAME) != null) {
      session.removeAttribute(Constants.SESSION_NAME);
    }
    return "redirect:/";
  }
}
