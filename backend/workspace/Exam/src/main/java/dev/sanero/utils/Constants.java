/**
 * Project name: Exam
 * Package name: dev.sanero.utils
 * File name: Constants.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:32:39 PM
 */

package dev.sanero.utils;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:32:39 PM
 * Description: TODO - Constant purpose. 
 */
public interface Constants {
  public static final String SESSION_NAME = "userLogin";
  public static final int PAGE_SIZE = 2;

  /*
   * @author Sanero.
   * Created date: Jan 15, 2019
   * Created time: 4:49:46 PM
   * Description: TODO - personal constant.
   */
  interface Personal {
    public static final String FILTER = "from personal where first_name like :filter1 "
        + "or last_name like :filter2 "
        + "or telephone like :filter3 or address like :filter4 "
        + "or hobbie like :filter5 or description like :filter6";
  }

  /*
   * @author Sanero.
   * Created date: Jan 15, 2019
   * Created time: 4:50:19 PM
   * Description: TODO - validate
   */
  interface Validate {
    public static final String MESS_FIRST_NAME = "Personal.FirstName.field.required";
    public static final String MESS_LAST_NAME = "Personal.LastName.field.required";
    public static final String MESS_EMAIL = "Personal.Email.field.required";
    public static final String MESS_TELEPHONE = "Personal.Telephone.field.required";
    public static final String MESS_ADDRESS = "Personal.Address.field.required";
    public static final String MESS_HOBBIES = "Personal.Hobbies.field.required";

  }

  /*
   * @author Sanero.
   * Created date: Jan 24, 2019
   * Created time: 2:40:44 PM
   * Description: TODO - constant sign up
   */
  interface SignUp {
    public static final String VALIDATE_PASSWORD_NOT_MATCH = "Two password not match";
    public static final String VALIDATE_PASSWORD_REQUIRED = "Password must has length"
        + " between 1 and 50";
    public static final String VALIDATE_ACCOUNT_EXISTED = "Account was existed";
    public static final String VALIDATE_EMAIl_REQUIRED = "Email must has length between 1 and 50";
    public static final String VALIDATE_EMAIl = "Email not match (email must be "
        + "[a..Z][0..9]@[a-Z]) - ex: vsson@cmc.com";
  }

  /*
   * @author Sanero.
   * Created date: Jan 24, 2019
   * Created time: 2:46:04 PM
   * Description: TODO - login constant
   */
  interface Login {
    public static final String ACCOUNT_NOT_EXITST = "Account not exist";
    public static final String LOGIN_FAILED = "Email or password incorrect";
  }
}
