package kr.rojae.repository;

import kr.rojae.validator.ValidationRuleDto;

import java.util.List;

public interface ValidationRuleRepositorySupport {
    List<ValidationRuleDto> getRuleList(String key);
}
