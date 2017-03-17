package pe.com.gmd.springdata.core.dao.custom;

import java.util.List;

import pe.com.gmd.springdata.core.entity.Regions;

public interface RegionsDaoCustom {

	void insertar_sp(Regions regions) throws Exception;

	List<Regions> listar_sp() throws Exception;
}
