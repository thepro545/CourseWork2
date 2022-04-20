package pro.sky.CourseWork2.Service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Exception.AmountWrongNumberException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (amount > questionService.getAll().size() || amount < 0) {
            throw new AmountWrongNumberException("Такого количества не существует. Попробуйте другое число");
        }
        else {
            while (questions.size() < amount) {
                questions.add(questionService.getRandomQuestion());
            }
        }

        return Collections.unmodifiableCollection(questionService.getAll());
    }
}
