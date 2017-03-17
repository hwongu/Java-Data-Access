package pe.com.gmd.mybatis.core.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import pe.com.gmd.mybatis.core.entity.Regions;

public interface RegionsMapper {
    int deleteByPrimaryKey(BigDecimal regionId);

    int insert(Regions record);

    int insertSelective(Regions record);

    Regions selectByPrimaryKey(BigDecimal regionId);

    int updateByPrimaryKeySelective(Regions record);

    int updateByPrimaryKey(Regions record);
    
    List<Regions> selectAll();
    
    Object selectAll_sp(Map<String, Object> params);
    
    void insert_sp(Regions record);

}