package project.saju.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.saju.domain.user.UserInfo;
import project.saju.service.saju.SajuService;
import project.saju.service.user.UserService;
import project.saju.web.dto.ResultSaveRequestDto;
import project.saju.web.dto.SajuResponseDto;
import project.saju.web.dto.UserResponseDto;
import project.saju.web.dto.UserSaveRequestDto;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SajuApiController {
    private final UserService userService;
    private final SajuService sajuService;

    @PostMapping("/saju/v1.0/result/info")
    public ResponseEntity<ResEntity> resultInfo(@Valid @RequestBody ResultSaveRequestDto requestDto) {

        ResEntity response = new ResEntity();

//        List<UserSaveRequestDto> list = Optional.ofNullable(requestDto.getUsers())
//                .orElseThrow(() -> new IllegalArgumentException("user 정보가 존재하지 않습니다."));

        // 사용자 정보 저장
        List<UserSaveRequestDto> list = requestDto.getUsers();
        List<Integer> listUserSeq = new ArrayList<>();
        list.stream().forEach(dto -> {
            listUserSeq.add(userService.save(dto));
        });

        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        // 사용자 정보 조회.
        listUserSeq.stream().forEach(seq -> {
            userResponseDtos.add(userService.findBySeq(seq));
        });

        // 사주 점수 조회
        Optional<SajuResponseDto> score = Optional.ofNullable(sajuService.getSajuScore(userResponseDtos).orElseThrow(() -> new NullPointerException()));

        if (score.isPresent()) {
            response = response.builder()
                    .resultCode("E00")
                    .httpStatus(HttpStatus.OK)
                    .resultMsg("요청 처리 완료되었습니다.")
                    .result(Arrays.asList(score.get()))
                    .build();
        } else {
            response = response.builder()
                    .resultCode("E06")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .resultMsg("사주정보가 존재하지 않습니다.")
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/saju/v1.0/result/share")
    public ResponseEntity<ResEntity> resultShare(@RequestParam(value = "req")String listSeq) {

        log.info("테스트 중");

        ResEntity response = new ResEntity();
        List<UserResponseDto> userList = new ArrayList<>();

        for (String seqStr : listSeq.split(",")) {

            int seq = Integer.parseInt(seqStr);

            UserResponseDto dto = userService.findBySeq(seq);
            if (dto == null) {
                response =  response.builder()
                        .resultCode("E05")
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .resultMsg("user 정보가 존재하지 않습니다.")
                        .result(null)
                        .build();
                return new ResponseEntity<>(response, response.getHttpStatus());
            }

            userList.add(userService.findBySeq(seq));

        }

        Optional<SajuResponseDto> score = Optional.ofNullable(sajuService.getSajuScore(userList).orElseThrow(() -> new NullPointerException()));

        if (score.isPresent()) {
            response = response.builder()
                    .resultCode("E00")
                    .httpStatus(HttpStatus.OK)
                    .resultMsg("요청 처리 완료되었습니다.")
                    .result(Arrays.asList(score.get()))
                    .build();
        } else {
            response = response.builder()
                    .resultCode("E06")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .resultMsg("사주정보가 존재하지 않습니다.")
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
