package kr.rojae.valid.dto;

import kr.rojae.valid.enums.MovieCategory;
import lombok.Data;

@Data
// @Entity (실제 데이터베이스와 연결하지 않음)
public class Movie {
    private String name;
    private MovieCategory category;
    private String useYn;
}
