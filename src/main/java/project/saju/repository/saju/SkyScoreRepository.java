package project.saju.repository.saju;

import org.springframework.data.jpa.repository.JpaRepository;
import project.saju.domain.saju.SkyScoreInfo;
import project.saju.repository.mapping.SkyScoreMapping;

import java.util.List;

public interface SkyScoreRepository extends JpaRepository<SkyScoreInfo, Integer> {

    //public List<SkyScoreMapping> findByNmMSkyAndNmWSky(String nm_m_sky, String nm_w_sky);
    public SkyScoreMapping findByNmMSkyAndNmWSky(String nm_m_sky, String nm_w_sky);

}
