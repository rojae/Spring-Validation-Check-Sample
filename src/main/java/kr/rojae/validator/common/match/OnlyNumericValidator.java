package kr.rojae.validator.common.match;

import kr.rojae.validator.common.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyNumericValidator implements ConstraintValidator<OnlyNumericValid, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isNumeric(value);
    }
}
