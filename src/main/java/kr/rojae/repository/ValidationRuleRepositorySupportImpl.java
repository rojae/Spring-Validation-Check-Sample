package kr.rojae.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.rojae.validator.ValidationRuleDto;

import java.util.List;

import static kr.rojae.entity.QValidationRule.validationRule;

public class ValidationRuleRepositorySupportImpl implements ValidationRuleRepositorySupport {

    private final JPAQueryFactory query;

    public ValidationRuleRepositorySupportImpl(JPAQueryFactory query) {
        this.query = query;
    }

    @Override
    public List<ValidationRuleDto> getRuleList(String key) {
        return query.select(
                Projections.constructor(ValidationRuleDto.class,
                        validationRule.keys,
                        validationRule.subSeq,
                        validationRule.rule
                ))
                .from(validationRule)
                .where(this.eq(validationRule.keys, key))
                .fetch();
    }

    public BooleanExpression eq(StringPath path, String str){
        if(str == null)
            return null;
        else
            return path.eq(str);
    }
}
