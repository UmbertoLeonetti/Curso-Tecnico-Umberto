package ControlesTelas;

import java.awt.Component;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import JDBC.Item;
import JDBC.ItemDAO;
import JDBC.ItemDAOJDBC;
import JDBC.JDBCUtil;
import JDBC.Usuario;
import JDBC.UsuarioDAO;
import JDBC.UsuarioDAOJDBC;
import Relatorios.RelatorioEstoque;
import application.MainAlterarItem;
import application.MainCadastroUser;
import application.MainEstoque;
import application.MainHistoricoMovimentacao;
import application.MainInformacoesItem;
import application.MainMovimentacaoItem;
import application.MainVisualizarFoto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Colunas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

	public class ControleEstoque implements Initializable {

		 	private static final EventHandler<? super MouseEvent> MouseEvent = null;

			@FXML
		    private Button btnCadastroItem;

		    @FXML
		    private Label lblColuna;

		    @FXML
		    private ImageView imgBuscar;

		    @FXML
		    private Label lblBuscar;

		    @FXML
		    private TextField txtBuscar;

		    @FXML
		    private ComboBox<Colunas> cbColuna;

		    @FXML
		    private Button btnExportar;

		    @FXML
		    private ImageView imgExportar;

		    @FXML
		    private Button btnImprimir;

		    @FXML
		    private ImageView imgImprimir;

		    @FXML
		    private TableView<Item> tbviewEstoque;

		    @FXML
		    private TableColumn<Item, Integer> tColumnCod;

		    @FXML
		    private TableColumn<Item, String> tColumnData;

		    @FXML
		    private TableColumn<Item, String> tColumnDescricao;

		    @FXML
		    private TableColumn<Item, String> tColumnMarca;

		    @FXML
		    private TableColumn<Item, String> tColumnRef;

		    @FXML
		    private TableColumn<Item, Integer> tColumnQuantidade;

		    @FXML
		    private TableColumn<Item, String> tColumnLocal;

		    @FXML
		    private TableColumn<Item, String> tColumnEstado;

		    @FXML
		    private TableColumn<Item, String> tColumnFornecedor;
		    
		    @FXML
		    private TableColumn<Item, Integer> tColumnEstMin;

		    @FXML
		    private TableColumn<Item, Integer> tColumnEstMax;

		    @FXML
		    private Label lblDataFInal;

		    @FXML
		    private DatePicker dpDataInicial;

		    @FXML
		    private DatePicker dpDataFinal;

		    @FXML
		    private Label lblDataInicial;

		    @FXML
		    private ImageView imgCadastroItem;

		    @FXML
		    private Label lblUsuarioLogado;

		    @FXML
		    private ImageView imgUsuarioLogado;

		    @FXML
		    private Circle circleNotificacao;

		    @FXML
		    private ImageView imgNotificacao;
		    
		    @FXML
		    private Button btnEditar;

		    @FXML
		    private ImageView imgEditarItem;

		    @FXML
		    private Button btnEditarEstoque;

		    @FXML
		    private Button btnAtualizaEstoque;
		    
		    @FXML
		    private ImageView imgEditarEstoque;
		    
		    @FXML
		    private ImageView imgBuscarData;
		    
		    private String caminhoFoto;
		    
		    @FXML
		    private ImageView imgAtualizarEstoque;

		    @FXML
		    private Button btnHistMovimentacao;

		    @FXML
		    private ImageView imgHistMovimentacao;
		    
		    private static Usuario usuario;
		    
		    
		    public static Usuario getusuario() {
		    	return usuario;
				
			}
		    
		    public static void setUsuario(Usuario usuario1) {
		    	ControleEstoque.usuario = usuario1;
			}
		    
		    private final JDBCUtil database = new JDBCUtil();
		    private final Connection connection = database.getConnection();
		    private final ItemDAO itemdao = new ItemDAOJDBC();
		    @FXML
		    void onClickHistMovimentacao(ActionEvent event) {
		    	/*URL url1 = getClass().getResource("/Relatorios/RelatorioHistoricoMovimentacao.jasper");
		    	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url1);
		    	Map logo = new HashMap();
				logo.put("K3_logo", "C:/Users/Usuario/eclipse-workspace/ProjetoIntegrador/src/Imagens/K3_logo.png");
		    	
		    	JasperPrint jasperPrint = null;
				try {
					jasperPrint = JasperFillManager.fillReport(jasperReport, logo, connection);
				} catch (JRException e) {
					e.printStackTrace();
				}
		    	
		    	JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
		    	jasperViewer.setVisible(true);
		    	jasperViewer.toFront();*/
		    	
		    	Item itemSelecionado = tbviewEstoque.getSelectionModel().getSelectedItem();
		    	if(itemSelecionado!= null) {
		    		MainHistoricoMovimentacao m= new MainHistoricoMovimentacao(itemSelecionado);
					try {
						m.start(new Stage());
					}catch (Exception e1) {
						e1.printStackTrace();
					}
		    	}else {
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Selecione um item.");
					alert.show();
		    	}
		    	  	  	
		    }
		    
		    @FXML
		    public void onClickImprimir(ActionEvent arg0) throws JRException{
		    	URL url = getClass().getResource("/Relatorios/RelatorioEstoque.jasper");
		    	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);
		    	Map logo = new HashMap();
				logo.put("K3_logo", "C:/Users/Usuario/eclipse-workspace/ProjetoIntegrador/src/Imagens/K3_logo.png");
		    	
		    	JasperPrint jasperPrint = null;
				try {
					jasperPrint = JasperFillManager.fillReport(jasperReport, logo, connection);
				} catch (JRException e) {
					e.printStackTrace();
				}
		    	
		    	JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
		    	jasperViewer.setVisible(true);
		    	jasperViewer.toFront();
		    	
		    }

		    @FXML
		    void onClickEditarEstoque(ActionEvent event) {
		    	Item itemSelecionado = tbviewEstoque.getSelectionModel().getSelectedItem();
		    	if(itemSelecionado!= null) {
		    		MainMovimentacaoItem m= new MainMovimentacaoItem(itemSelecionado, usuario);
					try {
						m.start(new Stage());
					}catch (Exception e1) {
						e1.printStackTrace();
					}
		    	}else {
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Selecione um item.");
					alert.show();
		    	}
		    }

		    @FXML
		    public void onClickEditar(ActionEvent event) {
		    	Item itemSelecionado = tbviewEstoque.getSelectionModel().getSelectedItem();
		    	if(itemSelecionado!= null) {
		    		MainAlterarItem m= new MainAlterarItem(itemSelecionado);
					try {
						m.start(new Stage());
					}catch (Exception e1) {
						e1.printStackTrace();
					}
		    	}else {
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Selecione um item.");
					alert.show();
		    	}
		    }
  
		    public boolean onCloseQuery() {
		    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		    	alerta.setTitle("Atenção");
		    	alerta.setHeaderText("Deseja sair do sistema?");
		    	ButtonType btnNao = ButtonType.NO;
		    	ButtonType btnSim = ButtonType.YES;
		    	alerta.getButtonTypes().setAll(btnNao, btnSim);
		    	Optional<ButtonType> opcaoEscolhida = alerta.showAndWait();
		    	
		    	return opcaoEscolhida.get() == btnSim ? true : false;    		
		    }
		    
		    
		  /*  public boolean deletarItem() {
		    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		    	alerta.setTitle("Atenção");
		    	alerta.setHeaderText("Deseja deletar item?");
		    	ButtonType btnNao = ButtonType.NO;
		    	ButtonType btnSim = ButtonType.YES;
		    	alerta.getButtonTypes().setAll(btnNao, btnSim);
		    	Optional<ButtonType> opcaoEscolhida = alerta.showAndWait();
		    	ItemDAO itemdao = new ItemDAOJDBC();
		    	if(opcaoEscolhida.get() == btnSim) {
		    		itemdao.remover(item); 
		    	}
		    	return 
		    			 ? true : false;
		    }*/
		    

			private List<Colunas> colunas = new ArrayList<>();//lista de colunas
		    
		    @FXML
		    public void onClickbtnCadastrarItem(ActionEvent event) {//para abrir a tela cadastrar item
		    	MainInformacoesItem m= new MainInformacoesItem();
				try {
					m.start(new Stage());
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			};

			@Override
			public void initialize(URL url, ResourceBundle rb) {
				initTable();
				carregarColunas();
				imgBuscar.setOnMouseClicked(MouseEvent ->{
		    		botaoBuscar();
		    	});
				imgBuscarData.setOnMouseClicked(MouseEvent ->{
		    		botaoBuscarData();
		    	});
				 
				lblUsuarioLogado.setText(usuario.getNome());
				
				
				btnAtualizaEstoque.setOnMouseClicked((MouseEvent e)->{
					tbviewEstoque.setItems(listar());
				});
				
				
			}
			
			private void botaoBuscarData() {
				LocalDate dataInicial = dpDataInicial.getValue();
				LocalDate dataFinal = dpDataFinal.getValue();
				//Date dataIni = (Date) Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
				ItemDAOJDBC itemdao = new ItemDAOJDBC(); 
				ArrayList<Item> itens = itemdao.buscarData("" + dataInicial, "" + dataFinal);
				for(Item i: itens)
					listar(itens);			
			}
				

			private void botaoBuscar() {
				ItemDAOJDBC itemdao = new ItemDAOJDBC(); 
				Colunas coluna = cbColuna.getSelectionModel().getSelectedItem();
				String colunaPesquisada = coluna.getNome();
				ArrayList<Item> itens = itemdao.buscar(cbColuna.getSelectionModel().getSelectedItem().getNome(), txtBuscar.getText());
				for(Item i: itens)
				listar(itens);			
			}
			
			public void listar(ArrayList<Item> item){
				ItemDAO dao = new ItemDAOJDBC();
				Itens  =  FXCollections . observableArrayList (item);
				tbviewEstoque.setItems(Itens);
				
			}
			
			//Para carregar a tabela Item do banco de dados para o tableView presente na tela
			
			private ObservableList<Item> Itens = FXCollections.observableArrayList();//teste de pesquisa
			
			
			public void initTable() {
				tColumnCod.setCellValueFactory(new PropertyValueFactory("codigo_item"));
				tColumnData.setCellValueFactory(new PropertyValueFactory("data_entrada_item"));
				tColumnDescricao.setCellValueFactory(new PropertyValueFactory("descricao_item"));
				tColumnMarca.setCellValueFactory(new PropertyValueFactory("marca_item"));
				tColumnRef.setCellValueFactory(new PropertyValueFactory("referencia_marca_item"));
				tColumnFornecedor.setCellValueFactory(new PropertyValueFactory("fornecedor_item"));
				tColumnQuantidade.setCellValueFactory(new PropertyValueFactory("quant_atual_item"));
				tColumnEstMin.setCellValueFactory(new PropertyValueFactory("estoque_min_item"));
				tColumnEstMax.setCellValueFactory(new PropertyValueFactory("estoque_max_item"));
				tColumnLocal.setCellValueFactory(new PropertyValueFactory("local_item"));
				tColumnEstado.setCellValueFactory(new PropertyValueFactory("estado_item"));
				tbviewEstoque.setItems(listar());
			}
			
			public ObservableList<Item> listar(){
				ItemDAO dao = new ItemDAOJDBC();
				Itens = FXCollections.observableArrayList(dao.listar());
				return Itens;
			}
			
			//método para carregar colunas no combo box de pesquisa
			
			public ObservableList<Colunas> coluna;
			
			public void carregarColunas() {
				Colunas coluna1 = new Colunas(1, "Código");
				Colunas coluna2 = new Colunas(2, "Estado");
				Colunas coluna3 = new Colunas(3, "Descrição");
				Colunas coluna4 = new Colunas(4, "Marca");
				Colunas coluna5 = new Colunas(5, "Referência");
				Colunas coluna6 = new Colunas(6, "Quantidade");
				Colunas coluna7 = new Colunas(7, "Local");
				Colunas coluna8 = new Colunas(8, "Fornecedor");
				Colunas coluna9 = new Colunas(9, "Est. Mínimo");
				Colunas coluna10 = new Colunas(10, "Est. Máximo");
				
				colunas.add(coluna1);
				colunas.add(coluna2);
				colunas.add(coluna3);
				colunas.add(coluna4);
				colunas.add(coluna5);
				colunas.add(coluna6);
				colunas.add(coluna7);
				colunas.add(coluna8);
				colunas.add(coluna9);
				colunas.add(coluna10);
				
				coluna = FXCollections.observableArrayList(colunas);
				cbColuna.setItems(coluna);
				
			}
	}
			
