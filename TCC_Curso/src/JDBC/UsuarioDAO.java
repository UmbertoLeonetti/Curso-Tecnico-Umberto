package JDBC;

import java.util.ArrayList;

public interface UsuarioDAO {

		
		public boolean inserir(Usuario usuario);
		
		public void atualizar(Usuario usuario);
		
		public void remover(Usuario usuario);
		
		public ArrayList <Usuario> listar();
			
	}
