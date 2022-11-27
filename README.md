
# Spring Validation Check Sample
---
## Blog
- not yet
---
## Implemented
- extension
  - @StringValid
- format
  - @IsDateValid
  - @IsIpValid
  - @IsUrlValid
  - @IsUrlPathValid
  - @IsUuidValid
  - @IsYnValid
- match
  - @NoSpecialValid
  - @OnlyAlphabetValid
  - @OnlyUpperValid
  - @OnlyDownerValid
  - @OnlyKoreanValid
  - @OnlyNumericValid
  - @OnlyNumericWithAlphabetValid
- @EmailValid
- @LoginIdValid
- @MovieCategoryValid
---
## With Database
- Getting Validation Rule in DB
```java
// Table : VALIDATION_RULE
List<ValidRuleDto> rules = validationRuleRepository.getRuleList(dbKeyName);
```
- Save Failed Validation Logging in DB
```java
// Table: VALIDATION_FAIL_LOG
validationFailLogRepository.save(new ValidationFailLog(...));
```
- Easy to see validation's logging with rule
```sql
SELECT  A.SEQ as "순번", A.TYPE AS "검증실패타입", A.KEYS as "유효성키", A.INPUT_DATA as "입력값" , A.REASON as "사유",  B.RULES as "검증룰 전체", A.INS_DATE as "발생일자"
FROM VALIDATION_FAIL_LOG A
left join (
    SELECT KEYS, GROUP_CONCAT(DISTINCT RULE SEPARATOR ', ') RULES 
    FROM VALIDATION_RULE 
    GROUP BY KEYS
) B
on A.KEYS = B.KEYS
ORDER BY SEQ DESC;
```

---
## Usage
```java
@Data
public class AccountAddRequest {
    @LoginIdValid(message = "loginId이 사용 불가능한 값입니다")
    private String loginId;

    @EmailValid(message = "email이 사용 불가능한 값입니다")
    private String email;

    @OnlyKoreanValid(message = "name은 한글만 입력이 가능합니다")
    private String name;

    @IsDateValid(message = "birthDate는 날짜 형식만 가능합니다 (yyyy.mm.dd)")
    private String birthDate;

    @OnlyNumericValid(message = "age는 숫자만 입력이 가능합니다")
    private String age;

    @IsUrlPathValid(message = "profileUrl은 URL 형식만 가능합니다")
    private String profileUrl;

    @IsYnValid(message = "isEnable이 유효한 값이 아닙니다. (Y, N)")
    private String isEnable;

    @IsIpValid(message = "clientIp는 IP 형식만 가능합니다")
    private String clientIp;

    @IsUuidValid(message = "reqId은 UUID 형식만 가능합니다")
    private String reqId;
}

```
---

## Test
- Request
```json
{
  "loginId": "testid123",
  "email": "test@gmail.com",
  "name": "김철수",
  "birthDate": "2001.10.30",
  "age": "25",
  "profileUrl": "ns-profile.company.com/image/2f48f241-9d64-4d16-bf56-70b9d4e0e79a.jpg",
  "isEnable": "N",
  "clientIp": "203.133.203.103",
  "reqId": "2f48f241-9d64-4d16-bf56-70b9d4e0e79a"
}
```

- Response
```json
{
  "message": "profileUrl은 URL 형식만 가능합니다",
  "response": ""
}
```
