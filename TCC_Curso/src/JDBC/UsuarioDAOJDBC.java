package JDBC;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAOJDBC implements UsuarioDAO {//aqui também, criado o implements
	
	private JDBCUtil banco;
	
	public UsuarioDAOJDBC() {
		banco = new JDBCUtil();
	}

	public class RetornoInsert
	{
		boolean exito = true;
		String mensagem;
		int qtderro;
		Usuario usuario;
	}
	
	public RetornoInsert validarinserir(String cpf, String nome, String senha, String confirmarsenha) {

		RetornoInsert retornoinsert = new RetornoInsert();
		String camposnaopreenchidos = "";
		
	    if(nome.isEmpty())
	    {
	    	retornoinsert.qtderro++;
	    	retornoinsert.exito = false;
	    	camposnaopreenchidos += "Nome, ";
	    	
	    }
	    if(senha.isEmpty())
	    {
	    	retornoinsert.qtderro++;
	    	retornoinsert.exito = false;
	    	camposnaopreenchidos += "Senha, ";
	    	
	    }
	    if(!confirmarsenha.isEmpty() && !senha.isEmpty() )
	    {    	
	    	if(senha != confirmarsenha  )
	    	{
	    		retornoinsert.qtderro++;
		    	retornoinsert.exito = false;
	    		retornoinsert.mensagem = "A senhas não se conferem, por favor tente outra senha.";
	    	}
	    	else if( senha.length() < 5 )
	    	{
	    		retornoinsert.qtderro++;
		    	retornoinsert.exito = false;
	    		retornoinsert.mensagem = "Sua senha precisa ser maior que 5 caracteres;";
	    	}
	    
	    }
	    else
	    {
	    	retornoinsert.qtderro++;
	    	retornoinsert.exito = false;

	    	camposnaopreenchidos += "Confirmar senha, ";
	    }
	    if(CPFCadastrado(cpf))
	    {
	    	retornoinsert.exito = false;
	    	retornoinsert.mensagem = "Este CPF já esta cadastrado em nosso sistema";
	    }
	    
	    if(retornoinsert.exito == false)
	    {
	    	if(camposnaopreenchidos.length() > 0)
	    	{
	    		retornoinsert.mensagem = "Os seguintes campo(s) não foram preencidos: " + camposnaopreenchidos + "não foi possivel gerar o cadastro.";	    		
	    	}
	  
	    	return retornoinsert;
	    }
	    else
	    {
	    	Usuario usuario = new Usuario();

	    	usuario.setCpf(cpf); 
	    	usuario.setNome(nome); 
	    	usuario.setSenha(senha); 
	    	
	    	retornoinsert.mensagem = "Usuario " + usuario.getNome() + " cadastrado com sucesso !";
	    	try
	    	{
	    		inserir(usuario);	    		
	    	}
	    	catch(Exception e)
	    	{
	    		retornoinsert.mensagem = "Erro no banco de dados, strackTrace " + e.getStackTrace();
	    	} 
	    	
	    	
	   }
	    
	    return retornoinsert;
	}
	
	public boolean CPFCadastrado(String cpf)
	{
		
		String sql = "select * from usuario where cpf = " + cpf + ";";
		PreparedStatement preparedStatement;
		try {
			
			preparedStatement = banco.getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			
			if(resultSet.next())
			{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return false;
	}

	public boolean inserir(Usuario usuario) {
		
		// Index dos parametros no DB
		// CPF = 1; NOME = 2; SENHA = 3;
		
		String sql = "insert into usuario values (?, ?, ?);";
		PreparedStatement preparedStatement;

		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
    
			preparedStatement.setString(1,usuario.getCpf());
			preparedStatement.setString(2, usuario.getNome());
			preparedStatement.setString(3, usuario.getSenha());
    
			preparedStatement.execute();
			return true;
    	
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}
		
	}
	
	public void remover(Usuario usuario) {
		
		String sql = "delete from usuario where cpf = ?;";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, usuario.getCpf());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void atualizar(Usuario usuario) {
		
      
      String sql = "update usuario set nome = ?, senha = ? where cpf = ?";

      
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3,usuario.getCpf());

			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

    public ArrayList<Usuario> listar() {
    	
		// Index dos parametros no DB
		// CPF = 1; NOME = 2; SENHA = 3;
    	
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "select * from usuario;";
		
		try {
			Statement statement = banco.getConnection().createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				Usuario usuario = new Usuario();
					
				usuario.setCpf(resultSet.getString(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setSenha(resultSet.getString(3));

				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
}
