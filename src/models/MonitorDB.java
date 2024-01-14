package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import personal.Monitores;

public class MonitorDB {
	// ------------------------------------------------------------
	public static boolean AñadirMonitor(Monitores m) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			
			String ordensql = "INSERT INTO monitores (idmonitores, nombre) VALUES (?,?);";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,m.getIdMonitores());
			sentencia.setString(2,m.getNombre());
			
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
	public static ArrayList<Monitores> obtenerMonitor() {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return null;
		}
		ArrayList<Monitores> listaActividades = new ArrayList<Monitores>();
		try {
			Statement sentencia = conexion.createStatement();
			String ordenSQL = "SELECT * FROM monitores ORDER BY idmonitores";
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			while (resultado.next()) {
				String id = resultado.getString("idmonitores");
				String nombre= resultado.getString("nombre");
				Monitores m=new Monitores(id, nombre);
				listaActividades.add(m);
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
	public static boolean borrarMonitor(Monitores m) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			String ordensql = "DELETE FROM monitores WHERE idmonitores LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,m.getIdMonitores());
			
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
