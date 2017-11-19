package entityPojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClientsPlatinum")
public class ClientPlatinum implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * El identificador para la entidad clientes platino
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * Nombre de usuario de un cliente platino
	 */
	@Column(name = "user_name", nullable = false, length=30)
	private String userName;
	
	/**
	 * Contrasenia de un cliente platino
	 */
	@Column(nullable = false, length=30)
	private String password;

	/**
	 * Constructor que inicializa la clase con valores vacios
	 */
	public ClientPlatinum() {
		
	}

	/**
	 * Constructor que inicializa la clase con valores por parametro
	 * @param userName de usuario de un cliente platino
	 * @param password de un cliente platino
	 */
	public ClientPlatinum(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Devuelve el identificador para la entidad clientes platino
	 * @return identificador para la entidad clientes platino
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Asigna el identificador para la entidad clientes platino
	 * @param id para la entidad clientes platino
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre de usuario de un cliente platino
	 * @return nombre de usuario de un cliente platino
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Asigna nombre de usuario de un cliente platino
	 * @param nombre de usuario de un cliente platino
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Devuelve la contrasenia de un cliente platino
	 * @return contrasenia de un cliente platino
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Asigna la contrasenia de un cliente platino
	 * @param contrasenia de un cliente platino
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
