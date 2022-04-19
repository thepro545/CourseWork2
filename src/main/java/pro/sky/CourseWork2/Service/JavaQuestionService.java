package pro.sky.CourseWork2.Service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Exception.QuestionExistException;
import pro.sky.CourseWork2.Exception.QuestionNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService{
    private final HashMap<String, Question> questions = new HashMap<String, Question>();
    private Integer index = 0;

//    public JavaQuestionService() {
//        this.questions = new HashMap<>();
//    }
//    public JavaQuestionService(Question questions) {
//        this.questions = questions;
//        this.questions1 = new HashMap<>();
//    }

    @Override
    public Question add(String question, String answer) {
        checkNull(question, answer);
        String key = getQuestionAndAnswer(question, answer);
        if (question.contains(key)) {
            throw new QuestionExistException("Вопрос уже существует");
        }
        Question newQuestion = questions.put(key, new Question(question, answer));
        index++;
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        checkNull(question, answer);
        String key = getQuestionAndAnswer(question, answer);
        if (questions.remove(key)==null) {
            throw new QuestionNotFoundException("Вопроса не существует");
        }
        Question question1 = new Question(question, answer);
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions.values());
    }

    private void checkNull(String question, String answer) {
        if (question == null || answer == null) {
            throw new NullPointerException("Нельзя использовать Null");
        }
    }

    private String getQuestionAndAnswer(String question, String answer) {
        return question + " " + answer;
    }

    @Override
    public int getRandomQuestion(int numMax) {
        Random random = new Random();
        int count = random.nextInt(numMax);
        return count;
    }
}
