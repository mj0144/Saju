package project.saju.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.saju.domain.user.UserInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultSaveRequestDto {

    //private String apiKey;
    @Valid
    @NotEmpty(message = "유저정보(users)가 비어있습니다.")
    @Size(min = 2, max = 2, message = "유저정보(users)는 2개여야 합니다.")
    private List<UserSaveRequestDto> users;

}
