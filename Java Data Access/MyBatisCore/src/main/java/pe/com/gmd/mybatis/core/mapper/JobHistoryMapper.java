package pe.com.gmd.mybatis.core.mapper;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import pe.com.gmd.mybatis.core.entity.JobHistory;

public interface JobHistoryMapper {
    int deleteByPrimaryKey(@Param("employeeId") BigDecimal employeeId, @Param("startDate") Date startDate);

    int insert(JobHistory record);

    int insertSelective(JobHistory record);

    JobHistory selectByPrimaryKey(@Param("employeeId") BigDecimal employeeId, @Param("startDate") Date startDate);

    int updateByPrimaryKeySelective(JobHistory record);

    int updateByPrimaryKey(JobHistory record);
}