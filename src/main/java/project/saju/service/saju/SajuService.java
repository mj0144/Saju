package project.saju.service.saju;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.saju.domain.saju.SajuInfo;
import project.saju.exception.ScoreException;
import project.saju.repository.saju.LandScoreRepository;
import project.saju.repository.saju.SajuRepository;
import project.saju.repository.saju.SkyScoreRepository;
import project.saju.util.StringUtil;
import project.saju.web.dto.SajuRequestDto;
import project.saju.web.dto.SajuResponseDto;
import project.saju.web.dto.UserResponseDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SajuService {
    private final SajuRepository sajuRepository;
    private final SkyScoreRepository skyScoreRepository;
    private final LandScoreRepository landScoreRepository;


    public SajuInfo findSajuInfo(String ymd_saju) {
        int year = Integer.parseInt(StringUtil.getInstance().getYmdOfType(ymd_saju, "year"));
        int month = Integer.parseInt(StringUtil.getInstance().getYmdOfType(ymd_saju, "month"));
        int day = Integer.parseInt(StringUtil.getInstance().getYmdOfType(ymd_saju, "day"));
        return sajuRepository.findDistinctFirstBySolarYearAndSolarMonthAndSolarDay(year, month, day);
    }

    public Optional<SajuResponseDto> getSajuScore(List<UserResponseDto> list) {

        SajuRequestDto sajuRequestDto = new SajuRequestDto();

        list.stream().forEach(user -> {
            switch (user.getSex()) {
                case "1" : {
                    sajuRequestDto.setNmMSky(user.getNm_ilju().substring(0,1));
                    sajuRequestDto.setNmMLand(user.getNm_ilju().substring(1,2));
                    break;
                }
                case "2" : {
                    sajuRequestDto.setNmWSky(user.getNm_ilju().substring(0,1));
                    sajuRequestDto.setNmWLand(user.getNm_ilju().substring(1,2));
                    break;
                }
            }
        });

        int skyScore = 0;
        int landScore = 0;

        try{
            skyScore = skyScoreRepository.findByNmMSkyAndNmWSky(sajuRequestDto.getNmMSky(), sajuRequestDto.getNmWSky()).getscoreSky();
            landScore = landScoreRepository.findByNmMLandAndNmWLand(sajuRequestDto.getNmMLand(), sajuRequestDto.getNmWLand()).getscoreLand();
        } catch (NullPointerException exception) {
            throw new ScoreException("사주 점수정보가 존재하지 않습니다.");
        }

        return Optional.ofNullable(new SajuResponseDto(skyScore, landScore, list));

    }
}
