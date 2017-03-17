package pe.com.gmd.springdata.core.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.gmd.springdata.core.dao.RegionsDao;
import pe.com.gmd.springdata.core.entity.Regions;

/**
 * 
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@hwongu.net
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/java//pe/com/gmd/springdata/core/configuration/SpringContext.xml" })
public class ProductoTest {
	
	@Autowired
	private RegionsDao regionsDao;
	
	@Test
	public void testear(){
		try {
			Regions regions = new Regions();
			regions.setRegionName("Spring");
			regionsDao.insertar_sp(regions);
//			regions.setRegionId(BigDecimal.ZERO);
//			regions.setRegionId(regionsDao.insertarSp(regions.getRegionId(), regions.getRegionName()));
			System.out.println("Codigo: " + regions.getRegionId());
			List<Regions> lista = regionsDao.listar_sp();
			for (Regions regions2 : lista) {
				System.out.println("ID: " + regions2.getRegionId());
				System.out.println("Name: " + regions2.getRegionName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
