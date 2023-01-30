package project.saju.exhandler.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.saju.web.ResEntity;

import java.util.Collections;

@RestControllerAdvice(basePackages = "project.saju.web")
public class ExControllerAdvice {

    @ResponseStatus
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException exception) {

        ResEntity response = new ResEntity();
        response = response.builder()
                .resultCode("E999")
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .resultMsg("서버에 오류가 발생하였습니다.")
                .result(Collections.emptyList())
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());


        //return new ErrorResult("BAD", exception.getMessage());
    }
}
