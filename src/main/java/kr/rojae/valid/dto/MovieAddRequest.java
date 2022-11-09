package kr.rojae.valid.dto;

import kr.rojae.valid.validator.MovieCategoryValid;
import kr.rojae.valid.validator.common.StringValid;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MovieAddRequest {
    @NotBlank(message = "MovieAddRequest.name은 빈 값일 수 없습니다")
    private String name;

    @MovieCategoryValid(message = "MovieAddRequest.category이 유효한 값이 아닙니다")
    private String category;

    @StringValid(acceptedList = {"Y", "N"}, message = "MovieAddRequest.useYn이 유효한 값이 아닙니다")
    private String useYn;
}
