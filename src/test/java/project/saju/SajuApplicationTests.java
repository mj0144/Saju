package project.saju;

import org.aspectj.bridge.IMessage;
import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import project.saju.web.dto.ResultSaveRequestDto;
import project.saju.web.dto.UserSaveRequestDto;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//@SpringBootTest
class SajuApplicationTests {

    @Test
    void contextLoads() {
    }

    private LocalValidatorFactoryBean validator;

    @BeforeEach
    void init() {
        validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(HibernateValidator.class);
        validator.afterPropertiesSet();
    }


    @Test
    void resultSave_validate_테스트() {
        // given
        ResultSaveRequestDto dto = new ResultSaveRequestDto(null);

        // when
        Set<ConstraintViolation<ResultSaveRequestDto>> validate = validator.validate(dto);
        Iterator<ConstraintViolation<ResultSaveRequestDto>> iterator = validate.iterator();

        Assertions.assertThat(true).isEqualTo(iterator.hasNext());

        // then
        while (iterator.hasNext()) {
            ConstraintViolation<ResultSaveRequestDto> next = iterator.next();
            String message = next.getMessage();
            System.out.println("message : " + message);
            Assertions.assertThat("유저정보는 필수값.").isEqualTo(message);
        }


    }

    @Test
    void user_validate_테스트() {
        // given
        List<UserSaveRequestDto> userList = new ArrayList<>();
        UserSaveRequestDto user = new UserSaveRequestDto();
        user.setNm_user(null);
        user.setYmd_birth("19960207");
        user.setSex("1");
        userList.add(user);

        ResultSaveRequestDto dto = new ResultSaveRequestDto(userList);


        // when
        Set<ConstraintViolation<ResultSaveRequestDto>> validate = validator.validate(dto);
        Iterator<ConstraintViolation<ResultSaveRequestDto>> iterator = validate.iterator();

        //then
        Assertions.assertThat(true).isEqualTo(iterator.hasNext());

        // then
        while (iterator.hasNext()) {
            ConstraintViolation<ResultSaveRequestDto> next = iterator.next();
            String message = next.getMessage();
            System.out.println("message : " + message);
            Assertions.assertThat("nm_user가 존재하지 않습니다.").isEqualTo(message);
        }
    }



}
