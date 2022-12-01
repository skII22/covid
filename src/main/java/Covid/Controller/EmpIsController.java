package Covid.Controller;

import Covid.Base.Page;
import Covid.model.EmpIs;
import Covid.Service.EmpIsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/empis")
public class EmpIsController {
    @Autowired
    private EmpIsService service;

    @GetMapping("/findAll/{page}/{size}")
    public Page<EmpIs> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size){
        PageHelper.startPage(page,size);
        Page<EmpIs> result = service.selectPage();
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
    public String save(@RequestBody EmpIs empis){
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(empis.getBegin());
        c.add(Calendar.DAY_OF_MONTH,14);
        Date end = c.getTime();
        empis.setEnd(end);
        int result = service.insert(empis);
        if (result == 1) {
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public EmpIs findById(@PathVariable("id") Integer id){
        return service.selectById(id);
    }
    @PutMapping("/update")
    public String update(@RequestBody EmpIs empIs){
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(empIs.getBegin());
        c.add(Calendar.DAY_OF_MONTH,14);
        Date end = c.getTime();
        empIs.setEnd(end);
        int result = service.updateById(empIs);
        if (result == 1) {
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
    public List<EmpIs> search(@PathVariable("seaerchkey")String searchkey,@PathVariable("stext")String stext){
        return service.selectList(searchkey,stext);
    }
}
