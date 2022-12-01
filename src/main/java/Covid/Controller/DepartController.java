package Covid.Controller;


import Covid.Service.DepartService;
import Covid.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private DepartService departService;
    @GetMapping("/findAll")
    private List<String> findAll(){
        List<Department> all = departService.getAll();
        List<String> l = new ArrayList<>();
        for (Department department : all) {
            l.add(department.getName());
        }
        return l;
    }
}
