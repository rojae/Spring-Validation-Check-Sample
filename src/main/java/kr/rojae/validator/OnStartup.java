package kr.rojae.validator;

import kr.rojae.repository.ValidationRuleRepository;
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

    public OnStartup(Environment env, ValidationRuleRepository validationRuleRepository) {
        this.env = env;
        this.validationRuleRepository = validationRuleRepository;
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
            }
        });
    }



}
