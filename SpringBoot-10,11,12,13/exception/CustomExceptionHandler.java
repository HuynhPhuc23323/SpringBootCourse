package milliwatt.phuc.restfulapi.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice // có thể trả về một view thay vì 1 dạng Json
public class CustomExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
		return new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
	}
	
}
