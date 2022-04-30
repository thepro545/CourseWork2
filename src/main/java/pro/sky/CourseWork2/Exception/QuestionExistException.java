package pro.sky.CourseWork2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionExistException extends RuntimeException {

    public QuestionExistException() {
        super("Сотрудник уже существует");
    }

    public QuestionExistException(String message) {
        super(message);
    }
}
