package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManagerDomiciliesTool {

	private static final SessionFactory sessionFactory;

	/**
	 * Crea un elemento en la tabla deacuerdo al objeto que se pase por parametro
	 * Hibernate dependiendo la clase del objeto lo adiciona automaticamente en la tabla correspondiente
	 * @param element
	 */
	public static <T> void createElement(T element) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(element);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Busca un elemento en la tabla que se especifique por parametro
	 * Si elemento no se encuentra genera un error controlable al usar try catch
	 * @param entityName Corresponde al nombre de la clase y no al de la tabla, es decir Category en vez de Categories
	 * @param idElement Id del elemento a buscar
	 * @return Elemento especificado
	 */
	public static <T> T getElementOfTableForId(String entityName, int idElement) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query queryHql = session.createQuery("FROM " + entityName + " WHERE ID = " + idElement);
		@SuppressWarnings("unchecked")
		T element = (T) queryHql.list().get(0);
		session.getTransaction().commit();
		session.close();
		return element;
	}
	
	/**
	 * Busca todos los elementos en la tabla que se especifique por parametro
	 * Si la tabla no contiene elementos devuelve una lista valia
	 * @param entityName Corresponde al nombre de la clase y no al de la tabla, es decir Category en vez de Categories
	 * @return Los elementos de la tabla
	 */
	public static <T> List<T> getElementOfTable(String entityName) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query queryHql = session.createQuery("FROM " + entityName);
		@SuppressWarnings("unchecked")
		List<T> elements = queryHql.list();
		session.getTransaction().commit();
		session.close();
		return elements;
	}

	/**
	 * Actualiza ta tabla especificada por parametro
	 * @param entityName Corresponde al nombre de la clase y no al de la tabla, es decir Category en vez de Categories
	 * @param idElement Id del elemento a actualizar
	 * @param newElement Un objeto con la informacion nueva
	 */
	@SuppressWarnings("unchecked")
	public static <T> void updateElement(String entityName, int idElement, T newElement) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query queryHql = session.createQuery("FROM " + entityName + " WHERE ID = " + idElement);
		T result = (T) queryHql.list().get(0);
		session.update(result);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Remueve un elemento de tabla especificada por parametro
	 * @param entityName Corresponde al nombre de la clase y no al de la tabla, es decir Category en vez de Categories
	 * @param idElement Id del elemento a eliminar
	 */
	public static <T> void removeElement(String entityName, int idElement) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query queryHql = session.createQuery("FROM " + entityName + " WHERE ID = " + idElement);
		@SuppressWarnings("unchecked")
		List<T> results = queryHql.list();

		for (T element : results) {
			session.delete(element);
		}
		session.getTransaction().commit();
		session.close();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * Verifica si existe una conexion con la base de datos segun los datos de la configuracion de Hibernate
	 * @return Verdadero o Falso si se puede hacer o no conexion
	 */
	public static boolean canConnection() {
		try {
			getSessionFactory().getCurrentSession();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	static {
		try {
			sessionFactory = new Configuration().configure("/dao/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Ocurrio un Error creando de SessionFactory: " + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

}