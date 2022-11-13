package kr.rojae.valid.validator.common.format;

import kr.rojae.valid.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsIpValidator implements ConstraintValidator<IsIpValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isIp(value);
    }
}
