package pro.sky.CourseWork2.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable Integer amount){
        return examinerService.getQuestions(amount);
    }
}
