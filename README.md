
# Spring Validation Check Sample
---
## Blog
- https://github.com/rojae/Spring-Validation-Check-Sample/tree/v2

---
## Implemented
- @StringValid
- @MovieCategoryValid
---

## Usage
```java
public class MovieAddRequest {
    @NotBlank(message = "MovieAddRequest.name은 빈 값일 수 없습니다")
    private String name;

    @MovieCategoryValid(message = "MovieAddRequest.category이 유효한 값이 아닙니다")
    private String category;

    @StringValid(acceptedList = {"Y", "N"}, message = "MovieAddRequest.useYn이 유효한 값이 아닙니다")
    private String useYn;
}
```
---

## Test
- Request
```json
{
  "name": "",
  "category": "??",
  "useYn": "?"
}
```

- Response
```json
{
  "message": "MovieAddRequest.category이 유효한 값이 아닙니다, MovieAddRequest.name은 빈 값일 수 없습니다, MovieAddRequest.useYn이 유효한 값이 아닙니다",
  "response": ""
}
```
