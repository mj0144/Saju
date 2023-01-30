package project.saju.exhandler.advice;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import project.saju.web.ResEntity;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@ControllerAdvice
@RestController
public class EntityException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
//                ex.getBindingResult().toString());
        ResEntity response = new ResEntity();
//        Iterator iterator = exception.getBindingResult().getFieldErrors().iterator();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        String errorMsg = "";
        int index = 0;

        for (FieldError error : fieldErrors) {
            errorMsg = errorMsg + "[" + fieldErrors.get(index).getDefaultMessage()+ "]";
            index++;
        }

        response = response.builder()
                .resultCode("E999")
                .httpStatus(status)
                .resultMsg(errorMsg)
                .result(Collections.emptyList())
                .build();

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}