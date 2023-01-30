package project.saju.util;

import lombok.NoArgsConstructor;

public class StringUtil {

    public static StringUtil getInstance() {
        return new StringUtil();
    }

    /**
     * type에 따른 날짜 문자열 형태 리턴.
     * @param ymd : 날짜 ( yyyymmdd )
     * @param type : 년(year), 월(month), 일(day)
     * @return
     */
    public String getYmdOfType(String ymd, String type) {
        if ( ymd == null || type == null || ymd.length() < 8 ) return "";

        String result = switch (type) { //19960207
            case "year" : yield ymd.substring(0,4);
            case "month" :  yield ymd.substring(4,6);
            case "day" : yield ymd.substring(6,8);
            default : yield "";
        };

        return result;

    }

    public String getMonth(String ymd) {
        if ( ymd == null ) return "";
        return ymd.substring(4);
    }


}
