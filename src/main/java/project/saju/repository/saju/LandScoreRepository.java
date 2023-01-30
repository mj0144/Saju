package project.saju.repository.saju;

import org.springframework.data.jpa.repository.JpaRepository;
import project.saju.domain.saju.LandScoreInfo;
import project.saju.repository.mapping.LandScoreMapping;

import java.util.List;

public interface LandScoreRepository extends JpaRepository<LandScoreInfo, Integer> {

//    public List<LandScoreMapping> findByNmMLandAndNmWLand(String nm_m_land, String nm_w_land);
    public LandScoreMapping findByNmMLandAndNmWLand(String nm_m_land, String nm_w_land);

}
