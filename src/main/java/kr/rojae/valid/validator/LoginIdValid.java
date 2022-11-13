package kr.rojae.valid.validator;

import kr.rojae.valid.validator.common.match.OnlyNumericWithAlphabetValid;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Length(min = 8, max = 15, message = "loginId는 8자 이상, 15자 이하로 가능합니다.")
@NotBlank(message = "loginId는 빈 공간을 가질 수 없습니다.")
@OnlyNumericWithAlphabetValid(message = "loginId는 숫자와 영어로만 이루어집니다.")
@Constraint(validatedBy = {})
public @interface LoginIdValid {
    String message() default "";
    Class[] groups() default {};
    Class[] payload() default {};
}
