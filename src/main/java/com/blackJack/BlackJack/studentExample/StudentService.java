package com.blackJack.BlackJack.studentExample;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        List<Student> retString;
        retString = Collections.singletonList(new Student(
                1L, "Boone", "hbooneWilson@gmail.com",
                LocalDate.of(1999, 8, 18), 22));
        return retString;
    }
}
