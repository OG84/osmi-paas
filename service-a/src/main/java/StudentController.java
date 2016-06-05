import db.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
public class StudentController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    List<Student> getAllStudents(){
     return null;
    }

    public static void main(String [] args){
        SpringApplication.run(StudentController.class, args);
    }
}
