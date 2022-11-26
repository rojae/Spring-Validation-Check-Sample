package kr.rojae.validator.error;

public enum VaildFailCode {

    KEY_UNDEFINED("STARTUP", "Key is not defined from database"),
    API_REFUSED("API", "API is refused"),
    UNKNOWN("", "");

    private final String type;
    private final String reason;

    VaildFailCode(String type, String reason) {
        this.type = type;
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }

    public static VaildFailCode valueOfName(String name){
        for(var e : VaildFailCode.values()){
            if(e.name().equals(name)){
                return e;
            }
        }
        return UNKNOWN;
    }
}
