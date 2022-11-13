package kr.rojae.valid.validator;

import kr.rojae.valid.validator.common.match.NoSpecialValid;

import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank(message = "email은 빈 공간을 가질 수 없습니다.")
@NoSpecialValid(message = "email에 특수문자가 들어갈 수 없습니다.")
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValid {
    String[] acceptedRegexList() default {
        "\\w+@gmail.com",
        "\\w+@naver.com"
    };

    String message() default "허용되지 않는 이메일 주소입니다";

    Class[] groups() default {};

    Class[] payload() default {};
}
