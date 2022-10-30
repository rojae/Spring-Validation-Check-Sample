package kr.rojae.valid.errorhandler;

import kr.rojae.valid.dto.ApiBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiBase> handleResponseBodyError(MethodArgumentNotValidException ex) {
        log.error("Exception Caught in handleRequestBodyError : {}", ex.getMessage());

        var error = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .sorted()
                .collect(Collectors.joining(", "));

        log.error("Error is : {}", error);

        return ResponseEntity.badRequest()
                .body(ApiBase.builder().message(error).response("").build());
    }

}