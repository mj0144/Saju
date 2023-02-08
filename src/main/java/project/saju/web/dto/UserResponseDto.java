package project.saju.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import project.saju.domain.user.UserInfo;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class UserResponseDto {

    private String nm_user;
    private int seq_user;
    private String sex;

//    private String nm_saju;
    private String nm_ilju;

    @Builder
    public UserResponseDto(UserInfo entity) {
        this.seq_user = entity.getSeq_user();
        this.nm_user = entity.getNm_user();
        this.sex =entity.getSex();
        this.nm_ilju =entity.getNm_ilju();
//        this.nm_saju = entity.getNm_saju();
    }

}
