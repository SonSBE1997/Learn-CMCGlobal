/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: ClassService.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 12:02:40 PM
 */

package dev.sanero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author Sanero.
 * Created date: Feb 9, 2019
 * Created time: 12:02:40 PM
 * Description: TODO - 
 */
@Service
public class ClassService {
  @Autowired
  ClassRepo repo;

  public List<Class> findAll() {
    return repo.findAll();
  }
}
