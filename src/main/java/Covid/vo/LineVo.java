package Covid.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class LineVo {
    private List<String> month;
    private Map<String,List> status;
}
