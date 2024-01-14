package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConfiguracionDB;
import models.Clientes;
import models.SuscripcionIndividual;


public class SusIndividualDB {

	// ------------------------------------------------------------
	public static boolean AñadirSuscripcionIndividual(SuscripcionIndividual s) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			
			String ordensql = "INSERT INTO suscripcionesindividuales (codSuscripcion, pagado, precio, nombreCliente, dni) VALUES (?,?,?,?,?);";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,s.getCodSuscripcion());
			sentencia.setBoolean(2, s.isPagado());
			sentencia.setDouble(3, s.getPrecio());
			sentencia.setString(4, s.getCliente().getNombre());
			sentencia.setString(5, s.getCliente().getdni());

			int filasafectadas = sentencia.executeUpdate();
			if (filasafectadas > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ------------------------------------------------------------
	public static ArrayList<SuscripcionIndividual> obtenersuscripcionesindividuales() {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return null;
		}
		ArrayList<SuscripcionIndividual> listasuscripcionesindividuales = new ArrayList<SuscripcionIndividual>();
		try {
			Statement sentencia = conexion.createStatement();
			String ordenSQL = "SELECT * FROM suscripcionesindividuales ORDER BY codSuscripcion";
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			while (resultado.next()) {
				String codSuscripcion = resultado.getString("codSuscripcion");
				Boolean pagado = resultado.getBoolean("pagado");
				double precio = resultado.getDouble("precio");
				String nombre = resultado.getString("nombreCliente");
				String dni = resultado.getString("dni");
				Clientes c = new Clientes(dni, nombre);
				SuscripcionIndividual s = new SuscripcionIndividual(codSuscripcion, pagado, c, precio);
				listasuscripcionesindividuales.add(s);
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return listasuscripcionesindividuales;
		} catch (SQLException e) {
			e.printStackTrace();
			return listasuscripcionesindividuales;
		}
	}

	// ------------------------------------------------------------
	public static boolean borrarSuscripcionIndividual(SuscripcionIndividual s) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			String ordensql = "DELETE FROM suscripcionesindividuales WHERE codSuscripcion LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,s.getCodSuscripcion());
			
			int filasafectadas = sentencia.executeUpdate();
			if (filasafectadas > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ------------------------------------------------------------
	public static boolean modificarSuscripcionIndividual(SuscripcionIndividual s) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			String ordenSQL = "UPDATE suscripcionesindividuales SET codSuscripcion=?, pagado=?, precio=?, nombreCliente=?, dni=? WHERE codSuscripcion LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(ordenSQL);
			sentencia.setString(1,s.getCodSuscripcion());
			sentencia.setBoolean(2, s.isPagado());
			sentencia.setDouble(3, s.getPrecio());
			sentencia.setString(4, s.getCliente().getNombre());
			sentencia.setString(5, s.getCliente().getdni());
			sentencia.setString(6, s.getCodSuscripcion());
			int filasafectadas = sentencia.executeUpdate();
			if (filasafectadas > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ------------------------------------------------------------
	public static ArrayList<SuscripcionIndividual> buscarPorCodigo(String SuscripcionIndividual) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return null;
		}
		ArrayList<SuscripcionIndividual> listasuscripcionesindividuales = new ArrayList<SuscripcionIndividual>();
		try {
			String ordensql = "SELECT * FROM suscripcionesindividuales WHERE codSuscripcion LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			String textobuscado = "%" + SuscripcionIndividual + "%";
			sentencia.setString(1, textobuscado);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				String codSuscripcion = resultado.getString("codSuscripcion");
				Boolean pagado = resultado.getBoolean("pagado");
				double precio = resultado.getDouble("precio");
				String nombre = resultado.getString("nombreCliente");
				String dni = resultado.getString("dni");
				Clientes c = new Clientes(dni, nombre);
				SuscripcionIndividual s = new SuscripcionIndividual(codSuscripcion, pagado, c, precio);
				listasuscripcionesindividuales.add(s);
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return listasuscripcionesindividuales;
		} catch (SQLException e) {
			e.printStackTrace();
			return listasuscripcionesindividuales;
		}
	}
}
