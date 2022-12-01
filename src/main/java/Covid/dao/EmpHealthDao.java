package Covid.dao;

import Covid.model.EmpHealth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpHealthDao {

    List<EmpHealth> selectPage();

    Long findAll();

    int insert(@Param("emp") EmpHealth emp);

    EmpHealth selectById(@Param("id") Integer id);


    Integer updateById(@Param("emp") EmpHealth emp);

    void deleteById(@Param("l") Long l);
    List<EmpHealth> selectList(@Param("key") String searchkey,@Param("text") String stext);
}
