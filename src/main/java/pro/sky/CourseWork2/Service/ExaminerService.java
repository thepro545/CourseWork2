package pro.sky.CourseWork2.Service;

import pro.sky.CourseWork2.Data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
