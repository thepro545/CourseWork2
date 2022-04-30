package pro.sky.CourseWork2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "/java/add")
    public Question add(@RequestParam ("question") String question,
                        @RequestParam ("answer") String answer){
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/java/remove")
    public Question remove(@RequestParam ("question") String question,
                           @RequestParam ("answer") String answer){
        return questionService.remove(question, answer);
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAll(){
        return questionService.getAll();
    }
}
