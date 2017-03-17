package pe.com.gmd.hibernate.core.dao;

import java.util.List;

public interface BaseDao<E, ID> {

	void insertar(E entity) throws Exception;
	
	void actualizar(E entity) throws Exception;
	
	void eliminar(ID id) throws Exception;
	
	E obtener(ID id) throws Exception;
	
	List<E> listar() throws Exception;
}
