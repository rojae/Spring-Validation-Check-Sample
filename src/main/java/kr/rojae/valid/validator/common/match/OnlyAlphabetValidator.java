package kr.rojae.valid.validator.common.match;

import kr.rojae.valid.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyAlphabetValidator implements ConstraintValidator<OnlyAlphabetValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isAlphabet(value);
    }
}
