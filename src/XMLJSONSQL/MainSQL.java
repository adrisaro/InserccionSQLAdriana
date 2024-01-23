package XMLJSONSQL;

import java.sql.*;
import java.util.ArrayList;

public class MainSQL {

	private static Connection crearConexion() {
		String usr = "root";
		String pass = "admin";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String urlCon = "jdbc:mysql://localhost:3306/reservas";
			Connection con = DriverManager.getConnection(urlCon, usr, pass);
			
			System.out.println("Conexión creada");

			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	public static ArrayList<String[]> recabarInformacionReserva(ArrayList<String[]> listaDefinitiva) throws SQLException {
	
		Connection con = crearConexion();
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM reservas.reservas ORDER BY id_reserva DESC LIMIT 1;");
		if(result.next()) { 
			 //int id = result.getInt("first_column_name");  name = new ();
			String str1 = result.getString("nombre");
			String str2 = result.getString("telefono");
			String str3 = result.getString("fechaEvento");
			String str4 = result.getString("tipo");
			String str5 = result.getString("asistentes");
			String str6 = result.getString("tipoCocina");
			String str7 = result.getString("numeroJornadas");
			String str8 = result.getString("habitaciones");
			String str9 = result.getString("tipoMesa");
			String str10 = result.getString("comensalesMesa");
			
			String[] lista1 = {"Nombre",str1};
			String[] lista2 = {"Telefono",str2};
			String[] lista3 = {"Fecha ",str3};
			String[] lista4 = {"Tipo ",str4};
			String[] lista5 = {"NumeroPersonas",str5};
			String[] lista6 = {"TipoCocina",str6};
			String[] lista7 = {"NumeroJornadas",str7};
			String[] lista8 = {"NumeroHabitaciones",str8};
			String[] lista9 = {"TipoMesa",str9};
			String[] lista10 = {"NumeroComensales",str10};
			
			listaDefinitiva.add(lista1);
			listaDefinitiva.add(lista2);
			listaDefinitiva.add(lista3);
			listaDefinitiva.add(lista4);
			listaDefinitiva.add(lista5);
			listaDefinitiva.add(lista6);
			listaDefinitiva.add(lista7);
			listaDefinitiva.add(lista8);
			listaDefinitiva.add(lista9);
			listaDefinitiva.add(lista10);
		}
		System.out.println("Comando ejecutado");
		
		cerrarConexion(st, con);
		return listaDefinitiva;
	}
	
	public static void ejecutarComando(String consulta) throws SQLException {
		Connection con = crearConexion();
		Statement st = con.createStatement();
		int result = st.executeUpdate(consulta);
		System.out.println("Comando ejecutado");
		
		cerrarConexion(st, con);
	}

	private static void cerrarConexion(Statement st, Connection con) throws SQLException {
		st.close();
		con.close();
		System.out.println("Conexión cerrada");
	}
}

