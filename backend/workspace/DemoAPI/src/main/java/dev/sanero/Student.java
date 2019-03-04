/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: Student.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 11:42:41 AM
 */

package dev.sanero;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * @author Sanero.
 * Created date: Feb 9, 2019
 * Created time: 11:42:41 AM
 * Description: TODO - 
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {
  /**
   * attribute - .
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  @ManyToOne()
  @JoinColumn(name = "classId")
  private Class class1;

  @ManyToOne()
  @JoinColumn(name = "phoneId")
  private Phone phone;

  public Phone getPhone() {
    return phone;
  }

  public void setPhone(Phone phone) {
    this.phone = phone;
  }

  public Class getClass1() {
    return class1;
  }

  public void setClass1(Class class1) {
    this.class1 = class1;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
