package pro.sky.CourseWork2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountWrongNumberException extends RuntimeException{
    public AmountWrongNumberException (){
        super("Такого количества не существует. Попробуйте другое число");
    }
    public AmountWrongNumberException (String message){
        super(message);
    }
}