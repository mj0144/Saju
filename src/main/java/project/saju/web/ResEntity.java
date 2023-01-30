package project.saju.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResEntity {

    private String resultCode;
    private HttpStatus httpStatus;
    private String resultMsg;
    private Integer count;
    private List<Object> result;
}