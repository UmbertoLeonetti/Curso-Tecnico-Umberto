package application;

import ControlesTelas.ControleAlterarItem;
import ControlesTelas.ControleInformacoesItem;
import JDBC.Item;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAlterarItem extends Application {
	
	public MainAlterarItem(Item item1) {
		ControleAlterarItem.setItem2(item1);	
	}
	
	private static Stage stage;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/AlterarItemTela.fxml"));
		Parent telaInformacoesItem = root.load();
			
		Scene telaInformacoesItemLayout = new Scene(telaInformacoesItem);	
		telaInformacoesItemLayout.getStylesheets().add(getClass().getResource("/ArquivosCSS/applicationAlterarItem.css").toExternalForm());	
		stage.setScene(telaInformacoesItemLayout);	
		stage.setTitle("Informações do Item");
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
		setStage(stage);
			 
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MainAlterarItem.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
