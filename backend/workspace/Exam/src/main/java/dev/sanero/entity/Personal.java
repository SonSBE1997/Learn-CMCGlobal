/**
 * Project name: Exam
 * Package name: dev.sanero.entity
 * File name: Personal.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:43:24 PM
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
 * Created time: 2:43:24 PM
 * Description: TODO - 
 */
@Entity(name = "personal")
@Table(name = "personal")
public class Personal implements Serializable {
  private static final long serialVersionUID = 1L;

  // Attribute
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "personal_id")
  private int personalId;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "telephone")
  private String telephone;

  @Column(name = "address")
  private String address;

  @Column(name = "email")
  private String email;

  @Column(name = "description")
  private String description;

  @Column(name = "hobbie")
  private String hobbie;

  public String getHobbie() {
    return hobbie;
  }

  public void setHobbie(String hobbie) {
    this.hobbie = hobbie;
  }

  // Getter and setter
  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @return the personalId
   */
  public int getPersonalId() {
    return personalId;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @param personalId the personalId to set
   */
  public void setPersonalId(int personalId) {
    this.personalId = personalId;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @return the telePhone
   */
  public String getTelephone() {
    return telephone;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @param telePhone the telePhone to set
   */
  public void setTelephone(String telePhone) {
    this.telephone = telePhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:50 PM
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:54 PM
   * Description: - .
   * @param personalId - id.
   * @param firstName - firstname.
   * @param lastname last name.
   * @param telePhone telephone.
   * @param address - address.
   * @param description - description.
   */
  public Personal(int personalId, String firstName, String lastname,
      String telePhone, String address, String description) {
    super();
    this.personalId = personalId;
    this.firstName = firstName;
    this.lastName = lastname;
    this.telephone = telePhone;
    this.address = address;
    this.description = description;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:44:56 PM
   * Description: - .
   */
  public Personal() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return "Personal [personalId=" + personalId + ", firstName=" + firstName
        + ", lastname=" + lastName + ", telePhone=" + telephone + ", address="
        + address + ", description=" + description + "]";
  }

}
