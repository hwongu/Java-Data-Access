package pe.com.gmd.springdata.core.dao.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pe.com.gmd.springdata.core.dao.custom.RegionsDaoCustom;
import pe.com.gmd.springdata.core.entity.Regions;

public class RegionsDaoImpl implements RegionsDaoCustom{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	private EntityManager em;

	public void insertar_sp(Regions regions) throws Exception {
		StoredProcedureQuery query = this.em.createStoredProcedureQuery("sp_regions_insert");
		query.registerStoredProcedureParameter(1, BigDecimal.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, regions.getRegionName());
		query.execute();
		regions.setRegionId((BigDecimal)query.getOutputParameterValue(1));
		
	}

	public List<Regions> listar_sp() throws Exception {
		List<Regions> lista = null;
		StoredProcedureQuery query = this.em.createStoredProcedureQuery("sp_regions_all");
		query.registerStoredProcedureParameter(1, Class.class, ParameterMode.REF_CURSOR);
		query.execute();
		List<Object[]> listaTemp = query.getResultList();
		for(Object[] fila : listaTemp){
			if(lista==null){
				lista = new ArrayList<Regions>();
			}
			Regions regions = new Regions();
			regions.setRegionId((BigDecimal) fila[0]);
			regions.setRegionName((String)fila[1]);
			lista.add(regions);
		}
		return lista;
	}

}
