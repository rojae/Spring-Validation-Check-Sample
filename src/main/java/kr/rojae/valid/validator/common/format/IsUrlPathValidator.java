package kr.rojae.valid.validator.common.format;

import kr.rojae.valid.validator.common.utils.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsUrlPathValidator implements ConstraintValidator<IsUrlPathValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RegexUtils.isUrlPath(value);
    }
}
