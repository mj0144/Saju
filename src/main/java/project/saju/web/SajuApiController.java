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
import project.saju.exception.ScoreException;
import project.saju.exhandler.ResultMsg;
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
        Optional<SajuResponseDto> score = Optional.ofNullable(sajuService.getSajuScore(userResponseDtos).orElseThrow(() -> new ScoreException()));

        ResEntity response = new ResEntity();

        if (score.isPresent()) {
            response = response.builder()
                    .resultCode(ResultMsg.E00)
                    .httpStatus(HttpStatus.OK)
                    .resultMsg(ResultMsg.E00.getMsg())
                    .result(Arrays.asList(score.get()))
                    .build();
        } else {
            response = response.builder()
                    .resultCode(ResultMsg.E06)
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .resultMsg(ResultMsg.E06.getMsg())
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/saju/v1.0/result/share")
    public ResponseEntity<ResEntity> resultShare(@RequestParam(value = "req")String listSeq) {

        ResEntity response = new ResEntity();
        List<UserResponseDto> userList = new ArrayList<>();

        for (String seqStr : listSeq.split(",")) {
            int seq = Integer.parseInt(seqStr);
            userList.add(userService.findBySeq(seq));
        }

        // 사주 점수 조회
        Optional<SajuResponseDto> score = Optional.ofNullable(sajuService.getSajuScore(userList).orElseThrow(() -> new ScoreException()));

        if (score.isPresent()) {
            response = response.builder()
                    .resultCode(ResultMsg.E00)
                    .httpStatus(HttpStatus.OK)
                    .resultMsg(ResultMsg.E00.getMsg())
                    .result(Arrays.asList(score.get()))
                    .build();
        } else {
            response = response.builder()
                    .resultCode(ResultMsg.E06)
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .resultMsg(ResultMsg.E06.getMsg())
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
