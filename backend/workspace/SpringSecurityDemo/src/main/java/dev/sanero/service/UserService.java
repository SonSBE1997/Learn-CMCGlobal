/**
 * Project name: Exam
 * Package name: dev.sanero.service
 * File name: UserService.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:56:10 PM
 */

package dev.sanero.service;

import dev.sanero.entity.User;
import dev.sanero.repository.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:56:10 PM
 * Description: TODO - 
 */
@Service
@Transactional
public class UserService {
  @Autowired
  UserRepository userRepository;

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:30:04 PM
   * Description: TODO - find user by email and password .
   * @param email - user email.
   * @param password - password user.
   * @return
   */
  public User findUserByEmailAndPassword(String email, String password) {
    return userRepository.findUserByEmailAndPassword(email, password);
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:30:39 PM
   * Description: TODO - .
   * @param email user email.
   * @return
   */
  public User findUserByEmail(String email) {
    return userRepository.findUserByEmail(email);
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 2:30:50 PM
   * Description: TODO - add new user.
   * @param user - user.
   */
  public void addUser(User user) {
    user = userRepository.save(user);
  }
}
