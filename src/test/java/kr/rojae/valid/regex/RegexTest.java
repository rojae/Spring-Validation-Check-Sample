package kr.rojae.valid.regex;

import kr.rojae.valid.utils.RegexUtils;
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
    public void loginIdFormatTest(){
        boolean res = RegexUtils.onlyNumberWithEnglish(loginId);
        assert res;
    }

}
