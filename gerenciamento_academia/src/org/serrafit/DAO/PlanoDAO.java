package org.serrafit.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.serrafit.conexao.ConexaoDB;

public class PlanoDAO {
	static PreparedStatement script = null;
	
	
	public static void cadastro (String nomePlano, float valorPlano, String descricaoPlano, int duracaoPlano) {
		String queryAvalicao = "INSERT INTO Plano (nomeplano, valorplano, descricaoPlano, duracaoPlano) "
							+ " values (?, ?, ?, ?)";
		try {
			script = ConexaoDB.criarConexao().prepareStatement(queryAvalicao);
			
			script.setString(1, nomePlano);
			script.setFloat(2, valorPlano);
			script.setString(3, descricaoPlano);
			script.setInt(4, duracaoPlano);
			
			script.executeUpdate();
			
		} catch (SQLException e){
			System.out.println("Erro: " + e);
		}
	}

	public static ResultSet consulta(String nomePlano) {
		String query = "Select * from Plano where nomeplano = ?";
		ResultSet resultadoConsulta = null;
		try {
			script = ConexaoDB.criarConexao().prepareStatement(query);
			
			script.setString(1, nomePlano);
			
			resultadoConsulta = script.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		
		return resultadoConsulta;
	}
}
