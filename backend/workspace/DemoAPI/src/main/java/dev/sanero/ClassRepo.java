/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: ClassRepo.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 12:01:45 PM
 */

package dev.sanero;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Sanero.
 * Created date: Feb 9, 2019
 * Created time: 12:01:45 PM
 * Description: TODO - 
 */
@Repository
@Transactional
public interface ClassRepo extends JpaRepository<Class, Integer> {

}
