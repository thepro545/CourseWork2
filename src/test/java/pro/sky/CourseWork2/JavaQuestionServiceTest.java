package pro.sky.CourseWork2;

import org.junit.jupiter.api.Test;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Service.JavaQuestionService;
import java.util.Collection;
import java.util.List;

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
        Question question2 = out.add(QUESTION_2, ANSWER_2);
        Collection<Question> exist = List.of(question1, question2);
        Collection<Question> actual = out.getAll();
        assertIterableEquals(exist, actual);
    }

    @Test
    public void checkCollectionWhenDontExist() {
        assertIterableEquals(emptyList(), out.getAll());
    }

}

