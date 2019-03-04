/**
 * Project name: Exam
 * Package name: dev.sanero.repository
 * File name: PersonalRepository.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:47:53 PM
 */

package dev.sanero.repository;

import dev.sanero.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:47:53 PM
 * Description: TODO - personal repository.
 */
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

}
