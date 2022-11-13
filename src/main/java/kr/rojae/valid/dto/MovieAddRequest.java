package kr.rojae.valid.dto;

import kr.rojae.valid.validator.MovieCategoryValid;
import kr.rojae.valid.validator.common.extension.StringValid;
import kr.rojae.valid.validator.common.format.IsYnValid;
import kr.rojae.valid.validator.common.match.OnlyKoreanValid;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MovieAddRequest {
    @OnlyKoreanValid(message = "MovieAddRequest.name은 한글이여야 합니다")
    private String name;

    @MovieCategoryValid(message = "MovieAddRequest.category이 유효한 값이 아닙니다")
    private String category;

    @IsYnValid(message = "MovieAddRequest.useYn이 유효한 값이 아닙니다 (Y, N)")
    private String useYn;
}
