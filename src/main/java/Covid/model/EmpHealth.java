package Covid.model;

import Covid.model.Enum.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class EmpHealth {
    private Long id;
    private String name;
    private GenderEnum sex;
    private Long phonenum;
    private float temp;
    private String risk;
    private String health;
    private String content;
    private String depart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
