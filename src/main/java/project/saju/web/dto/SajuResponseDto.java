package project.saju.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class SajuResponseDto {

    private int score_sky;
    private int score_land;
    private List<UserResponseDto> list;

    @Builder
    public SajuResponseDto(int score_sky, int score_land, List<UserResponseDto> list) {
        this.score_sky = score_sky;
        this.score_land = score_land;
        this.list = list;
    }

}
