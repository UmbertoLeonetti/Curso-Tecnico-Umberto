package ControlesTelas;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import JDBC.Item;
import JDBC.ItemDAO;
import JDBC.ItemDAOJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControleInformacoesItem implements Initializable{

	 	@FXML
	    private Label lblDescricao;

	    @FXML
	    private TextField txtDescricao;

	    @FXML
	    private Label lblFornecedor;

	    @FXML
	    private TextField txtFornecedor;

	    @FXML
	    private Label lblMarca;

	    @FXML
	    private Label lblQuantAtual;

	    @FXML
	    private TextField txtQuantAtual;

	    @FXML
	    private Label lblEstMin;

	    @FXML
	    private TextField txtEstMin;

	    @FXML
	    private TextField txtMarca;

	    @FXML
	    private Label lblLocal;

	    @FXML
	    private TextField txtLocal;

	    @FXML
	    private Label lblEstMax;

	    @FXML
	    private TextField txtEstMax;

	    @FXML
	    private Label lblReferencia;

	    @FXML
	    private TextField txtReferencia;

	    @FXML
	    private DatePicker dpDataEntrada;

	    @FXML
	    private Label lblDataEntrada;

	    @FXML
	    private Label lblEstadoItem;

	    @FXML
	    private Label lblFoto;

	    @FXML
	    private ComboBox<?> cbFoto;

	    @FXML
	    private RadioButton rbInativo;

	    @FXML
	    private ToggleGroup estado;

	    @FXML
	    private RadioButton rbAtivo;
	    
	    @FXML
	    private ImageView imgFotoItem;
	    
	    @FXML
	    private Button btCadastrar;

	    @FXML
	    private Button btSalvar;
	    
	    
	    private String caminhoFoto;
	    
	@FXML
    void onClickCadastrarItem(ActionEvent event) {
		cadastrarItem();
    }
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {	
    	imgFotoItem.setOnMouseClicked(MouseEvent ->{
    		selecionaFoto();
    	});
    }
    
    public Date asDate(LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	  }
	
    
	public void cadastrarItem() {
		 RadioButton estadoItem = (RadioButton) estado.getSelectedToggle();//para passar a opção escolhida pelo radiobutton
	    	String descricao_item = txtDescricao.getText(), marca_item = txtMarca.getText(),fornecedor_item = txtFornecedor.getText();
	    	String local_item = txtLocal.getText(), referencia_marca_item = txtReferencia.getText(), estado_item = estadoItem.getText(); 
	    	int estoque_min_item = Integer.parseInt(txtEstMin.getText()), estoque_max_item = Integer.parseInt(txtEstMax.getText());
	    	int quant_atual_item = Integer.parseInt(txtQuantAtual.getText());
	    	LocalDate data = dpDataEntrada.getValue();
	    	
	    	Item item = new Item(descricao_item, fornecedor_item, marca_item, quant_atual_item, local_item, estoque_min_item, estoque_max_item, referencia_marca_item, asDate(data), estado_item, caminhoFoto);
	    	ItemDAO itemdao = new ItemDAOJDBC();
	    	if(itemdao.inserir(item)) {
	    		Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Item Cadastrado com sucesso!");
				alert.setContentText("Atualize a tela de estoque para visualizar mudança.");
				alert.show();
				if(item==null) {
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setHeaderText("Não foi possível realizar o cadastro.");
					alert1.setContentText("Verifique se todos os campos estão preenchidos");
					alert1.show();	
				}
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Não foi possível realizar o cadastro.");
				alert.setContentText("Verifique se todos os campos estão preenchidos");
				alert.show();
	    	}
		}
	 public void selecionaFoto() {
		 //abre aba para selecionar foto
		 FileChooser f = new FileChooser();//método do javafx
		 f.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));//filtro para apenas escolher imagens
		 File file = f.showOpenDialog(new Stage());//método para escolher um arquivo
		 if(file!=null) {
		 	imgFotoItem.setImage(new Image("file:///" + file.getAbsolutePath()));
		 	caminhoFoto = file.getAbsolutePath();
		 }

	 }
	 
	
}

