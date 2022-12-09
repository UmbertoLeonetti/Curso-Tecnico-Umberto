package application;
	
import ControlesTelas.ControleLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainLogin extends Application {
	private static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			//carregando arquivo XML
			FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/LoginTela.fxml")); 
			Parent telaLogin = root.load();
			
			//criando uma cena 
			Scene telaLoginLayout = new Scene(telaLogin);
			telaLoginLayout.getStylesheets().add(getClass().getResource("/ArquivosCSS/applicationLogin.css").toExternalForm());//Estilização CSS
			Stage stage = new Stage();
			//primaryStage.setScene(telaLoginLayout);--abre como primeira tela
			//tela.setMaximized(true);//abre a tela maximizada
			stage.setScene(telaLoginLayout);
			stage.setTitle("Sistema de Estoque - K3");
			//primaryStage.show(); --executa a primeira tela
			stage.resizableProperty().setValue(Boolean.FALSE);//configuração de redimensão da tela(o usuário não pode alterar)
			stage.show();

			
			//carregando o controle da cena(Tela Login)
			 ControleLogin controlelogin = root.getController();
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MainLogin.stage = stage;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
