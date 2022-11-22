package kr.rojae.valid.regex;

import kr.rojae.validator.common.utils.RegexUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RegexTest {

    private String loginId = "test1234";
    private String email = "test@gmail.com";
    private List<String> acceptedEmailList = List.of("\\w+@gmail.com", "\\w+@naver.com");

    @Test
    public void emailFormatTest(){
        boolean res = false;
        for(String format : acceptedEmailList){
            if(email.matches(format))
                res = true;
        }
        assert res;
    }

    @Test
    public void onlyNumericWithAlphabetTest(){
        boolean res = RegexUtils.onlyNumericWithAlphabet(loginId);
        assert res;
    }

    @Test
    public void isNumeric(){
        String str = "123001";
        boolean res = RegexUtils.isNumeric(str);
        assert res;
    }

    @Test
    public void isAlphabet(){
        String str = "abcd";
        boolean res = RegexUtils.isAlphabet(str);
        assert res;
    }

    @Test
    public void isKorean(){
        String str = "대한민국";
        boolean res = RegexUtils.isKorean(str);
        assert res;
    }

    @Test
    public void isUpper(){
        String str = "ABCD";
        boolean res = RegexUtils.isUpper(str);
        assert res;
    }

    @Test
    public void isDowner(){
        String str = "abcd";
        boolean res = RegexUtils.isDowner(str);
        assert res;
    }

    @Test
    public void isUrl(){
        String str = "https://localhost.com";
        boolean res = RegexUtils.isUrl(str);
        assert res;
    }

    @Test
    public void isUrl2(){
        String str = "https://localhost";
        boolean res = RegexUtils.isUrl(str);
        assert !res;
    }

    @Test
    public void isUrlPath(){
        String str = "https://ns-profile.company.com/image/2f48f241-9d64-4d16-bf56-70b9d4e0e79a.jpg";
        boolean res = RegexUtils.isUrlPath(str);
        assert res;
    }

    @Test
    public void isIp(){
        String str = "172.100.13.109";
        boolean res = RegexUtils.isIp(str);
        assert res;
    }

    @Test
    public void isDate(){
        String str = "2019.12.31";
        boolean res = RegexUtils.isDate(str);
        assert res;
    }

    @Test
    public void isUUID(){
        String str = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";
        boolean res = RegexUtils.isUUID(str);
        assert res;
    }


}
