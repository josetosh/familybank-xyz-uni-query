/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  KEN16849
 * Created: Oct 12, 2022
 */

DROP TABLE IF EXISTS STUDENT;  
CREATE TABLE STUDENT (  
ID INT AUTO_INCREMENT  PRIMARY KEY,  
REG_NO VARCHAR(50) NOT NULL,
COURSE_ID INT(8) NOT NULL 
FIRST_NAME VARCHAR(50) NOT NULL,
MIDDLE_NAME VARCHAR(50) NOT NULL,
LAST_NAME VARCHAR(50) NOT NULL,
GENDER VARCHAR(50) NOT NULL,
DOB VARCHAR(50) NOT NULL,
EMAIL VARCHAR(50) NOT NULL,
CREATED_DATE VARCHAR(50),
); 