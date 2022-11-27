package kr.rojae.validator;

import kr.rojae.entity.ValidationFailLog;
import kr.rojae.repository.ValidationFailLogRepository;
import kr.rojae.repository.ValidationRuleRepository;
import kr.rojae.validator.error.VaildFailCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
public class EmailValidator implements ConstraintValidator<EmailValid, String> {

    private final Environment env;
    private final ValidationRuleRepository validationRuleRepository;
    private final ValidationFailLogRepository validationFailLogRepository;
    private String dbKeyName;
    private final List<String> acceptedRegexList = new ArrayList<>();


    public EmailValidator(ValidationRuleRepository validationRuleRepository, ValidationFailLogRepository validationFailLogRepository, Environment env) {
        this.validationRuleRepository = validationRuleRepository;
        this.validationFailLogRepository = validationFailLogRepository;
        this.env = env;
    }

    @Override
    public void initialize(EmailValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

        this.dbKeyName = env.getProperty(constraintAnnotation.key());

        // EmailValid의 Validation Checking 정규식 Rule을 DB에서 가져오자.
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

        // Validation Checking에 실패한 경우, DB에 저장하자.
        validationFailLogRepository.save(new ValidationFailLog(dbKeyName, VaildFailCode.API_REFUSED, value));
        return false;
    }
}
