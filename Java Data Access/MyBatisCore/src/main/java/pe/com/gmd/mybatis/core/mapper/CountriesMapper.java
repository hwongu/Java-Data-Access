package pe.com.gmd.mybatis.core.mapper;

import pe.com.gmd.mybatis.core.entity.Countries;

public interface CountriesMapper {
    int deleteByPrimaryKey(String countryId);

    int insert(Countries record);

    int insertSelective(Countries record);

    Countries selectByPrimaryKey(String countryId);

    int updateByPrimaryKeySelective(Countries record);

    int updateByPrimaryKey(Countries record);
}