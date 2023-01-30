package project.saju.domain.saju;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ILJU_INFO")
public class IljuInfo  {

    @Id
    private int seq_ilju;

    private String nm_ilju;
    private String nm_sky;
    private int no_sky;
    private String nm_sky_five;
    private String nm_land;
    private int no_land;
    private String nm_land_five;





}
