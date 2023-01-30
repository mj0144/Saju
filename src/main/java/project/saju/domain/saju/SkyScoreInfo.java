package project.saju.domain.saju;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "SKY_SCORE_INFO")
public class SkyScoreInfo {

    @Id
    @Column(name= "score_sky")
    private int scoreSky;

    @Column(name= "nm_m_sky")
    @JsonIgnore
    private String nmMSky;

    @Column(name= "nm_w_sky")
    @JsonIgnore
    private String nmWSky;


}
