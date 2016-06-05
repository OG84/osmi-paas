import db.Student;
import db.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
@ComponentScan("db")
@EnableMongoRepositories
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    List<Student> getAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        if(allStudents.isEmpty()){
            createDummyStudents();
        }
        return allStudents;
    }

    private void createDummyStudents(){
        studentRepository.save(new Student("Student 1", 1));
        studentRepository.save(new Student("Student 2", 1));
        studentRepository.save(new Student("Student 3", 3));
        studentRepository.save(new Student("Student 4", 5));
        studentRepository.save(new Student("Student 5", 5));
    }

    public static void main(String [] args){
        SpringApplication.run(StudentController.class, args);
    }
}
