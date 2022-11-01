package project.saju.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String apiTest() {
        return "Spring Boot + React 연동 테스트";
    }
}
