package ControlesTelas;


import java.net.URL;
import java.util.ResourceBundle;

import JDBC.Usuario;
import JDBC.UsuarioDAOJDBC;
import application.MainCadastroUser;
import application.MainLogin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleCadastroUser implements Initializable{
	
	@FXML private Label lblCadastroUser;
	@FXML private Label lblNomeUser;
	@FXML private Label lblCpfUser;
	@FXML private Label lblSenhaUser;
	@FXML private Label lblConfirmeSenhaUser;
	@FXML private TextField txtNomeUser;
	@FXML private TextField txtCpfUser;
    @FXML private PasswordField pfSenha;
    @FXML private PasswordField pfConfirmacao;
	@FXML private Button btnCadastrar;
	
	@FXML
	public void initialize(URL url, ResourceBundle rb) {
		
		btnCadastrar.setOnMouseClicked(MouseEvent ->{
			cadastrarUsuario();
		});
	}
	
	private void cadastrarUsuario() {
		String 	cpf = txtCpfUser.getText(),
				nome = txtNomeUser.getText(),
				senha = pfSenha.getText(), 
				confirmarsenha = pfConfirmacao.getText();
		
		if(senha.equals(confirmarsenha)) {
			Usuario usuario = new Usuario(cpf, nome, senha);
			
			UsuarioDAOJDBC dao = new UsuarioDAOJDBC();
			
			if (dao.inserir(usuario)) {
	    		Alert al = new Alert(Alert.AlertType.CONFIRMATION);
	    		al.setHeaderText("Usuário Cadastrado");
	    		abreMainLogin();
	    		al.show();
	    		fecha();
	    	} else {
	    		Alert al = new Alert(Alert.AlertType.ERROR);
	    		al.setHeaderText("Usuário Não Cadastrado");
	    		al.show();
	    	}
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("As senhas não coincidem");
			alert.show();
		}
	}
	
	public void abreMainLogin() {
		MainLogin a = new MainLogin();
		fecha();
	}

	public void fecha() {
		MainCadastroUser.getStage().close();
	}
}
