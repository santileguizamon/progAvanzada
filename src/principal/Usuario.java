package principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Usuario {

	public int id;
	public String usuario;
	public String contraseña;
	public int rol;
	
	public Usuario() {
		
	}
	public Usuario(int id, String usuario, String contraseña,int rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	public Usuario(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", contraseña=" + contraseña + ", rol=" + rol + "]";
	}
	public static String IniciarSesion(String usuario, String contraseña) {

		UsuarioControlador controlador = new UsuarioControlador();

		if (controlador.getAllUsers().isEmpty()) {
			return "No hay usuarios";
		} else {
			
			for (Usuario usuario1 : controlador.getAllUsers()) {
				if (usuario1.getUsuario().equals(usuario) && usuario1.getContraseña().equals(contraseña)) {
					return Integer.toString(usuario1.getRol()) ;
				}
			}
			return "No se encontró";

		}

	}


	public static String Registrarse(String usuario, String contraseña) {

		UsuarioControlador controlador = new UsuarioControlador();

		if (usuario.length()>3 ) {
			if (contraseña.length()>3) {
				for (Usuario usuario1 : controlador.getAllUsers()) {
					if (usuario1.getUsuario().equals(usuario1)) {
						return "Usuario existente";
					}
				}
				controlador.addUser(new Usuario(usuario,contraseña));
				return "Ok";
			} else {
				return "Ingrese un usuario valido(Minimo 4 letras)";
			}
		} else {
			return "Ingrese una contraseña valida(Minimo 4 letras)";
		}

	}
	
	
	
}
