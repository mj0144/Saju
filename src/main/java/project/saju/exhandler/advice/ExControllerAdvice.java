package project.saju.exhandler.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.saju.exception.ScoreException;
import project.saju.exhandler.ResultMsg;
import project.saju.web.ResEntity;

import java.util.Collections;
import java.util.NoSuchElementException;

@RestControllerAdvice(basePackages = "project.saju.web")
public class ExControllerAdvice {

    @ResponseStatus
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException exception) {

        ResEntity response = ResEntity.builder()
                .resultCode(ResultMsg.E999)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .resultMsg(ResultMsg.E999.getMsg())
                .result(Collections.emptyList())
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());

    }

    @ResponseStatus
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElementException(NoSuchElementException exception) {

        String msg = exception.getMessage();

        if (msg.isEmpty()) { msg = ResultMsg.E05.getMsg(); };

        ResEntity response = ResEntity.builder()
                .resultCode(ResultMsg.E05)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .resultMsg(msg)
                .result(Collections.emptyList())
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());

    }


    @ResponseStatus
    @ExceptionHandler(ScoreException.class)
    public ResponseEntity scoreException(ScoreException exception) {

        String msg = exception.getMessage();

        if (msg.isEmpty()) { msg = ResultMsg.E06.getMsg(); };

        ResEntity response = ResEntity.builder()
                .resultCode(ResultMsg.E06)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .resultMsg(msg)
                .result(Collections.emptyList())
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());

    }
}
