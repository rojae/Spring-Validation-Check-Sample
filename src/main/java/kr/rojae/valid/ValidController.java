package kr.rojae.valid;

import kr.rojae.valid.dto.MovieAddRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ValidController {

    @PostMapping("/")
    public ResponseEntity<String> addMovie(@RequestBody @Valid MovieAddRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(request.getName());
    }

}
