package kr.rojae.validator;

import kr.rojae.repository.ValidationRuleRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {
    private List<String> acceptedRegexList;
    private final ValidationRuleRepository validationRuleRepository;

    public EmailValidator(ValidationRuleRepository validationRuleRepository) {
        this.validationRuleRepository = validationRuleRepository;
    }

    @Override
    public void initialize(EmailValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.acceptedRegexList = new ArrayList<>();

        List<ValidationRuleDto> rules = validationRuleRepository.getRuleList(constraintAnnotation.key());

        for(ValidationRuleDto dto : rules){
//            System.out.println(dto);
            this.acceptedRegexList.add(dto.getRule());
        }
//        this.acceptedRegexList.addAll(List.of(constraintAnnotation.acceptedRegexList()));
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
