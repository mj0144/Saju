package project.saju.domain.saju;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "LAND_SCORE_INFO")
public class LandScoreInfo {

    @Id
    @Column(name= "score_land")
    private int scoreLand;

    @JsonIgnore
    @Column(name= "nm_m_land")
    private String nmMLand;
    @JsonIgnore
    @Column(name= "nm_w_land")
    private String nmWLand;

}
