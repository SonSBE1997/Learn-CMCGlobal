/**
 * Project name: Exam
 * Package name: dev.sanero.service
 * File name: PersonalService.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:50:51 PM
 */

package dev.sanero.service;

import dev.sanero.entity.Personal;
import dev.sanero.repository.PersonalRepository;
import dev.sanero.utils.Constants;
import dev.sanero.utils.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:50:51 PM
 * Description: TODO - personal service.
 */
@Service
@Transactional
public class PersonalService {
  @Autowired
  EntityManager entityManager;
  @Autowired
  PersonalRepository personalRepository;

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:33:32 AM
   * Description: TODO - get all personal.
   * @return list personal.
   */
  public List<Personal> getAll() {
    return personalRepository.findAll();
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 1:48:56 PM
   * Description: TODO - get list news by page.
   * @param page - current page.
   * @param pageSize - size of one page.
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Personal> getAllByPaging(int page, int pageSize) {
    List<Personal> personals = new ArrayList<Personal>();
    Query query = entityManager.createQuery("from personal");
    query.setFirstResult((page - 1) * pageSize);
    query.setMaxResults(pageSize);
    personals = query.getResultList();
    return personals;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 1:57:46 PM
   * Description: TODO - count number of entity.
   * @return
   */
  public long countAll() {
    return personalRepository.count();
  }

  public Personal findById(int id) {
    Optional<Personal> personal = personalRepository.findById(id);
    return personal.get();
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:02:53 AM
   * Description: TODO - .
   * @param personal - object personal.
   * @param errors - error validation.
   */
  public void addNew(Personal personal, Errors errors, boolean hasHobbies) {
    validateData(personal, errors);
    if (errors.hasErrors() || !hasHobbies) {
      return;
    }
    personal = personalRepository.save(personal);
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:06:44 AM
   * Description: TODO - .
   * @param personal - personal object.
   * @param errors - errors validation.
   */
  private void validateData(Personal personal, Errors errors) {
    if (personal.getFirstName().length() > 20
        || personal.getFirstName().length() == 0) {
      errors.rejectValue("firstName", Constants.Validate.MESS_FIRST_NAME);
    }

    if (personal.getLastName().length() > 20
        || personal.getLastName().length() == 0) {
      errors.rejectValue("lastName", Constants.Validate.MESS_LAST_NAME);
    }
    String email = personal.getEmail();
    if (!Validator.isValidateEmail(email)) {
      errors.rejectValue("email", Constants.Validate.MESS_EMAIL);
    }

    if (!Validator.isValidatePhoneNumber(personal.getTelephone())) {
      errors.rejectValue("telephone", Constants.Validate.MESS_TELEPHONE);
    }

    if (personal.getAddress().isEmpty()) {
      errors.rejectValue("address", Constants.Validate.MESS_ADDRESS);
    }
    /*    if (personal.getHobbie().isEmpty()) {
      errors.rejectValue("hobbie", Constants.Validate.MESS_HOBBIES);
    } */
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:05:05 AM
   * Description: TODO - .
   * @param personal - personal object.
   */
  public void update(Personal personal, Errors errors) {
    validateData(personal, errors);
    if (errors.hasErrors()) {
      return;
    }
    personal = personalRepository.save(personal);
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:05:14 AM
   * Description: TODO - .
   * @param id - news id.
   */
  public void deleteById(int id) {
    personalRepository.deleteById(id);
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 4:59:38 PM
   * Description: TODO - .
   * @param charSequence - char sequence filter.
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Personal> filter(String charSequence) {
    charSequence = "%" + charSequence + "%";
    Query query = entityManager.createQuery(Constants.Personal.FILTER);
    query.setParameter("filter1", charSequence);
    query.setParameter("filter2", charSequence);
    query.setParameter("filter3", charSequence);
    query.setParameter("filter4", charSequence);
    query.setParameter("filter5", charSequence);
    query.setParameter("filter6", charSequence);
    List<Personal> personals = new ArrayList<Personal>();
    personals = query.getResultList();
    return personals;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 5:05:27 PM
   * Description: TODO - .
   * @param charSequence - char sequence to filter.
   * @return
   */
  public long filterCount(String charSequence) {
    charSequence = "%" + charSequence + "%";
    Query query = entityManager
        .createQuery("select count (personal_id) " + Constants.Personal.FILTER);
    query.setParameter("filter1", charSequence);
    query.setParameter("filter2", charSequence);
    query.setParameter("filter3", charSequence);
    query.setParameter("filter4", charSequence);
    query.setParameter("filter5", charSequence);
    query.setParameter("filter6", charSequence);
    long result = 0;
    try {
      result = (Long) query.getSingleResult();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 4:59:38 PM
   * Description: TODO - .
   * @param charSequence - char sequence filter.
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Personal> filterPaging(int page, int pageSize,
      String charSequence) {
    charSequence = "%" + charSequence + "%";
    Query query = entityManager.createQuery(Constants.Personal.FILTER);
    query.setParameter("filter1", charSequence);
    query.setParameter("filter2", charSequence);
    query.setParameter("filter3", charSequence);
    query.setParameter("filter4", charSequence);
    query.setParameter("filter5", charSequence);
    query.setParameter("filter6", charSequence);
    query.setFirstResult((page - 1) * pageSize);
    query.setMaxResults(pageSize);
    List<Personal> personals = new ArrayList<Personal>();
    personals = query.getResultList();
    return personals;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 5:05:27 PM
   * Description: TODO - .
   * @param charSequence - char sequence to filter.
   * @return
   */
  public long filterCountPaging(int page, int pageSize, String charSequence) {
    charSequence = "%" + charSequence + "%";
    Query query = entityManager
        .createQuery("select count (personal_id) " + Constants.Personal.FILTER);
    query.setParameter("filter1", charSequence);
    query.setParameter("filter2", charSequence);
    query.setParameter("filter3", charSequence);
    query.setParameter("filter4", charSequence);
    query.setParameter("filter5", charSequence);
    query.setParameter("filter6", charSequence);
    query.setFirstResult((page - 1) * pageSize);
    query.setMaxResults(pageSize);
    long result = 0;
    try {
      result = (Long) query.getSingleResult();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }
}
