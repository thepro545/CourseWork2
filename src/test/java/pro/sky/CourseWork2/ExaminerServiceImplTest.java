package pro.sky.CourseWork2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CourseWork2.Data.Question;
import pro.sky.CourseWork2.Service.ExaminerService;
import pro.sky.CourseWork2.Service.ExaminerServiceImpl;
import pro.sky.CourseWork2.Service.QuestionService;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static pro.sky.CourseWork2.QuestionsData.*;
@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerService out = new ExaminerServiceImpl();

//    private ExaminerService out = new ExaminerServiceImpl();

    @MethodSource("provideArgumentsForTest")
    @Test
    public void checkGetQuestions(int amount) {
        setList();

        Set<Question> expected = (Set<Question>) questionService.getAll();
        expected.add(QUESTION_AND_ANSWER1);
//        when(questionService.getAll()).thenReturn(QUESTIONS_BOTH);
        assertEquals(amount, out.getQuestions(AMOUNT_1));
//        assertEquals(0, out.getQuestions(AMOUNT_0));
    }

    private void setList() {
        questionService.add(QUESTION_1, ANSWER_1);
        questionService.add(QUESTION_2, ANSWER_2);
        questionService.add(QUESTION_3, ANSWER_3);
        questionService.add(QUESTION_4, ANSWER_4);
        questionService.add(QUESTION_5, ANSWER_5);
    }

    private static Stream<Arguments> provideArgumentsForTest() {
        return Stream.of(

                Arguments.of(AMOUNT_0, 0),
                Arguments.of(AMOUNT_1, 1),
                Arguments.of(AMOUNT_2, 2)
//                Arguments.of(AMOUNT_3, 3),
//                Arguments.of(AMOUNT_4, 4),
//                Arguments.of(AMOUNT_5, 5)
                );

    }
}
