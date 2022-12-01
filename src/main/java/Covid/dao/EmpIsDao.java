package Covid.dao;

import Covid.model.EmpIden;
import Covid.model.EmpIs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpIsDao {
    Integer selectCountRight(String s);

    List<EmpIden> selectPage();

    Long selectAll();

    Integer insert(@Param("empis") EmpIs empis);

    EmpIs selectById(Integer id);

    Integer updateById(@Param("empis") EmpIs empIs);

    void deleteById(Long id);

    List<EmpIs> selectList(@Param("key") String searchkey,@Param("text") String stext);
}
