package kr.rojae.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.rojae.validator.ValidRuleDto;

import java.util.List;

import static kr.rojae.entity.QValidationRule.validationRule;

public class ValidationRuleRepositorySupportImpl implements ValidationRuleRepositorySupport {

    private final JPAQueryFactory query;

    public ValidationRuleRepositorySupportImpl(JPAQueryFactory query) {
        this.query = query;
    }

    @Override
    public List<ValidRuleDto> getRuleList(String key) {
        return query.select(
                Projections.constructor(ValidRuleDto.class,
                        validationRule.keys,
                        validationRule.subSeq,
                        validationRule.rule
                ))
                .from(validationRule)
                .where(this.eq(validationRule.keys, key))
                .fetch();
    }

    @Override
    public boolean isExistRule(String key) {
        return query.select(validationRule.keys)
                .from(validationRule)
                .where(this.eq(validationRule.keys, key))
                .fetchFirst() != null;
    }


    public BooleanExpression eq(StringPath path, String str){
        if(str == null)
            return null;
        else
            return path.eq(str);
    }
}
