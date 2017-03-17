package pe.com.gmd.springdata.core.dao;


import java.math.BigDecimal;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.gmd.springdata.core.dao.custom.RegionsDaoCustom;
import pe.com.gmd.springdata.core.entity.Regions;

/**
 * 
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@hwongu.net
 */
@Repository
public interface RegionsDao extends CrudRepository<Regions, BigDecimal>, RegionsDaoCustom{

}
