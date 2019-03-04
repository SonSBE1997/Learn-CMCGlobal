/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: Class.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 11:40:51 AM
 */

package dev.sanero;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author Sanero.
 * Created date: Feb 9, 2019
 * Created time: 11:40:51 AM
 * Description: TODO - 
 */
@Entity
@Table(name = "phone")
public class Phone implements Serializable {
  /**
   * attribute - .
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
//
//  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//  @JoinColumn(name = "phoneId")
//  private Set<Student> students;
//
//  public Set<Student> getStudents() {
//    return students;
//  }
//
//  public void setStudents(Set<Student> students) {
//    this.students = students;
//  }

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
