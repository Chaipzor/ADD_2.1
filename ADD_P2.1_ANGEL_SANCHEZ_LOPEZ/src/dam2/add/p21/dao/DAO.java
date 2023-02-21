package dam2.add.p21.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T, K> {

	void insertar(T a) throws SQLException;

	void modificar(T a) throws SQLException;

	void eliminar(T a) throws SQLException;

	List<T> obtenerTodos() throws Exception;

	T obtener(Long id) throws SQLException;

}
