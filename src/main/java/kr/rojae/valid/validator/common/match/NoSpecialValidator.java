package kr.rojae.valid.validator.common.match;

import kr.rojae.valid.validator.common.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoSpecialValidator implements ConstraintValidator<NoSpecialValid, String> {

    @Override
    public void initialize(NoSpecialValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !RegexUtils.hasSpecialChar(value);
    }

}
