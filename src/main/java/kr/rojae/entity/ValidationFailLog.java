package kr.rojae.entity;

import kr.rojae.validator.error.VaildFailCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "VALIDATION_FAIL_LOG")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class ValidationFailLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "keys", nullable = false)
    private String keys;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "inputData", nullable = false)
    private String inputData;

    @Column(name = "insDate", nullable = false)
    @CreatedDate
    private LocalDateTime insDate;

    public ValidationFailLog() {
    }

    public ValidationFailLog(String keys, VaildFailCode failCode, String inputData){
        this.keys = keys;
        this.type = failCode.getType();
        this.reason = failCode.getReason();
        this.inputData = inputData;
    }
}
