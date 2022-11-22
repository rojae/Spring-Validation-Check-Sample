package kr.rojae.repository;

import kr.rojae.entity.ValidationRule;
import kr.rojae.entity.id.ValidationRuleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRuleRepository extends JpaRepository<ValidationRule, ValidationRuleId>, ValidationRuleRepositorySupport{

}
