package Covid.Controller;

import Covid.Base.Page;
import Covid.model.EmpIden;
import Covid.Service.ChartService;
import Covid.Service.EmpIdenService;
import Covid.vo.LineVo;
import Covid.vo.PieVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empiden")
public class EmpIdenController {
    @Autowired
    private ChartService chartService;
    @Autowired
    private EmpIdenService empIdenService;

    @GetMapping("/findAll/{page}/{size}")
    public Page<EmpIden> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size){
        PageHelper.startPage(page,size);
        Page<EmpIden> result = empIdenService.selectPage();
        result.setPageNum(String.valueOf(page));
        result.setPageSize(String.valueOf(size));
        if (result.getTotal()%size != 0){
            result.setPages((int) ((result.getTotal()/size)+1));
        }else {
            result.setPages((int) (result.getTotal() / size));
        }
        return result;
    }

    @PostMapping("/save")
    public String save(@RequestBody EmpIden empIden){
        int result = empIdenService.insert(empIden);
        if (result == 1){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/LineVO")
    public LineVo getLineVo(){
        return this.chartService.lineVoList();
    }
    @GetMapping("/PieVO")
    public List<PieVo> getPieVo(){
        return chartService.pieVoMap();
    }
    @GetMapping("/findById/{id}")
    public EmpIden findById(@PathVariable("id")Integer id){
        return empIdenService.selectById(id);
    }
    @PutMapping("/update")
    public String update(@RequestBody EmpIden empIden){
        int result = empIdenService.updateById(empIden);
        if (result == 1){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        empIdenService.deleteById(id);
    }
    @GetMapping("/search/{searchkey}/{stext}")
    public List<EmpIden> search(@PathVariable("searchkey")String searchkey,@PathVariable("stext")String stext){
        return empIdenService.selectList(searchkey,stext);
    }
}
