package kr.rojae.valid.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MovieAddRequest {
    @NotBlank(message = "MovieAddRequest.name은 빈 값일 수 없습니다")
    private String name;

    @NotBlank(message = "MovieAddRequest.category 빈 값일 수 없습니다")
    private String category;

    @NotBlank(message = "MovieAddRequest.useYn 빈 값일 수 없습니다")
    private String useYn;
}
