package pro.sky.CourseWork2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Service.JavaQuestionService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.CourseWork2.QuestionsData.*;

public class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();


    @Test
    public void checkAdd() {
        Question exist = new Question(QUESTION_1, ANSWER_1);
        assertEquals(0, out.getAll().size());
        assertFalse(out.getAll().contains(exist));
        Question actual = out.add(QUESTION_1, ANSWER_1);
        assertEquals(exist, actual);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(exist));
    }

    @Test
    public void checkRemove() {
        Question exist = out.add(QUESTION_1, ANSWER_1);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(exist));
        Question actual = out.remove(QUESTION_1, ANSWER_1);
        assertEquals(exist, actual);
        assertTrue(out.getAll().isEmpty());
        assertFalse(out.getAll().contains(exist));
    }

    @Test
    public void checkCollection() {
        Question question1 = out.add(QUESTION_1, ANSWER_1);
        Question question2 = out.add(QUESTION_1, ANSWER_1);
        Collection<Question> exist = List.of(question1, question2);
        Collection<Question> actual = out.getAll();
        assertIterableEquals(exist, actual);
    }

    @Test
    public void checkCollectionWhenDontExist() {
        assertIterableEquals(emptyList(), out.getAll());
    }

//    private void setList() {
//        out.add(QUESTION_1, ANSWER_1);
//        out.add(QUESTION_2, ANSWER_2);
//        out.add(QUESTION_3, ANSWER_3);
//        out.add(QUESTION_4, ANSWER_4);
//        out.add(QUESTION_5, ANSWER_5);
//    }
//
//    private static Stream<Arguments> provideArgumentsForTest() {
//        return Stream.of(
//                Arguments.of(QUESTION_1, "Вопрос1"),
//                Arguments.of(QUESTION_2, "Вопрос2"),
//                Arguments.of(QUESTION_3, "Вопрос3"),
//                Arguments.of(QUESTION_4, "Вопрос4"),
//                Arguments.of(QUESTION_5, "Вопрос5")
//                Arguments.of(ANSWER_1, "Ответ1"),
//                Arguments.of(ANSWER_2, "Ответ1"),
//                Arguments.of(ANSWER_3, "Ответ1"),
//                Arguments.of(ANSWER_4, "Ответ1"),
//                Arguments.of(ANSWER_5, "Ответ1")
//        );
}

