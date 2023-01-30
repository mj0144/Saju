package project.saju.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.saju.domain.saju.SajuInfo;
import project.saju.domain.user.UserInfo;
import project.saju.repository.user.UserRepository;
import project.saju.service.saju.SajuService;
import project.saju.web.dto.UserResponseDto;
import project.saju.web.dto.UserSaveRequestDto;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SajuService sajuService;

    public int save(UserSaveRequestDto userSaveRequestDto) {
        userSaveRequestDto.setYmd_saju(calcYmd_saju(userSaveRequestDto.getYmd_birth(), userSaveRequestDto.getHh_birth()));
        SajuInfo sajuInfo = sajuService.findSajuInfo(userSaveRequestDto.getYmd_saju());
        if ( sajuInfo != null ) {
            userSaveRequestDto.setNm_ilju(sajuInfo.getNm_ganjee_day());
        }
        return userRepository.save(userSaveRequestDto.toEntity()).getSeq_user();
    }

    public UserResponseDto findBySeq(int seq) {
//        UserInfo entity = userRepository.findById(seq)
//                .orElseThrow(() -> new IllegalAccessError("해당하는 사용자가 존재하지 않습니다. seq=" + seq));
        UserInfo entity = userRepository.findById(seq).get();
        return new UserResponseDto(entity);
    }

    /**
     * 사주 생년월일 조정
     * @param ymd_birth
     * @param hh_birth
     * @return
     */
    private String calcYmd_saju(String ymd_birth, int hh_birth) {

        if (ymd_birth.length() < 8) {
            //return new ReturnResult(Constant.FAIL, "ymd_birth 길이 오류");
            return "";
        }

        int year = Integer.parseInt(ymd_birth.substring(0,4));
        int month = Integer.parseInt(ymd_birth.substring(4,6));
        int day = Integer.parseInt(ymd_birth.substring(6,8));

        int saju_year = year;
        int saju_month = month;
        int saju_day = day;

        //if (vo.getBirth_hh() == 23 && vo.getBirth_mm() > 30) { // 23시 30분이 넘어가면 일주 계산 년월일이 달라짐. -> 원래 생일에서 하루를 더해야함.
        if (hh_birth == 23) { // 23시 30분이 넘어가면 일주 계산 년월일이 달라짐. -> 원래 생일에서 하루를 더해야함.
            // 1. 윤년이고 28일 이면 29일로가고,
            // 2. 윤년이고 29이면 3월 1일로 바뀜.
            // 3. 1, 3, 5, 7, 8, 10월은 31일 까지. -> 30일이 들어오면 하루 증가.
            // 4. 4 6 9 11 -> 30일까지 ->30일이 들어오면 월이 증가하고 일은 1일로 초기화.

            // 단, 12월 31일은 년이 1증가하고, 1월1일로 초기화.
            if (month == 2) {
                if (isYunnYeon(year)) { // 윤년일 때.
                    if (day == 28) { // 윤년인데 28일이 들어오면 29일로 처리
                        saju_day = day + 1;
                    } else { // 윤년인데 29일이 들어오면 3월 1일로 처리.
                        saju_month = month + 1;
                        saju_day = 1;
                    }
                } else { // 2월인데 윤년이 아닐 때.
                    saju_month = month + 1;
                    saju_day = 1;
                }

                String str_day = String.valueOf(saju_day);

                if (str_day.length() < 2 ) {
                    str_day = "0" + str_day;
                }

                return String.valueOf(saju_year) + "0" + String.valueOf(saju_month) + str_day;
            }

            if (month != 2 && day >= 30) { // 2월이 아니면서 30일 이상일 때.
                switch (month) {
                    case 1,3,5,7,8,10 -> {
                        if (day == 30) { // 31일까지 있는 월이기 때문에 30일인지 확인
                            saju_day = day + 1;
                        } else { // 31일이 이라면
                            saju_month = month + 1; // 월은 1로 증가하고, 일은 1일로 초기화.
                            saju_day = 1;
                        }
                    }
                    case 4,6,9,11 -> { saju_month = month + 1; saju_day = 1; }
                    case 12 -> {
                        if (day == 30) {
                            saju_day = day + 1;
                        } else {
                            // 다음년도 1월1일로 세팅
                            saju_day = 1;
                            saju_month = 1;
                            saju_year = year + 1;
                        }
                    }
                }
            }
        }

        String str_month = String.valueOf(saju_month);
        String str_day = String.valueOf(saju_day);

        if (str_month.length() < 2 ) {
            str_month = "0" + str_month;
        }
        if (str_day.length() < 2 ) {
            str_day = "0" + str_day;
        }

        return String.valueOf(saju_year) + str_month + str_day;
    }

    private boolean isYunnYeon(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}
