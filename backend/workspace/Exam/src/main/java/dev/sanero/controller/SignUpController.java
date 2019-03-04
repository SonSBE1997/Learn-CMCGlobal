/**
 * Project name: Exam
 * Package name: dev.sanero.controller
 * File name: SignupController.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:00:19 PM
 */

package dev.sanero.controller;

import dev.sanero.entity.User;
import dev.sanero.service.UserService;
import dev.sanero.utils.Constants;
import dev.sanero.utils.Encryptor;
import dev.sanero.utils.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:00:19 PM
 * Description: TODO - 
 */
@Controller
@RequestMapping("/signup")
@SessionAttributes(Constants.SESSION_NAME)
public class SignUpController {
  @Autowired
  UserService userService;
  static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:09:31 PM
   * Description: TODO - .
   * @return
   */
  @GetMapping
  public String signUp() {
    return "signup";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:06:17 PM
   * Description: TODO - .
   * @param user - user.
   * @param passwordConfirm - repassword.
   * @return
   */
  @PostMapping
  public String handleSignUp(ModelMap model, @ModelAttribute User user,
      @RequestParam String passwordConfirm, RedirectAttributes attributes) {
    String email = user.getEmail();
    if (email.length() > 50 || email.length() == 0) {
      attributes.addFlashAttribute("mess",
          Constants.SignUp.VALIDATE_EMAIl_REQUIRED);
      return "redirect:/signup";
    }

    if (!Validator.isValidateEmail(email)) {
      attributes.addFlashAttribute("mess", Constants.SignUp.VALIDATE_EMAIl);
      return "redirect:/signup";
    }

    User userLog = userService.findUserByEmail(email);
    if (userLog != null) {
      attributes.addFlashAttribute("mess",
          Constants.SignUp.VALIDATE_ACCOUNT_EXISTED);
      return "redirect:/signup";
    }

    String password = user.getPassword();
    if (password.length() > 50 || password.length() == 0) {
      attributes.addFlashAttribute("mess",
          Constants.SignUp.VALIDATE_PASSWORD_REQUIRED);
      return "redirect:/signup";
    }

    if (!password.equals(passwordConfirm)) {
      attributes.addFlashAttribute("mess",
          Constants.SignUp.VALIDATE_PASSWORD_NOT_MATCH);
      return "redirect:/signup";
    }

    user.setPassword(Encryptor.getMd5(passwordConfirm));
    userService.addUser(user);
    LOGGER.info("create new account: " + email);
    LOGGER.info("Account '" + email + "' login");
    model.addAttribute(Constants.SESSION_NAME, user);
    return "redirect:/admin/personal";
  }
}
