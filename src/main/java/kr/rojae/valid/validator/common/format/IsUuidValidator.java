package kr.rojae.valid.validator.common.format;

import kr.rojae.valid.validator.common.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsUuidValidator implements ConstraintValidator<IsUuidValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isUUID(value);
    }
}
