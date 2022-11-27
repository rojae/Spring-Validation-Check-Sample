package kr.rojae.dto;

import kr.rojae.validator.EmailValid;
import kr.rojae.validator.LoginIdValid;
import kr.rojae.validator.common.format.*;
import kr.rojae.validator.common.match.OnlyKoreanValid;
import kr.rojae.validator.common.match.OnlyNumericValid;
import lombok.Data;


@Data
public class AccountAddRequest {
    @LoginIdValid(message = "loginId이 사용 불가능한 값입니다")
    private String loginId;

    @EmailValid(message = "email이 사용 불가능한 값입니다")
    private String email;

    @OnlyKoreanValid(message = "name은 한글만 입력이 가능합니다")
    private String name;

    @IsDateValid(message = "birthDate는 날짜 형식만 가능합니다 (yyyy.mm.dd)")
    private String birthDate;

    @OnlyNumericValid(message = "age는 숫자만 입력이 가능합니다")
    private String age;

    @IsUrlPathValid(message = "profileUrl은 URL 형식만 가능합니다")
    private String profileUrl;

    @IsYnValid(message = "isEnable이 유효한 값이 아닙니다. (Y, N)")
    private String isEnable;

    @IsIpValid(message = "clientIp는 IP 형식만 가능합니다")
    private String clientIp;

    @IsUuidValid(message = "reqId은 UUID 형식만 가능합니다")
    private String reqId;
}
