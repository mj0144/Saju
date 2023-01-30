package project.saju.service.user;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import project.saju.domain.user.UserInfo;
import project.saju.repository.user.UserRepository;
import project.saju.web.dto.UserSaveRequestDto;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 에티어베이스를 자동으로 실행시켜줌.
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void 유저정보_등록() {

        userService.save(UserSaveRequestDto.builder()
                .nm_user("테스트")
                .ymd_birth("19960207")
                .sex("1")
                .hh_birth(23)
                .build());

        List<UserInfo> list = userRepository.findAll();

        UserInfo info = list.get(0);

        assertThat(info.getNm_user()).isEqualTo("테스트");
        assertThat(info.getYmd_birth()).isEqualTo("19960207");
        System.out.println("사주명 : " + info.getNm_saju());

    }


}