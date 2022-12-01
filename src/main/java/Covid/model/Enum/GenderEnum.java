package Covid.model.Enum;

public enum GenderEnum {
    女(0, "女"),
    男(1, "男");


    GenderEnum(Integer code, String gender) {
        this.code = code;
        this.gender = gender;
    }

    private Integer code;
    private String gender;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
