package pro.sky.CourseWork2;

import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Service.JavaQuestionService;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class QuestionsData {
    public static final String QUESTION_1 = "Вопрос1";
    public static final String QUESTION_2 = "Вопрос2";
    public static final String QUESTION_3 = "Вопрос3";
    public static final String QUESTION_4 = "Вопрос4";
    public static final String QUESTION_5 = "Вопрос5";
    public static final String ANSWER_1 = "Ответ1";
    public static final String ANSWER_2 = "Ответ2";
    public static final String ANSWER_3 = "Ответ3";
    public static final String ANSWER_4 = "Ответ4";
    public static final String ANSWER_5 = "Ответ5";
    public static final Integer AMOUNT_0 = 0;
    public static final Integer AMOUNT_1 = 1;
    public static final Integer AMOUNT_2 = 2;
    public static final Question QUESTION_AND_ANSWER1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question QUESTION_AND_ANSWER2 = new Question(QUESTION_2, ANSWER_2);
    public static final Set<Question> QUESTIONS_BOTH = Set.of(QUESTION_AND_ANSWER1, QUESTION_AND_ANSWER2);
}
