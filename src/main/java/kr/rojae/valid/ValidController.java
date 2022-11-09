package kr.rojae.valid;

import kr.rojae.valid.dto.*;
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

    @PostMapping("/account")
    public ResponseEntity<ApiBase> addAccount(@RequestBody @Valid AccountAddRequest request){
        AccountAddResponse response = new AccountAddResponse();
        response.setLoginId(request.getLoginId());
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiBase.builder().message("").response(response).build());
    }

}
