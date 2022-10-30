package kr.rojae.valid.validator;

import kr.rojae.valid.enums.MovieCategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MovieCategoryValidator implements ConstraintValidator<MovieCategoryValid, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (MovieCategory.UNKNOWN.equals(MovieCategory.valueOfName(s))) {
            return false;
        } else {
            return true;
        }
    }
}
