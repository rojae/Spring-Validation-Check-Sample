package kr.rojae.valid.validator.common.match;

import kr.rojae.valid.validator.common.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyDownerValidator implements ConstraintValidator<OnlyDownerValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isDowner(value);
    }
}
