package Covid.dao;

import Covid.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> selectList(@Param("users") User users);

    Integer insert(@Param("user") User user);
}
