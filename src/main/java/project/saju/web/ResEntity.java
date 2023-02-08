package project.saju.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import project.saju.exhandler.ResultMsg;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResEntity {

    private ResultMsg resultCode;
    private HttpStatus httpStatus;
    private String resultMsg;
    private List<Object> result;

}