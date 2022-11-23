package kr.rojae.validator;

import kr.rojae.repository.ValidationRuleRepository;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
public class EmailValidator implements ConstraintValidator<EmailValid, String> {

    private final List<String> acceptedRegexList = new ArrayList<>();
    private final ValidationRuleRepository validationRuleRepository;

    public EmailValidator(ValidationRuleRepository validationRuleRepository) {
        this.validationRuleRepository = validationRuleRepository;
    }

    @Override
    public void initialize(EmailValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

        Properties p = new Properties();
        String dbKeyName = p.getProperty(constraintAnnotation.key());

        List<ValidRuleDto> rules = validationRuleRepository.getRuleList(dbKeyName);

        if(rules.size() == 0){
            log.error(String.format("KEY : %s is not defined from database, Size is ZERO", dbKeyName));
        }
        else {
            for(ValidRuleDto dto : rules){
                this.acceptedRegexList.add(dto.getRule());
            }
        }
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
