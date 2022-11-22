package kr.rojae.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ValidationRuleDto {
    private String keys;
    private String subSeq;
    private String rule;
}
