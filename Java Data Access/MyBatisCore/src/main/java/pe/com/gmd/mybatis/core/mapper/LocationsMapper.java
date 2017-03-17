package pe.com.gmd.mybatis.core.mapper;

import java.math.BigDecimal;
import pe.com.gmd.mybatis.core.entity.Locations;

public interface LocationsMapper {
    int deleteByPrimaryKey(BigDecimal locationId);

    int insert(Locations record);

    int insertSelective(Locations record);

    Locations selectByPrimaryKey(BigDecimal locationId);

    int updateByPrimaryKeySelective(Locations record);

    int updateByPrimaryKey(Locations record);
}