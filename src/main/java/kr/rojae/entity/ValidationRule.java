package kr.rojae.entity;

import kr.rojae.entity.id.ValidationRuleId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "VALIDATION_RULE")
@Getter
@Setter
@IdClass(ValidationRuleId.class)
public class ValidationRule {

    @Id
    @Column(name = "keys", nullable = false)
    private String keys;

    @Id
    @Column(name = "subSeq", nullable = false)
    private String subSeq;

    @Column(name = "rule", nullable = false)
    private String rule;
}