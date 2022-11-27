package kr.rojae.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiBase<T> {
    private String message;
    private T response;
}
