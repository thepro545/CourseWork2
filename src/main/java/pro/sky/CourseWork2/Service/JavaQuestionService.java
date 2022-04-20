package pro.sky.CourseWork2.Service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Exception.QuestionExistException;
import pro.sky.CourseWork2.Exception.QuestionNotFoundException;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    private Integer index = 0;
    Random random;

    @Override
    public Question add(String question, String answer) {
        checkNull(question, answer);
        String key = getQuestionAndAnswer(question, answer);
        if (questions.contains(key)) {
            throw new QuestionExistException("Вопрос уже существует");
        }
//        Question newQuestion = questions.put(key, new Question(question, answer));
        Question newQuestion =  new Question(question, answer);
        index++;
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        checkNull(question, answer);
        String key = getQuestionAndAnswer(question, answer);
        if (!questions.remove(key)) {
            throw new QuestionNotFoundException("Вопроса не существует");
        }
        Question question1 = new Question(question, answer);
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

    private String getQuestionAndAnswer(String question, String answer) {
        return question + " " + answer;
    }

    @Override
    public Question getRandomQuestion(int numMax) {
        List question = new ArrayList(questions);
        question.add(random.nextInt(numMax));
        return (Question) Collections.unmodifiableList(question);
    }
}
