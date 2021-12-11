package blackJack.studentExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService STUDENT_SERVICE;

    @Autowired
    public StudentController(StudentService student_service) {
        this.STUDENT_SERVICE = student_service;
    }

    @GetMapping
    public List<Student> getStudents(){
         return STUDENT_SERVICE.getStudents();
    }
}
