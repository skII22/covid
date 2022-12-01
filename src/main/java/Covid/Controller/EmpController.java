package Covid.Controller;

import Covid.Base.Page;
import Covid.model.EmpHealth;
import Covid.Service.EmpService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/findAll/{page}/{size}")
    public Page<EmpHealth> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        Page<EmpHealth> result = service.selectpage();
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
    public String save(@RequestBody EmpHealth emp){
        int result = service.insert(emp);
        if (result == 1){
            return "success";
        }else {
            return "erroe";
        }
    }
    @GetMapping("/findById/{id}")
    public EmpHealth findById(@PathVariable("id") Integer id){
        return service.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody EmpHealth emp){
        int result = service.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.deleteById(id);
    }
    @GetMapping("/search/{searchkey}/{stext}")
    public List<EmpHealth> search(@PathVariable("searchkey")String searchkey,@PathVariable("stext")String stext){
        return service.selectList(searchkey,stext);
    }
}
