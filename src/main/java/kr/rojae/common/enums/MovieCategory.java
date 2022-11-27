package kr.rojae.common.enums;

public enum MovieCategory {
    ROMANCE("로맨스"),
    SF("SF"),
    ANIMATION("애니메이션"),
    UNKNOWN("알 수 없음");

    private String value;

    MovieCategory(String value) {
        this.value = value;
    }

    public static MovieCategory valueOfName(String name){
        for(var e : MovieCategory.values()){
            if(e.name().equals(name)){
                return e;
            }
        }
        return UNKNOWN;
    }
}
