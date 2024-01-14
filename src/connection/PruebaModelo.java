package connection;

import java.sql.Connection;

public class PruebaModelo {

		public static void main(String[] args) {
	      Connection c = ConfiguracionDB.conectarConBaseDeDatos();
		  if(c != null)
		  {
			  System.out.println("CONEXION OK");
		  }
		  else {
			  System.out.println("ERROR AL CONECTAR");
		  }
		}

}
