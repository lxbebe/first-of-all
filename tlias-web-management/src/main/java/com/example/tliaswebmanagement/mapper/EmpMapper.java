package com.example.tliaswebmanagement.mapper;

import com.example.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    // @Select("<script>" +
    // "select e.*, d.name as deptName " +
    // "from emp e " +
    // "left join dept d on e.dept_id = d.id " +
    // "<where>" +
    // " <if test='name != null and name != \"\"'>" +
    // " and e.name like concat('%', #{name}, '%')" +
    // " </if>" +
    // " <if test='gender != null'>" +
    // " and e.gender = #{gender}" +
    // " </if>" +
    // " <if test='begin != null'>" +
    // " and e.entry_date &gt;= #{begin}" +
    // " </if>" +
    // " <if test='end != null'>" +
    // " and e.entry_date &lt;= #{end}" +
    // " </if>" +
    // "</where>" +
    // "</script>")
    List<Emp> list(@Param("name") String name,
            @Param("gender") Integer gender,
            @Param("begin") LocalDate begin,
            @Param("end") LocalDate end);
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    /**
     * 更新员工基本信息
     */
    void updateById(Emp emp);

    @MapKey("pos")//在 MyBatis 中，@MapKey 注解只用于返回值类型为 Map<K, V>的情况。作用：指定返回的 Map 的 key 对应数据库中的哪个字段。这里返回类型是 List而不是Map，因此@MapKey("pos")注解是多余的，加上这个注解仅仅是避免MyBatisX的误判
    List<Map<String, Object>> countEmpJobData();

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);
}