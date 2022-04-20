package pro.sky.CourseWork2.Service;

import pro.sky.CourseWork2.Data.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion(int maxNum);
}
