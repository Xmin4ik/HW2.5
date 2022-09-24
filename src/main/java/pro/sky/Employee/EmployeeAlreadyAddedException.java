package pro.sky.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//выбрасывается, когда нового сотрудника пытаются добавить в массив, а в массиве уже есть такой сотрудник
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException{
}
