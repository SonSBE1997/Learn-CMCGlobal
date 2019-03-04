DROP DATABASE IF EXISTS TESTING_SYSTEM_DATABASE;
CREATE DATABASE TESTING_SYSTEM_DATABASE;
USE TESTING_SYSTEM_DATABASE;
CREATE TABLE  question_type  (
   type_id INT(11) AUTO_INCREMENT PRIMARY KEY,
   type_name VARCHAR(255) ,
   `status` INT(11)  
);

CREATE TABLE  answer(
   answer_id VARCHAR(255) PRIMARY KEY,
   content  TEXT,
   is_true  BIT(1),
   `status` INT(11),
   question_id VARCHAR(255)  
);

CREATE TABLE  exam  (
   exam_id VARCHAR(255) PRIMARY KEY,
   title VARCHAR(100),
   duration FLOAT  ,
   category_id INT(11)  ,
   note TEXT  ,
   `status` ENUM('Draft','Public') default 'Draft',  
   is_enable BIT(1)  ,
   number_of_question INT(11)  ,
   create_at DATETIME DEFAULT NOW(),
   create_by INT(11),
   modified_at DATETIME null,
   modified_by INT(11) null
);

CREATE TABLE  tag  (
   tag_id INT(11)  AUTO_INCREMENT PRIMARY KEY  ,
   tag_name VARCHAR(255) NOT NULL,
   `status` INT(11)  
);

CREATE TABLE  exam_question  (
   id int auto_increment primary key,
   exam_id VARCHAR(255)  ,
   question_id VARCHAR(255),
   choice_order text
);

CREATE TABLE  question_level  (
   level_id INT(11) AUTO_INCREMENT PRIMARY KEY,
   level_name VARCHAR(255) NOT NULL,
   `status` INT(11)  
);

CREATE TABLE  question(
   question_id VARCHAR(255)  PRIMARY KEY,
   category_id INT(11),
   content TEXT,
   type_id INT(11),
   level_id INT(11),
   sugguestion TEXT,
   tag_id INT(11),
   `status` INT(11),
   user_id_created INT(11),
   date_created DATETIME DEFAULT NOW()
);

CREATE TABLE  category  (
   category_id  INT(11) AUTO_INCREMENT PRIMARY KEY,
   category_name VARCHAR(255),
   user_id_created INT(11),
   date_created DATETIME DEFAULT NOW(),
   `status` INT(11)  
);

CREATE TABLE  semester_exam  (
   semester_exam_id VARCHAR(255) PRIMARY KEY NOT NULL,
   semester_exam_name VARCHAR(255) NOT NULL,
   semester_description VARCHAR(255) NOT NULL,
	create_by INT(11),
   `status` BIT(1),
   start_at DATETIME DEFAULT NOW(),
   end_at DATETIME DEFAULT NOW() 
);

CREATE TABLE `testing_system_database`.`semester_exam_code` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `semester_exam_codecol` VARCHAR(255) NULL,
  `semester_exam_id` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_semesterexam_semesterexamcode_idx` (`semester_exam_id` ASC) VISIBLE,
  CONSTRAINT `fk_semesterexam_semesterexamcode`
    FOREIGN KEY (`semester_exam_id`)
    REFERENCES `testing_system_database`.`semester_exam` (`semester_exam_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE  candidate  (
   candidate_id INT(11) AUTO_INCREMENT  PRIMARY KEY,
   semester_exam_id VARCHAR(255),
   user_id INT(11)
);

CREATE TABLE  test  (
   test_id INT(11) AUTO_INCREMENT  PRIMARY KEY,
	candidate_id INT(11),
   exam_id VARCHAR(255),
   semester_exam_id VARCHAR(255),
   test_name VARCHAR(255),
   `status` INT(11)
);

CREATE TABLE  candidate_test  (
   candidate_test_id INT(11) AUTO_INCREMENT  PRIMARY KEY,
	candidate_id INT(11),
    test_id INT(11),
   start_time DATETIME DEFAULT NOW(),
   end_time DATETIME,
   correct_number INT(11)
);

CREATE TABLE  test_result  (
   test_result_id INT(11) AUTO_INCREMENT  PRIMARY KEY,
	candidate_test_id INT(11),
    test_id INT(11),
    question_id VARCHAR(255),
    answer_id VARCHAR(255)
);


CREATE TABLE  `user`  (
   user_id INT(11) AUTO_INCREMENT  PRIMARY KEY,
   full_name VARCHAR(255)  ,
   email VARCHAR(100)  ,
   mobile VARCHAR(11)  ,
   `password` VARCHAR(255)  ,
   `status` INT(11)  
);

CREATE TABLE  `group`  (
   group_id INT(11) AUTO_INCREMENT PRIMARY KEY ,
   group_name VARCHAR(255)  ,
   create_by INT(11)  ,
   create_date DATETIME DEFAULT NOW()
);

CREATE TABLE  user_group(
   user_id INT(11),
   group_id INT(11),
   PRIMARY KEY (user_id, group_id)
);

CREATE TABLE  role  (
   role_id INT(11) AUTO_INCREMENT PRIMARY KEY,
   role_name VARCHAR(255)  
);

CREATE TABLE  user_role  (
   user_id INT(11),
   role_id INT(11),
   PRIMARY KEY (user_id, role_id)
);

CREATE TABLE  menu  (
   menu_id INT(11) AUTO_INCREMENT PRIMARY KEY,
   menu_name VARCHAR(255),
   menu_description VARCHAR(255),
   menu_function VARCHAR(155)  
);

CREATE TABLE  role_menu  (
   role_id INT(11),
   menu_id INT(11),
   PRIMARY KEY (role_id, menu_id)
);

-- FK của answer
ALTER TABLE answer
ADD FOREIGN KEY (question_id) REFERENCES question(question_id); 

-- FK của exam
ALTER TABLE exam
ADD FOREIGN KEY (category_id) REFERENCES category(category_id); 
ALTER TABLE exam
ADD FOREIGN KEY (create_by) REFERENCES user(user_id); 
ALTER TABLE exam
ADD FOREIGN KEY (modified_by) REFERENCES user(user_id); 

-- FK của exam_question
ALTER TABLE exam_question
ADD FOREIGN KEY (exam_id) REFERENCES exam(exam_id); 
ALTER TABLE exam_question
ADD FOREIGN KEY (question_id) REFERENCES question(question_id); 

-- FK của question
ALTER TABLE question 
ADD FOREIGN KEY (category_id) REFERENCES category(category_id); 
ALTER TABLE question 
ADD FOREIGN KEY (type_id) REFERENCES question_type(type_id); 
ALTER TABLE question 
ADD FOREIGN KEY (level_id) REFERENCES question_level(level_id); 
ALTER TABLE question 
ADD FOREIGN KEY (tag_id) REFERENCES tag(tag_id); 
ALTER TABLE question 
ADD FOREIGN KEY (user_id_created) REFERENCES `user`(user_id); 

-- FK của category
ALTER TABLE category
ADD FOREIGN KEY (user_id_created) REFERENCES `user`(user_id); 

-- FK của test_result
ALTER TABLE test_result
ADD FOREIGN KEY (candidate_test_id ) REFERENCES candidate_test(candidate_test_id ); 
ALTER TABLE test_result
ADD FOREIGN KEY (question_id ) REFERENCES question(question_id );

-- FK của candidate_test
ALTER TABLE candidate_test
ADD FOREIGN KEY (candidate_id ) REFERENCES candidate(candidate_id ); 
ALTER TABLE candidate_test
ADD FOREIGN KEY (test_id) REFERENCES test(test_id); 

-- FK của candidate
ALTER TABLE candidate
ADD FOREIGN KEY (user_id ) REFERENCES `user`(user_id ); 
ALTER TABLE candidate
ADD FOREIGN KEY (semester_exam_id) REFERENCES semester_exam(semester_exam_id ); 

-- FK của test
ALTER TABLE test
ADD FOREIGN KEY (semester_exam_id) REFERENCES `semester_exam`(semester_exam_id );
ALTER TABLE test
ADD FOREIGN KEY (exam_id) REFERENCES `exam`(exam_id );

-- FK của user_group
ALTER TABLE user_group
ADD FOREIGN KEY (user_id) REFERENCES `user`(user_id ); 
ALTER TABLE user_group
ADD FOREIGN KEY (group_id) REFERENCES `group`(group_id ); 

-- FK của user_role
ALTER TABLE user_role
ADD FOREIGN KEY (user_id) REFERENCES `user`(user_id ); 
ALTER TABLE user_role
ADD FOREIGN KEY (role_id) REFERENCES `role`(role_id ); 

-- FK của role_menu
ALTER TABLE role_menu
ADD FOREIGN KEY (menu_id) REFERENCES `menu`(menu_id ); 
ALTER TABLE role_menu
ADD FOREIGN KEY (role_id) REFERENCES `role`(role_id );