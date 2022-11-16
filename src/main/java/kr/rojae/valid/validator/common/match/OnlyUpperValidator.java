package kr.rojae.valid.validator.common.match;

import kr.rojae.valid.validator.common.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyUpperValidator implements ConstraintValidator<OnlyUpperValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isUpper(value);
    }
}
