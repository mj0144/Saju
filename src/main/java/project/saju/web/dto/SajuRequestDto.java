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
public class SajuRequestDto {

    private String nmMSky;
    private String nmWSky;
    private String nmMLand;
    private String nmWLand;
    private int seq_user;

//    @Builder
//    public SajuRequestDto(UserInfo entity) {
//        this.seq_user = entity.getSeq_user();
//        this.nm_user = entity.getNm_user();
//        this.sex =entity.getSex();
//        this.nm_ilju =entity.getNm_ilju();
//        this.nm_saju = entity.getNm_saju();
//    }

//    public UserInfo toEntity() {
//        return UserInfo.builder()
//                .seq_user(seq_user)
//                .nm_user(nm_user)
//                .sex(sex)
//                .nm_ilju(nm_ilju)
//                .nm_saju(nm_saju)
//                .build();
//    }

}
