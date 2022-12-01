package Covid.dao;


import Covid.model.EmpIden;

import Covid.model.Enum.ImpEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface EmpIdenDao {

    List<EmpIden> selectPage();
    Long findAll();
    List<String> getmonth();
    List<ImpEnum> getStatusEnum(String sname);

    Integer selectCount(String s,String t);


    Integer insert(@Param("empiden") EmpIden empIden);

    EmpIden selectById(@Param("id") Integer id);

    Integer updateById(@Param("empiden") EmpIden empIden);

    void deleteById(Long id);

    List<EmpIden> selectList(@Param("key") String searchkey,@Param("text") String stext);
}
