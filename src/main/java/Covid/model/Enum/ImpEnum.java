package Covid.model.Enum;

public enum ImpEnum {
    否(0,"否"),
    是(1,"是");
    ImpEnum(Integer code,String isImp){
        this.code=code;
        this.isImp=isImp;
    }

    private Integer code;
    private String isImp;
}
