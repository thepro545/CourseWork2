package pro.sky.CourseWork2;

import pro.sky.CourseWork2.Data.Question;
import java.util.Set;

public class QuestionsData {
    public static final String QUESTION_1 = "Вопрос1";
    public static final String QUESTION_2 = "Вопрос2";
    public static final String ANSWER_1 = "Ответ1";
    public static final String ANSWER_2 = "Ответ2";
    public static final Integer AMOUNT_0 = 0;
    public static final Integer AMOUNT_1 = 1;
    public static final Integer AMOUNT_2 = 2;
    public static final Question QUESTION_AND_ANSWER1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question QUESTION_AND_ANSWER2 = new Question(QUESTION_2, ANSWER_2);
    public static final Set<Question> QUESTIONS_BOTH = Set.of(QUESTION_AND_ANSWER1, QUESTION_AND_ANSWER2);
}
