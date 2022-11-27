package kr.rojae.repository;

import kr.rojae.entity.ValidationFailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationFailLogRepository extends JpaRepository<ValidationFailLog, Long> {
}
