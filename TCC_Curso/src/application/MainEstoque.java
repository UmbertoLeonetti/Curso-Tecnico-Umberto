package application;

import ControlesTelas.ControleEstoque;
import ControlesTelas.ControleLogin;
import JDBC.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEstoque extends Application {
	public MainEstoque(Usuario usuario1) {
		ControleEstoque.setUsuario(usuario1);	
	}
	private static Stage stage;
	@Override
	public void start(Stage stage) throws Exception {
		try {
		FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/EstoqueTela.fxml"));
		Parent telaEstoque = root.load();
			
		Scene telaEstoqueLayout = new Scene(telaEstoque);	
		telaEstoqueLayout.getStylesheets().add(getClass().getResource("/ArquivosCSS/applicationEstoque.css").toExternalForm());	
		stage.setScene(telaEstoqueLayout);	
		stage.setTitle("Sistema de Estoque - K3");
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();	
		setStage(stage);
		
		ControleEstoque controleestoque = root.getController();
		stage.setOnCloseRequest(e->{
			 if (controleestoque.onCloseQuery()) {
				 System.exit(0);
			 }else {
				 e.consume();
			 }
		 });
		} catch(Exception e) {
			e.printStackTrace();
		}
			 
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MainEstoque.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

