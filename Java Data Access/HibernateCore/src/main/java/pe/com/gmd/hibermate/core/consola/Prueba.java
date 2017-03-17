package pe.com.gmd.hibermate.core.consola;

import java.util.List;

import pe.com.gmd.hibernate.core.dao.Conexion;
import pe.com.gmd.hibernate.core.dao.RegionsDao;
import pe.com.gmd.hibernate.core.entity.Regions;



public class Prueba {

	
	public static void main(String[] args) {
		try {
//			RegionsDao regionsDao = new RegionsDao();
//			Regions regions = new Regions();
//		    regions.setRegionName("Hibernate");
//		    regionsDao.insertar(regions);
//		    System.out.println("ID: " + regions.getRegionId());
//		    regions.setRegionName("Hibernate2");
//		    regionsDao.actualizar(regions);
//		    System.out.println("Se actualizo");
//		    List<Regions> lista = regionsDao.listar();
//		    System.out.println("==============================================================================");
//		    for (Regions regions2 : lista) {
//				System.out.println("ID: " + regions2.getRegionId().intValue());
//				System.out.println("Nombre: " + regions2.getRegionName());
//			}
//		    System.out.println("==============================================================================");
//		    Regions regions3 = regionsDao.obtener(new BigDecimal("1"));
//		    System.out.println("ID: " + regions3.getRegionId().intValue());
//			System.out.println("Nombre: " + regions3.getRegionName());
//			
//		    regionsDao.eliminar(regions.getRegionId());
//		    System.out.println("Se elimino");
//		    Conexion.shutdown();
			
			RegionsDao regionsDao = new RegionsDao();
			Regions regions = new Regions();
			regions.setRegionName("RegistroSP");
			regionsDao.insertar_sp(regions);
			System.out.println("ID: " + regions.getRegionId());
		    List<Regions> lista = regionsDao.listar_sp();
		    System.out.println("==============================================================================");
		    for (Regions regions2 : lista) {
				System.out.println("ID: " + regions2.getRegionId().intValue());
				System.out.println("Nombre: " + regions2.getRegionName());
			}
		    Conexion.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
