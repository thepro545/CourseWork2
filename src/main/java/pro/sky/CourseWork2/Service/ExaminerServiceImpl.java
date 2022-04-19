package pro.sky.CourseWork2.Service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Exception.AmountWrongNumberException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private JavaQuestionService questionService;
//    private final ExaminerServiceImpl examinerService;

    HashMap<Integer, Question> storage = new HashMap<>();

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
//        this.examinerService = examinerService;
    }

    public ExaminerServiceImpl() {

    }

    public HashMap<Integer, Question> getStorage(){
        questionService.add("Вопрос1", "Ответ1");
        questionService.add("Вопрос2", "Ответ2");
        questionService.add("Вопрос3", "Ответ3");
        questionService.add("Вопрос4", "Ответ4");
        questionService.add("Вопрос5", "Ответ5");
        return storage;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<String> collect = new HashSet<>();
        getStorage();
        if (amount > storage.size() || amount < 0) {
            throw new AmountWrongNumberException("Такого количества не существует. Попробуйте другое число");
        }
        else {
            while (collect.size() != amount) {
                int test = questionService.getRandomQuestion(amount);
                collect.add(String.valueOf(storage.get(test)));
            }
        }

        return Collections.unmodifiableCollection(storage.values());
    }
}
