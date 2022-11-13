package kr.rojae.valid.utils;

public class RegexUtils {

    public static boolean hasSpecialChar(String str){
        return str.matches ("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*");
    }

    public static boolean onlyNumericWithAlphabet(String str){
        return str.matches("^[a-zA-Z0-9]*");
    }

}
