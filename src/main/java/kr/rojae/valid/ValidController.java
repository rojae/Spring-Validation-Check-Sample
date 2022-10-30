package kr.rojae.valid;

import kr.rojae.valid.dto.ApiBase;
import kr.rojae.valid.dto.MovieAddRequest;
import kr.rojae.valid.dto.MovieAddResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ValidController {

    @PostMapping("/")
    public ResponseEntity<ApiBase> addMovie(@RequestBody @Valid MovieAddRequest request){
        MovieAddResponse response = new MovieAddResponse();
        response.setName(request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiBase.builder().message("").response(response).build());
    }

}
