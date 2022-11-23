package kr.rojae.repository;

import kr.rojae.validator.ValidRuleDto;

import java.util.List;

public interface ValidationRuleRepositorySupport {
    List<ValidRuleDto> getRuleList(String key);
    boolean isExistRule(String key);
}
