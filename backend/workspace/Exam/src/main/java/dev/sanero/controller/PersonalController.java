/**
 * Project name: Exam
 * Package name: dev.sanero.controller
 * File name: PersonalController.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:59:28 PM
 */

package dev.sanero.controller;

import dev.sanero.entity.Personal;
import dev.sanero.service.PersonalService;
import dev.sanero.utils.Constants;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 2:59:28 PM
 * Description: TODO - 
 */
@Controller
@RequestMapping("/admin/personal")
public class PersonalController {
  static final Logger LOGGER = LoggerFactory
      .getLogger(PersonalController.class);

  @Autowired
  PersonalService personalService;

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:41:05 AM
   * Description: TODO - show all personal.
   * @param model - Model Map.
   * @return page show.
   */
  @GetMapping
  public String showAll(ModelMap model) {
    List<Personal> personals = personalService.getAll();
    model.addAttribute("personals", personals);
    return "list-all";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 10:43:33 AM
   * Description: TODO - Show all information of personal.
   * @param personalId - personal id.
   * @param model - model map.
   * @return - page detail.
   */
  @GetMapping("/detail/{personalId}")
  public String detail(@PathVariable int personalId, ModelMap model) {
    Personal personal = personalService.findById(personalId);
    model.addAttribute("personal", personal);
    return "detail";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 1:31:41 PM
   * Description: TODO - show page create.
   * @return - page create.
   */
  @GetMapping("/add")
  public String create(ModelMap model) {
    model.addAttribute("personal", new Personal());
    return "create";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 1:31:39 PM
   * Description: TODO - handle create personal.
   * @param personal - personal information.
   * @param model - model map.
   * @return redirect to page list.
   */
  @PostMapping("/add")
  public String create(@ModelAttribute Personal personal, ModelMap model,
      @RequestParam String[] hobbies, BindingResult result) {
    boolean check = true;
    if (hobbies.length == 1) {
      model.addAttribute("mess", "U must select hobbies");
      check = false;
    } else {
      String[] listHobbies = Arrays.copyOfRange(hobbies, 1, hobbies.length);
      String hobbie = String.join(", ", listHobbies);
      personal.setHobbie(hobbie);
    }
    personalService.addNew(personal, result, check);
    if (result.hasErrors() || hobbies.length == 1) {
      return "create";
    }
    LOGGER.info("add personal");
    return "redirect:/admin/personal";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 2:52:30 PM
   * Description: TODO - .
   * @param id - personal id.
   * @return
   */
  @GetMapping("/edit/{id}")
  public String editpersonal(@PathVariable int id, ModelMap model) {
    Personal personal = personalService.findById(id);
    model.addAttribute("personal", personal);
    return "edit";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 3:28:18 PM
   * Description: TODO - .
   * @param personal - personal.
   * @return
   */
  @PostMapping("/edit")
  public String editpersonal(@ModelAttribute Personal personal,
      BindingResult result) {
    personalService.update(personal, result);
    if (result.hasErrors()) {
      return "edit";
    }
    LOGGER.warn("update personal has key: " + personal.getPersonalId());
    return "redirect:/admin/personal";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 2:52:30 PM
   * Description: TODO - .
   * @param id - personal id.
   * @return
   */
  @PostMapping("/delete")
  @ResponseBody
  public String delete(@RequestParam int id) {
    personalService.deleteById(id);
    LOGGER.warn("delete personal has key: " + id);
    return "success";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 5:09:53 PM
   * Description: TODO - filter.
   * @return
   */
  @GetMapping("/filter/{filter}")
  public String filter(@PathVariable String filter, ModelMap model) {
    List<Personal> personals = personalService.filter(filter);
    model.addAttribute("personals", personals);
    model.addAttribute("searchStr", filter);
    return "list-all";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 1:53:03 PM
   * Description: TODO - .
   * @param page - current page.
   * @param model - model map.
   * @return
   */
  @GetMapping("/{page}")
  public String showByPaging(@PathVariable int page, ModelMap model) {
    int pageSize = Constants.PAGE_SIZE;
    model.addAttribute("current", page);
    long total = personalService.countAll();
    int maxPage = (int) Math.ceil(((double) total) / pageSize);
    if (page > maxPage) {
      return "redirect:/admin/personal/1";
    }
    List<Personal> personals = personalService.getAllByPaging(page, pageSize);
    model.addAttribute("personals", personals);
    model.addAttribute("total", maxPage);
    return "list-paging";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 5:09:53 PM
   * Description: TODO - .
   * @param page - current page
   * @return
   */
  @GetMapping("/filterpaging/{filter}/{page}")
  public String filterByPaging(@PathVariable int page,
      @PathVariable String filter, ModelMap model) {
    int pageSize = Constants.PAGE_SIZE;
    List<Personal> personals = personalService.filterPaging(page, pageSize,
        filter);
    model.addAttribute("personals", personals);
    model.addAttribute("current", page);
    long total = personalService.filterCount(filter);
    int maxPage = (int) Math.ceil(((double) total) / pageSize);
    if (page > maxPage) {
      return "redirect:/admin/personal/filterpaging/" + filter + "/1";
    }
    model.addAttribute("total", maxPage);
    model.addAttribute("searchStr", filter);
    return "list-paging";
  }
}
