package pe.com.gmd.mybatis.core.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Conexion {

	public static SqlSession obtenerConexion() throws Exception{
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		return sqlSessionFactory.openSession();
	}
	
	public static void commit(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.commit();
		}
	}
	
	public static void rollback(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.rollback();
		}
	}
	
	public static void close(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
			sqlSession = null;
		}
	}
	

}
