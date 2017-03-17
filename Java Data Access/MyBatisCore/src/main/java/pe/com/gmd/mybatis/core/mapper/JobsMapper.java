package pe.com.gmd.mybatis.core.mapper;

import pe.com.gmd.mybatis.core.entity.Jobs;

public interface JobsMapper {
    int deleteByPrimaryKey(String jobId);

    int insert(Jobs record);

    int insertSelective(Jobs record);

    Jobs selectByPrimaryKey(String jobId);

    int updateByPrimaryKeySelective(Jobs record);

    int updateByPrimaryKey(Jobs record);
}