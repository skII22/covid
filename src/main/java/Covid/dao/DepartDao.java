package Covid.dao;

import Covid.model.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartDao {

    List<Department> selectAll();
}
