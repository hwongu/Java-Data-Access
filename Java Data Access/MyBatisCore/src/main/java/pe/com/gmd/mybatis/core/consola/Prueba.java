package pe.com.gmd.mybatis.core.consola;


import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pe.com.gmd.mybatis.core.dao.RegionsDao;
import pe.com.gmd.mybatis.core.entity.Regions;
import pe.com.gmd.mybatis.core.mapper.RegionsMapper;


public class Prueba {

	public static void main(String[] args) {
		try {
			RegionsDao regionsDao = new RegionsDao();
	        Regions regions = new Regions();
	        regions.setRegionName("Prueba");
			regionsDao.insertar_sp(regions);
			System.out.println("Insertooooooooooo: " + regions.getRegionId());
//			
//			regions.setRegionName("Actualizado");
//			regionsDao.actualizar(regions);
//			System.out.println("Actulizoooooooooooooo");
//			
//			Regions temp = regionsDao.obtener(new BigDecimal("1"));
//			System.out.println("ID: " + temp.getRegionId());
//			System.out.println("Nombre: " + temp.getRegionName());
//			System.out.println("===================================================================");
//	    	List<Regions> lista = regionsDao.listar();
//	    	for (Regions regions2 : lista) {
//				System.out.println("ID: " + regions2.getRegionId());
//				System.out.println("Nombre: " + regions2.getRegionName());
//			}
//	    	System.out.println("===================================================================");
//	    	regionsDao.eliminar(regions.getRegionId());
//	    	System.out.println("Elimino");
	    	
	    	
	    	
	    	
//	    	List<Regions> lista = regionsDao.listar_sp();
//	    	for (Regions regions2 : lista) {
//				System.out.println("ID: " + regions2.getRegionId());
//				System.out.println("Nombre: " + regions2.getRegionName());
//			}
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
