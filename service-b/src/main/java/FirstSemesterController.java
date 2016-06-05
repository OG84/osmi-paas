import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import servicea.Student;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@Controller
@ComponentScan("servicea")
public class FirstSemesterController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    List<Student> getFirstSemesterStudents(){
        RestTemplate restTemplate = new RestTemplate();
        Student[] allStudents = restTemplate.getForObject("http://service-a:12345", Student[].class);
        List<Student> allStudentsList = Arrays.asList(allStudents);
        Stream<Student> firstSemesterStudents = allStudentsList.stream().filter(student -> student.getSemester() == 1);
        return firstSemesterStudents.collect(Collectors.toList());
    }

    public static void main(String [] args){
        SpringApplication.run(FirstSemesterController.class, args);
    }
}
