package project.saju.exhandler;

public enum ResultMsg {
    E00("E00", "요청 처리 완료되었습니다.")
    ,E01("E01", "요청 파라미터 에러 발생")
    ,E05("E05", "user 정보가 존재하지 않습니다.")
    ,E06("E06", "사주 점수정보가 존재하지 않습니다.")
    ,E999("E999", "조회 실패(서버 에러)");

    private String msg;
    private String code;
    ResultMsg(String msg) { this.msg = msg; };
    ResultMsg(String code, String msg) { this.code = code; this.msg = msg; };

    public String getMsg() {return msg;}
    public String getCode() {return code;}

}
