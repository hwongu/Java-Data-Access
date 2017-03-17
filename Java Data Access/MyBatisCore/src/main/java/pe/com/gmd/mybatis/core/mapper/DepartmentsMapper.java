package pe.com.gmd.mybatis.core.mapper;

import java.math.BigDecimal;
import pe.com.gmd.mybatis.core.entity.Departments;

public interface DepartmentsMapper {
    int deleteByPrimaryKey(BigDecimal departmentId);

    int insert(Departments record);

    int insertSelective(Departments record);

    Departments selectByPrimaryKey(BigDecimal departmentId);

    int updateByPrimaryKeySelective(Departments record);

    int updateByPrimaryKey(Departments record);
}