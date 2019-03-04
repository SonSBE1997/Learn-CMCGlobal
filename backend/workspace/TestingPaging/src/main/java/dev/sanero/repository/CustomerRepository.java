/**
 * Project name: TestingPaging
 * Package name: dev.sanero.repository
 * File name: CustomerRepository.java
 * Author: Sanero.
 * Created date: Jan 28, 2019
 * Created time: 2:03:24 PM
 */

package dev.sanero.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.sanero.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  @Query("SELECT e FROM Customer e")
  Page<Customer> findCustomers(Pageable pageable);
}
