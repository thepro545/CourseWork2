package pro.sky.CourseWork2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException() {
        super("Вопрос не найден");
    }
    public QuestionNotFoundException(String message) {
        super(message);
    }
}
