package project.saju.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.saju.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER_INFO")
public class UserInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq_user;

    @Column(nullable = false)
    private String nm_user;

    @Column(nullable = false, length = 8)
    private String ymd_birth;

    @Column(nullable = true, length = 8)
    private String ymd_saju;

    private String sex;
    private int hh_birth;

    private String nm_saju;
    private String nm_ilju;

    @Builder
    public UserInfo(int seq_user, String nm_user, String ymd_birth, String ymd_saju, String sex, int hh_birth, String nm_ilju, String nm_saju) {
        this.seq_user = seq_user;
        this.nm_user = nm_user;
        this.ymd_birth = ymd_birth;
        this.ymd_saju = ymd_saju;
        this.sex = sex;
        this.hh_birth = hh_birth;
        this.nm_ilju = nm_ilju;
        this.nm_saju = nm_saju;
    }

}
