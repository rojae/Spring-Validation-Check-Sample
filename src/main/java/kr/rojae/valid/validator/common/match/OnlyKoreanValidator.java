package kr.rojae.valid.validator.common.match;

import kr.rojae.valid.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyKoreanValidator implements ConstraintValidator<OnlyKoreanValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isKorean(value);
    }
}
