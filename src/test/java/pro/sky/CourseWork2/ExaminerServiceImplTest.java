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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    private ExaminerServiceImpl out;

    @MethodSource("provideArgumentsForTest")
    @ParameterizedTest
    public void checkGetQuestions(Integer amount) {
        when(questionService.getAll()).thenReturn(QUESTIONS_BOTH);
        when(questionService.getRandomQuestion()).thenReturn(QUESTION_AND_ANSWER1);
        assertTrue(questionService.getAll().containsAll(out.getQuestions(AMOUNT_1)) );
    }

    private static Stream<Arguments> provideArgumentsForTest() {
        return Stream.of(
                Arguments.of(AMOUNT_0, 0),
                Arguments.of(AMOUNT_1, 1),
                Arguments.of(AMOUNT_2, 2)
                );

    }
}
