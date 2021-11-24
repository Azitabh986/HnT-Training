package exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.flight.booking.controller.Booking;

@ControllerAdvice(basePackages = "com.flight.booking")
public class FileldValidation extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String,String> hsMap=new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			String fieldName=((FieldError) error).getField();
			String defaultMsg=((FieldError) error).getDefaultMessage();
			hsMap.put(fieldName, defaultMsg);
		});
		return new ResponseEntity<Object>(hsMap,HttpStatus.BAD_REQUEST);
	}
	
}
//Map<String,String> handleValidationException(MethodArgumentNotValidException e){
//	Map<String,String> hsMap=new HashMap<String, String>();
//	e.getBindingResult().getAllErrors().forEach(error->{
//		String fieldName=((FieldError) error).getField();
//		String defaultMsg=((FieldError) error).getDefaultMessage();
//		hsMap.put(fieldName, defaultMsg);
//	});
//	return hsMap;
//}