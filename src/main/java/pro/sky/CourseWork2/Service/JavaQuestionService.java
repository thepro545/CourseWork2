package pro.sky.CourseWork2.Service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Exception.QuestionNotFoundException;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    Random random;

    @Override
    public Question add(String question, String answer) {
        checkNull(question, answer);
        Question newQuestion =  new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        checkNull(question, answer);
        Question question1 = new Question(question, answer);
        if (!questions.remove(question1)) {
            throw new QuestionNotFoundException("Вопроса не существует");
        }
        questions.remove(question1);
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    private void checkNull(String question, String answer) {
        if (question == null || answer == null) {
            throw new NullPointerException("Нельзя использовать Null");
        }
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }
}
