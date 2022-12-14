package kr.rojae.validator.common.match;

import kr.rojae.validator.common.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyNumericWithAlphabetValidator implements ConstraintValidator<OnlyNumericWithAlphabetValid, String>{
    @Override
    public void initialize(OnlyNumericWithAlphabetValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.onlyNumericWithAlphabet(value);
    }
}
