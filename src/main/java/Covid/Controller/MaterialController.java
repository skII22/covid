package Covid.Controller;

import Covid.Base.Page;
import Covid.Service.MaterialService;
import Covid.model.MaterialManage;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Material")
public class MaterialController {
    @Autowired
    private MaterialService service;

    @GetMapping("/findAll/{page}/{size}")
    public Page<MaterialManage> findAll(@PathVariable("page") Integer page, @PathVariable("size")Integer size){
        PageHelper.startPage(page,size);
        Page<MaterialManage> result = service.selectPage();
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
    public String save(@RequestBody MaterialManage material){
        int result = service.insert(material);
        if (result == 1) {
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public MaterialManage findById(@PathVariable("id") Integer id){
        return service.selectById(id);
    }
    @PutMapping("/update")
    public String update(@RequestBody MaterialManage material){
        int result = service.updateById(material);
        if (result == 1) {
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }
    @GetMapping("/search/{searchkey}/{stext}")
    public List<MaterialManage> search(@PathVariable("searchkey")String searchkey,@PathVariable("stext")String stext){
        return service.selectList(searchkey,stext);
    }
}
