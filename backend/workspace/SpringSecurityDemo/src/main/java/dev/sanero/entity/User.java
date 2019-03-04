/**
 * Project name: Exam
 * Package name: dev.sanero.entity
 * File name: Users.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:51:31 PM
 */

package dev.sanero.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:51:31 PM
 * Description: TODO - Users entity. 
 */
@Entity(name = "users")
@Table(name = "users")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int userId;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:38 PM
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:49 PM
   */
  @Override
  public String toString() {
    return "Users [userId=" + userId + ", email=" + email + ", password="
        + password + "]";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:47 PM
   * Description: - .
   */
  public User() {
    super();
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:45 PM
   * Description: - .
   * @param userId - user id.
   * @param email email.
   * @param password password.
   */
  public User(int userId, String email, String password) {
    super();
    this.userId = userId;
    this.email = email;
    this.password = password;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:38 PM
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:38 PM
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:38 PM
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:38 PM
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 1:52:38 PM
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
