package project.saju.domain.saju;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "SAJU_INFO")
public class SajuInfo {

    @Id
    private int no_saju;

    @JoinColumn(name= "solar_year")
    private int solarYear;
    @JoinColumn(name= "solar_month")
    private int solarMonth;
    @JoinColumn(name= "solar_day")
    private int solarDay;

    private int luna_year;
    private int luna_month;
    private int luna_day;
    private String nm_ganjee_year;
    private String nm_ganjee_month;
    private String nm_ganjee_day;



}
