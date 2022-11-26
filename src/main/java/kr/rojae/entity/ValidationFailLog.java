package kr.rojae.entity;

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

    public ValidationFailLog(String keys, String type, String reason, String inputData){
        this.keys = keys;
        this.type = type;
        this.reason = reason;
        this.inputData = inputData;
    }
}
