/**
 * Project name: DemoAPI
 * Package name: dev.sanero
 * File name: StudentRepo.java
 * Author: Sanero.
 * Created date: Feb 9, 2019
 * Created time: 4:34:54 PM
 */

package dev.sanero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Sanero.
 * Created date: Feb 9, 2019
 * Created time: 4:34:54 PM
 * Description: TODO - 
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
