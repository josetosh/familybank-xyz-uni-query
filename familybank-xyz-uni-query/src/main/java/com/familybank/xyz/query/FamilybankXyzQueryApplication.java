package com.familybank.xyz.query;

import com.familybank.xyz.query.entities.Student;
import com.familybank.xyz.query.model.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@SpringBootApplication
@RestController
@RequestMapping("/validate/")
public class FamilybankXyzQueryApplication implements CommandLineRunner {

    public List<Student> listStudents;

    public static void main(String[] args) {
        SpringApplication.run(FamilybankXyzQueryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Command Runner run() method : " + new Date());
    }

    @PostConstruct
    private void init() {
        System.out.println("Verifying Resources and Initializing List of Students : ");
        listStudents = new ArrayList<>();
        listStudents.add(new Student(Long.valueOf("1"), "CS-22-001", "1", "firstName", "middleName", "lastName", "gender", "dob", "EMAIL", "createdDate"));
        listStudents.add(new Student(Long.valueOf("2"), "CT-22-002", "2", "firstName1", "middleName1", "lastName", "gender", "dob", "EMAIL", "createdDate"));
        listStudents.add(new Student(Long.valueOf("3"), "CS-22-003", "1", "firstName2", "middleName2", "lastName", "gender", "dob", "EMAIL", "createdDate"));
        listStudents.add(new Student(Long.valueOf("4"), "BA-22-004", "5", "firstName3", "middleName3", "lastName", "gender", "dob", "EMAIL", "createdDate"));
        listStudents.add(new Student(Long.valueOf("5"), "EG-22-005", "3", "firstName4", "middleName4", "lastName", "gender", "dob", "EMAIL", "createdDate"));
        listStudents.add(new Student(Long.valueOf("6"), "EG-22-006", "3", "firstName5", "middleName5", "lastName", "gender", "dob", "EMAIL", "createdDate"));
        listStudents.add(new Student(Long.valueOf("7"), "CO-22-007", "4", "firstName6", "middleName6", "lastName", "gender", "dob", "EMAIL", "createdDate"));
        listStudents.add(new Student(Long.valueOf("8"), "AR-22-008", "6", "firstName7", "middleName7", "lastName", "gender", "dob", "EMAIL", "createdDate"));
    }

    @GetMapping("/regNo/{regNo}")
    public ResponseEntity<Response> validateRegNo(@PathVariable String regNo) {
        System.out.println("Number of Students : " + listStudents.size());
        System.out.println(Arrays.toString(listStudents.toArray()));
        boolean flag = false;
        flag = containsName(listStudents, regNo);
        System.out.println("FLAG : "+flag);
        Response res = new Response();
        if(flag){
            res.setStatusCode("0");
            res.setStatusDesc("Success");
        }else{
            res.setStatusCode("1");
            res.setStatusDesc("Failure");
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<String> receivePayments(@RequestBody String paymentNotification) {

        System.out.println("Received Paymeny : " + paymentNotification);

        return new ResponseEntity<>("PAYMENT_RECEIVED", HttpStatus.OK);
    }

    public boolean containsName(final List<Student> list, final String regNo) {
        return list.stream().map(Student::getRegNo).filter(regNo::equals).findFirst().isPresent();
    }

}
