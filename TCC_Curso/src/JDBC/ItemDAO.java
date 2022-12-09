package JDBC;

import java.util.ArrayList;
import java.util.Date;

public interface ItemDAO {
	
	public boolean inserir(Item item);
	
	public boolean atualizar(Item item);
	
	public void remover(Item item);
	
	public ArrayList<Item> listar();

	public ArrayList<Item> buscar(String coluna, String buscar);
	
	public ArrayList<Item> buscarData(String dataIni, String dataFim);

	public boolean atualizarQuantidade(Item item);

	public boolean atualizarFoto(Item item);
	
}

