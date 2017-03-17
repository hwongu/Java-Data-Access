package pe.com.gmd.jdbc.core.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;
import pe.com.gmd.jdbc.core.entity.Regions;

public class RegionsDao extends Conexion implements BaseDao<Regions, BigDecimal> {

	public void insertar(Regions entity) throws Exception {
		try {
			String sql = "INSERT INTO REGIONS(REGION_ID, REGION_NAME) VALUES(REGIONS_SEQ.NEXTVAL, ?)";
			cn = obtenerConexion();
			pr = cn.prepareStatement(sql, new String[] { "REGION_ID" });
			pr.setString(1, entity.getRegionName());
			pr.executeUpdate();
			rs = pr.getGeneratedKeys();
			if (rs != null && rs.next()) {
				entity.setRegionId(new BigDecimal(rs.getLong(1)));
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			cerrar(rs);
			cerrar(pr);
			cerrar(cn);
		}

	}

	public void actualizar(Regions entity) throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE REGIONS SET REGION_NAME=? WHERE REGION_ID=?");
			cn = obtenerConexion();
			pr = cn.prepareStatement(sql.toString());
			pr.setString(1, entity.getRegionName());
			pr.setBigDecimal(2, entity.getRegionId());
			pr.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			cerrar(pr);
			cerrar(cn);
		}

	}

	public void eliminar(BigDecimal id) throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM REGIONS WHERE REGION_ID=?");
			cn = obtenerConexion();
			pr = cn.prepareStatement(sql.toString());
			pr.setBigDecimal(1, id);
			pr.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			cerrar(pr);
			cerrar(cn);
		}

	}

	public Regions obtener(BigDecimal id) throws Exception {
		Regions regions = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM REGIONS WHERE REGION_ID=?");
			cn = obtenerConexion();
			pr = cn.prepareStatement(sql.toString());
			pr.setBigDecimal(1, id);
			rs = pr.executeQuery();
			while (rs.next()) {
				regions = new Regions();
				regions.setRegionId(rs.getBigDecimal(1));
				regions.setRegionName(rs.getString(2));
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			cerrar(rs);
			cerrar(pr);
			cerrar(cn);
		}
		return regions;
	}

	public List<Regions> listar() throws Exception {
		List<Regions> lista = null;
		Regions regions = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM REGIONS ORDER BY REGION_ID");
			cn = obtenerConexion();
			pr = cn.prepareStatement(sql.toString());
			rs = pr.executeQuery();
			while (rs.next()) {
				if (lista == null) {
					lista = new ArrayList<Regions>();
				}
				regions = new Regions();
				regions.setRegionId(rs.getBigDecimal(1));
				regions.setRegionName(rs.getString(2));
				lista.add(regions);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			cerrar(rs);
			cerrar(pr);
			cerrar(cn);
		}
		return lista;
	}

	public void insertar_sp(Regions entity) throws Exception {
		try {
			cn = obtenerConexion();
			cl = cn.prepareCall("{CALL sp_regions_insert(?,?)}");
			cl.registerOutParameter(1, OracleTypes.INTEGER);
			cl.setString(2, entity.getRegionName());
			cl.executeUpdate();
			entity.setRegionId(cl.getBigDecimal(1));
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			cerrar(rs);
			cerrar(pr);
			cerrar(cn);
		}

	}
	
	public List<Regions> listar_sp() throws Exception {
		List<Regions> lista = null;
		Regions regions = null;
		try {
			cn = obtenerConexion();
			cl = cn.prepareCall("{CALL sp_regions_all(?)}");
			cl.registerOutParameter(1,  OracleTypes.CURSOR);
			cl.execute();
			rs = (ResultSet)cl.getObject(1);
			while (rs.next()) {
				if (lista == null) {
					lista = new ArrayList<Regions>();
				}
				regions = new Regions();
				regions.setRegionId(rs.getBigDecimal(1));
				regions.setRegionName(rs.getString(2));
				lista.add(regions);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			cerrar(rs);
			cerrar(pr);
			cerrar(cn);
		}
		return lista;
	}


}
