package Covid.dao;

import Covid.model.EmpIden;
import Covid.model.MaterialManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MaterialDao {
    List<MaterialManage> selectList();

    List<EmpIden> selectPage();

    Long selectAll();

    Integer insert(@Param("material") MaterialManage material);

    MaterialManage selectById(Integer id);

    Integer updateById(@Param("material") MaterialManage material);

    void deleteById(Long id);

    List<MaterialManage> selectL(@Param("key") String searchkey,@Param("text") String stext);
}
