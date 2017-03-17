package pe.com.gmd.hibernate.core.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import pe.com.gmd.hibernate.core.entity.Regions;

public class RegionsDao implements BaseDao<Regions, BigDecimal>{

	private Session session = null;
	private Transaction tx = null;
	
	public void insertar(Regions entity) throws Exception {
		try {
			session = Conexion.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} catch (Exception e) {
			Conexion.rollback(tx);
			throw new Exception(e);
		} finally{
			Conexion.close(session);
		}
		
	}

	public void actualizar(Regions entity) throws Exception {
		try {
			session = Conexion.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
		} catch (Exception e) {
			Conexion.rollback(tx);
			throw new Exception(e);
		} finally{
			Conexion.close(session);
		}
		
	}

	public void eliminar(BigDecimal id) throws Exception {
		try {
			session = Conexion.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.delete(new Regions(id));
			tx .commit();
		} catch (Exception e) {
			Conexion.rollback(tx);
			throw new Exception(e);
		} finally{
			Conexion.close(session);
		}
		
	}
	
	public Regions obtener(BigDecimal id) throws Exception {
		Regions regions = null;
		try {
			session = Conexion.getSessionFactory().openSession();
			regions = session.get(Regions.class, id);
		} catch (Exception e) {
			throw new Exception(e);
		} finally{
			Conexion.close(session);
		}
		return regions;
	}

	@SuppressWarnings("unchecked")
	public List<Regions> listar() throws Exception {
		List<Regions> lista = null;
		try {
			session = Conexion.getSessionFactory().openSession();
			Query<Regions> query = session.createQuery("FROM Regions rs ORDER BY rs.regionId");
			lista = query.getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally{
			Conexion.close(session);
		}
		return lista;
	}
	
	
	public void insertar_sp(Regions entity) throws Exception {
		try {
			session = Conexion.getSessionFactory().openSession();
			StoredProcedureQuery query = session.createStoredProcedureQuery("sp_regions_insert");
			query.registerStoredProcedureParameter(1, BigDecimal.class, ParameterMode.OUT);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, entity.getRegionName());
			query.execute();
			entity.setRegionId((BigDecimal)query.getOutputParameterValue(1));
		} catch (Exception e) {
			throw new Exception(e);
		} finally{
			Conexion.close(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Regions> listar_sp() throws Exception{
		List<Regions> lista = null;
		try {
			session = Conexion.getSessionFactory().openSession();
			StoredProcedureQuery query = session.createStoredProcedureQuery("sp_regions_all");
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
		} catch (Exception e) {
			throw new Exception(e);
		} finally{
			Conexion.close(session);
		}
		return lista;
	}

	

}
