/**
 * Project name: Exam
 * Package name: dev.sanero.utils
 * File name: API.java
 * Author: Sanero.
 * Created date: Jan 24, 2019
 * Created time: 2:49:47 PM
 */

package dev.sanero.utils;

/*
 * @author Sanero.
 * Created date: Jan 24, 2019
 * Created time: 2:49:47 PM
 * Description: TODO - 
 */
public interface Api {
  public static String LOGIN = "/admin/login";
  public static String SIGNUP = "/signup";
  public static String HOME = "/";
  public static String ERROR = "/error";

  /*
   * @author Sanero.
   * Created date: Jan 24, 2019
   * Created time: 2:53:44 PM
   * Description: TODO - constant personal
   */
  interface Personal {
    public static String LIST = "/admin/personal";
    public static String DETAIL = "/detail/{personalId}";
    public static String CREATE = "/add";
    public static String EDIT = "/edit/{id}";
    public static String DETETE = "/delete";
  }
}
