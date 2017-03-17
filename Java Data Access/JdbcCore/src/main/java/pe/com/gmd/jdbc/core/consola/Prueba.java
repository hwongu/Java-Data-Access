package pe.com.gmd.jdbc.core.consola;

import java.util.List;

import pe.com.gmd.jdbc.core.dao.RegionsDao;
import pe.com.gmd.jdbc.core.entity.Regions;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Regions regions = new Regions();
			RegionsDao regionsDao = new RegionsDao();
			//Insertar
			regions.setRegionName("GMD");
			regionsDao.insertar_sp(regions);
			System.out.println("Se guardó la región con ID: " + regions.getRegionId());
//			//Actualizar
//			regions.setRegionName("GYM");
//			regionsDao.actualizar(regions);
//			System.out.println("Se actualizo");
			
			System.out.println("============================================================");
			List<Regions> lista = regionsDao.listar_sp();
			for (Regions regions2 : lista) {
				System.out.println("ID: " + regions2.getRegionId());
				System.out.println("Name: " + regions2.getRegionName());
			}
			System.out.println("============================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
