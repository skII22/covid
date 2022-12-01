package Covid.model;

import Covid.model.Enum.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class EmpIden {
    private Long id;
    private String name;
    private String status;
    private GenderEnum sex;
    private Long idcard;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date idate;
    private String place;
    private String depart;
    private Long phonenum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm;ss",timezone = "GMT+8")
    private Date register;
}
