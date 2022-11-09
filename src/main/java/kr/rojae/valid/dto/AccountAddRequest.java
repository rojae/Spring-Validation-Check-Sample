package kr.rojae.valid.dto;

import kr.rojae.valid.validator.EmailValid;
import kr.rojae.valid.validator.LoginIdValid;
import lombok.Data;


@Data
public class AccountAddRequest {
    @LoginIdValid
    private String loginId;

    @EmailValid
    private String email;
    // only Korean, English
    private String name;
    // format yyyy.mm.dd
    private String birthDate;
    // only number
    private String age;
    // url
    private String profileUrl;
    // String Y, N
    private String isEnable;
    // ip format
    private String clientIp;
    // uuid format
    private String reqId;
}
