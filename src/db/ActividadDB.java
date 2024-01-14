package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConfiguracionDB;
import models.Actividades;

public class ActividadDB {
	// ------------------------------------------------------------
	public static boolean AñadirActividad(Actividades a) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			
			String ordensql = "INSERT INTO actividad (nombre, duracion, sesiones) VALUES (?,?,?);";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,a.getNombre());
			sentencia.setDouble(2, a.getDuracion());
			sentencia.setInt(3, a.getSesiones());
			
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
	public static ArrayList<Actividades> obtenerActividades() {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return null;
		}
		ArrayList<Actividades> listaActividades = new ArrayList<Actividades>();
		try {
			Statement sentencia = conexion.createStatement();
			String ordenSQL = "SELECT * FROM actividad ORDER BY nombre";
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				double duracion= resultado.getDouble("duracion");
				int sesiones = resultado.getInt("sesiones");
				Actividades a=new Actividades(nombre, duracion, sesiones);
				listaActividades.add(a);
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return listaActividades;
		} catch (SQLException e) {
			e.printStackTrace();
			return listaActividades;
		}
	}

	// ------------------------------------------------------------
	public static boolean borrarActividad(Actividades a) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			String ordensql = "DELETE FROM actividad WHERE nombre LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,a.getNombre());
			
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

}