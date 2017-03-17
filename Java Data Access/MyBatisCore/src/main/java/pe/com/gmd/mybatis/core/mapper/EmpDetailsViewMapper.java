package pe.com.gmd.mybatis.core.mapper;

import pe.com.gmd.mybatis.core.entity.EmpDetailsView;

public interface EmpDetailsViewMapper {
    int insert(EmpDetailsView record);

    int insertSelective(EmpDetailsView record);
}