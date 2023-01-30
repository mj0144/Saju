package project.saju.web.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import project.saju.domain.user.UserInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class UserSaveRequestDto {

    @NotEmpty(message = "nm_user가 존재하지 않습니다.")
    private String nm_user;
    @NotEmpty(message = "ymd_birth가 존재하지 않습니다.")
    @Size(min=8, max = 8, message = "ymd_birth사이즈는 8입니다.")
    private String ymd_birth;
    @NotEmpty(message = "sex가 존재하지 않습니다.")
    private String sex;
    private String ymd_saju;
    private int hh_birth;

    private String nm_saju;
    private String nm_ilju;

    @Builder
    public UserSaveRequestDto(String nm_user, String ymd_birth, String ymd_saju, String sex, int hh_birth, String nm_ilju) {
        this.nm_user = nm_user;
        this.ymd_birth = ymd_birth;
        this.ymd_saju = ymd_saju;
        this.sex = sex;
        this.hh_birth = hh_birth;
        this.nm_ilju = nm_ilju;
    }

    public UserInfo toEntity() {
        return UserInfo.builder()
                .nm_user(nm_user)
                .ymd_birth(ymd_birth)
                .ymd_saju(ymd_saju)
                .sex(sex)
                .hh_birth(hh_birth)
                .nm_ilju(nm_ilju)
                .build();
    }

}
