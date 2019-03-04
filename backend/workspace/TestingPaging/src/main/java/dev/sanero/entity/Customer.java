/**
 * Project name: TestingPaging
 * Package name: dev.sanero.entity
 * File name: Customer.java
 * Author: Sanero.
 * Created date: Jan 28, 2019
 * Created time: 2:02:30 PM
 */

package dev.sanero.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "address")
  private String address;

  /**
   * Author: Sanero.
   * Created date: Jan 28, 2019
   * Created time: 2:10:54 PM
   * Description: - .
   */
  public Customer() {
    super();
    // TODO Auto-generated constructor stub
  }

  // getter - setter
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 28, 2019
   * Created time: 2:05:47 PM
   * Description: - .
   * @param name
   * @param address
   */
  public Customer(String name, String address) {
    super();
    this.name = name;
    this.address = address;
  }
}