package application;

import ControlesTelas.ControleAlterarItem;
import ControlesTelas.ControleEstoque;
import ControlesTelas.ControleMovimentacaoItem;
import JDBC.Item;
import JDBC.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMovimentacaoItem extends Application {
	
	public MainMovimentacaoItem(Item item1, Usuario usuario1) {
		ControleMovimentacaoItem.setItem2(item1);
		ControleMovimentacaoItem.setUsuario(usuario1);
	}
	
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/MovimentacaoItemTela.fxml"));
		Parent telaInformacoesItem = root.load();
			
		Scene telaInformacoesItemLayout = new Scene(telaInformacoesItem);	
		telaInformacoesItemLayout.getStylesheets().add(getClass().getResource("/ArquivosCSS/applicationMovimentacaoItem.css").toExternalForm());	
		stage.setScene(telaInformacoesItemLayout);	
		stage.setTitle("Movimentação do Item");
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
		setStage(stage);
			 
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MainMovimentacaoItem.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
