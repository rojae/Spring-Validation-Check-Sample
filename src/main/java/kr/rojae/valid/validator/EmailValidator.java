package kr.rojae.valid.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {
    private List<String> acceptedRegexList;

    @Override
    public void initialize(EmailValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.acceptedRegexList = new ArrayList<>();
        this.acceptedRegexList.addAll(List.of(constraintAnnotation.acceptedRegexList()));
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for(String format : this.acceptedRegexList){
            if(value.matches(format))
                return true;
        }
        return false;
    }
}