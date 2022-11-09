package kr.rojae.valid.validator.common;

import kr.rojae.valid.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyDigitWithAlphabetValidator implements ConstraintValidator<OnlyDigitWithAlphabetValid, String>{
    @Override
    public void initialize(OnlyDigitWithAlphabetValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.onlyNumberWithEnglish(value);
    }
}
