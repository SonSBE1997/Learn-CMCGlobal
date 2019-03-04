/**
 * Project name: TestingPaging
 * Package name: dev.sanero.controller
 * File name: CustomerController.java
 * Author: Sanero.
 * Created date: Jan 28, 2019
 * Created time: 2:04:25 PM
 */

package dev.sanero.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.sanero.entity.Customer;
import dev.sanero.repository.CustomerRepository;

@Controller
public class CustomerController {
  @Autowired
  private CustomerRepository customerRepository;

  @PostConstruct
  public void initData() {
    System.out.println("__________Reset and init data________________");
    customerRepository.deleteAll();
    for (int i = 0; i < 100; i++) {
      customerRepository.save(new Customer("name" + i, "address" + i));
    }
  }

  @RequestMapping("/")
  public String listCustomer(Model model,
      @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
    Sort sortable = null;
    if (sort.equals("ASC")) {
      sortable = Sort.by("id").ascending();
    }
    if (sort.equals("DESC")) {
      sortable = Sort.by("id").descending();
    }
    Pageable pageable = PageRequest.of(page, size, sortable);

    model.addAttribute("listCustomer",
        customerRepository.findCustomers(pageable));
    return "customer-list";
  }
}