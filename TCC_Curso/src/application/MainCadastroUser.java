package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainCadastroUser extends Application {
	
	private static Stage stage;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/CadastroUserTela.fxml"));
		Parent telaCadastroUser = root.load();
			
		Scene telaCadastroUserLayout = new Scene(telaCadastroUser);	
		telaCadastroUserLayout.getStylesheets().add(getClass().getResource("/ArquivosCSS/applicationCadastroUser.css").toExternalForm());	
		stage.setScene(telaCadastroUserLayout);	
		stage.setTitle("Cadastro de Usuários");
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();	
		setStage(stage);
			 
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MainCadastroUser.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

