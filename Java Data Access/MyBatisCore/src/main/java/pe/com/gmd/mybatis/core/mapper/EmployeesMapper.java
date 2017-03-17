package pe.com.gmd.mybatis.core.mapper;

import java.math.BigDecimal;
import pe.com.gmd.mybatis.core.entity.Employees;

public interface EmployeesMapper {
    int deleteByPrimaryKey(BigDecimal employeeId);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(BigDecimal employeeId);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
}