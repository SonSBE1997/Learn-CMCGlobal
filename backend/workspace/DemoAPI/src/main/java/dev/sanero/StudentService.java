/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: StudentService.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 4:35:31 PM
 */

package dev.sanero;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author Sanero.
 * Created date: Feb 9, 2019
 * Created time: 4:35:31 PM
 * Description: TODO - 
 */
@Service
@Transactional
public class StudentService {
  @Autowired
  StudentRepo repo;

  public List<Student> findAll() {
    return repo.findAll();
  }
}
