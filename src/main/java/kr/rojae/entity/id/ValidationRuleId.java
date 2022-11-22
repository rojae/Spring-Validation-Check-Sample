package kr.rojae.entity.id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ValidationRuleId implements Serializable {

    private String keys;
    private String subSeq;

}
