package project.saju.repository.saju;

import org.springframework.data.jpa.repository.JpaRepository;
import project.saju.domain.saju.SajuInfo;

public interface SajuRepository extends JpaRepository<SajuInfo, Integer> {

    public SajuInfo findDistinctFirstBySolarYearAndSolarMonthAndSolarDay(int solar_year, int solar_month, int solar_day);

}
