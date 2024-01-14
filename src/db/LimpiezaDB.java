package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConfiguracionDB;
import models.Limpieza;

public class LimpiezaDB {
	// ------------------------------------------------------------
	public static boolean AñadirLimpieza(Limpieza l) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			
			String ordensql = "INSERT INTO limpieza (idlimpieza, nombre) VALUES (?,?);";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,l.getIdLimpieza());
			sentencia.setString(2,l.getNombre());
			
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
	public static ArrayList<Limpieza> obtenerLimpieza() {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return null;
		}
		ArrayList<Limpieza> listaActividades = new ArrayList<Limpieza>();
		try {
			Statement sentencia = conexion.createStatement();
			String ordenSQL = "SELECT * FROM limpieza ORDER BY idlimpieza";
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			while (resultado.next()) {
				String id = resultado.getString("idlimpieza");
				String nombre= resultado.getString("nombre");
				Limpieza l=new Limpieza(id, nombre);
				listaActividades.add(l);
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
	public static boolean borrarLimpieza(Limpieza l) {
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if (conexion == null) {
			return false;
		}
		try {
			String ordensql = "DELETE FROM limpieza WHERE idlimpieza LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1,l.getIdLimpieza());
			
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
