/**
 * Project name: Exam
 * Package name: dev.sanero.utils
 * File name: Validator.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:15:32 PM
 */

package dev.sanero.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:15:32 PM
 * Description: TODO - validate.
 */
public class Validator {
  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:16:54 PM
   * Description: TODO - validate email.
   * @param email - validate.
   * @return
   */
  public static boolean isValidateEmail(String email) {
    Pattern pattern = Pattern
        .compile("^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{1,})$");
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 3:59:26 PM
   * Description: TODO - validate phone number.
   * @param phone - phone number.
   * @return
   */
  public static boolean isValidatePhoneNumber(String phone) {
    Pattern pattern = Pattern.compile("([0-9]{10,11})$");
    Matcher matcher = pattern.matcher(phone);
    return matcher.matches();
  }
}