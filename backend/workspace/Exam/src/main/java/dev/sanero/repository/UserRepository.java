/**
 * Project name: Exam
 * Package name: dev.sanero.repository
 * File name: UserRepository.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:55:08 PM
 */

package dev.sanero.repository;

import dev.sanero.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 1:55:08 PM
 * Description: TODO - user repository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
  User findUserByEmailAndPassword(String email, String password);

  User findUserByEmail(String email);
}
