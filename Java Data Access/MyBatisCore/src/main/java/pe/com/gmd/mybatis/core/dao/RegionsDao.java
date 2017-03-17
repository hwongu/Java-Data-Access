package pe.com.gmd.mybatis.core.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import pe.com.gmd.mybatis.core.entity.Regions;
import pe.com.gmd.mybatis.core.mapper.RegionsMapper;

public class RegionsDao implements BaseDao<Regions, BigDecimal>{

	private SqlSession sqlSession = null;
	
	public void insertar(Regions entity) throws Exception {
		try {
			sqlSession = Conexion.obtenerConexion();
			RegionsMapper mapper = sqlSession.getMapper(RegionsMapper.class);
			mapper.insert(entity);
			Conexion.commit(sqlSession);
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			Conexion.close(sqlSession);
		}
		
	}

	public void actualizar(Regions entity) throws Exception {
		try {
			sqlSession = Conexion.obtenerConexion();
			RegionsMapper mapper = sqlSession.getMapper(RegionsMapper.class);
			mapper.updateByPrimaryKey(entity);
			Conexion.commit(sqlSession);
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			Conexion.close(sqlSession);
		}
		
	}

	public void eliminar(BigDecimal id) throws Exception {
		try {
			sqlSession = Conexion.obtenerConexion();
			RegionsMapper mapper = sqlSession.getMapper(RegionsMapper.class);
			mapper.deleteByPrimaryKey(id);
			Conexion.commit(sqlSession);
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			Conexion.close(sqlSession);
		}
		
	}

	public Regions obtener(BigDecimal id) throws Exception {
		Regions regions = null;
		try {
			sqlSession = Conexion.obtenerConexion();
			RegionsMapper mapper = sqlSession.getMapper(RegionsMapper.class);
			regions = mapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			Conexion.close(sqlSession);
		}
		return regions;
	}

	public List<Regions> listar() throws Exception {
		List<Regions> lista =null;
		try {
			sqlSession = Conexion.obtenerConexion();
			RegionsMapper mapper = sqlSession.getMapper(RegionsMapper.class);
			lista = mapper.selectAll();
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			Conexion.close(sqlSession);
		}
		return lista;
	}
	
	
	public List<Regions> listar_sp() throws Exception {
		List<Regions> lista =null;
		try {
			sqlSession = Conexion.obtenerConexion();
			RegionsMapper mapper = sqlSession.getMapper(RegionsMapper.class);
			Map<String, Object> params = new HashMap<String, Object>(); 
			ResultSet rs = null;
		    params.put("regions", rs);
		    mapper.selectAll_sp(params);
		    
			lista = (ArrayList<Regions>)params.get("regions");
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			Conexion.close(sqlSession);
		}
		return lista;
	}
	
	public void insertar_sp(Regions entity) throws Exception {
		try {
			sqlSession = Conexion.obtenerConexion();
			RegionsMapper mapper = sqlSession.getMapper(RegionsMapper.class);
			mapper.insert_sp(entity);
			//Conexion.commit(sqlSession);
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			Conexion.close(sqlSession);
		}
		
	}

}
