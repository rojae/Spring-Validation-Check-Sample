package kr.rojae.validator;

import kr.rojae.entity.ValidationFailLog;
import kr.rojae.repository.ValidationFailLogRepository;
import kr.rojae.repository.ValidationRuleRepository;
import kr.rojae.validator.error.VaildFailCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Slf4j
public class OnStartup {

    private final String keyPattern = "validation.*";
    private final Environment env;
    private final ValidationRuleRepository validationRuleRepository;
    private final ValidationFailLogRepository validationFailLogRepository;

    public OnStartup(Environment env, ValidationRuleRepository validationRuleRepository, ValidationFailLogRepository validationFailLogRepository) {
        this.env = env;
        this.validationRuleRepository = validationRuleRepository;
        this.validationFailLogRepository = validationFailLogRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbKeyCheckOnStartup() {
        MutablePropertySources propSrc = ((AbstractEnvironment) env).getPropertySources();
        List<String> collect = StreamSupport.stream(propSrc.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource<?>) ps).getPropertyNames())
                .flatMap(Arrays::<String>stream)
                .filter(s -> s.matches(keyPattern))
                .collect(Collectors.toList());

        collect.forEach(key -> {
            if(!validationRuleRepository.isExistRule(env.getProperty(key))){
                log.error(String.format("KEY : %s is not defined from database, Size is ZERO", env.getProperty(key)));
                // On-Startup (기동 이후) Validation KEY의 데이터가 DB에 존재하는지 체크함
                validationFailLogRepository.save(new ValidationFailLog(env.getProperty(key), VaildFailCode.KEY_UNDEFINED, ""));
            }
        });
    }



}
