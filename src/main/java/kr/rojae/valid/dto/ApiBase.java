package kr.rojae.valid.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiBase<T> {
    private String message;
    private T response;
}
