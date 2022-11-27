package kr.rojae.dto;

import kr.rojae.validator.MovieCategoryValid;
import kr.rojae.validator.common.format.IsYnValid;
import kr.rojae.validator.common.match.OnlyKoreanValid;
import lombok.Data;

@Data
public class MovieAddRequest {
    @OnlyKoreanValid(message = "MovieAddRequest.name은 한글이여야 합니다")
    private String name;

    @MovieCategoryValid(message = "MovieAddRequest.category이 유효한 값이 아닙니다")
    private String category;

    @IsYnValid(message = "MovieAddRequest.useYn이 유효한 값이 아닙니다 (Y, N)")
    private String useYn;
}
