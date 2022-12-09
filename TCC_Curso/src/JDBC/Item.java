package JDBC;


import java.util.Date;

import javafx.scene.control.Button;

public class Item {
	
	private String descricao_item;
	private String fornecedor_item;
	private String marca_item;
	private int codigo_item;
	private int quant_atual_item;
	private String local_item;
	private int estoque_min_item;
	private int estoque_max_item;
	private String referencia_marca_item;
	private Date data_entrada_item;
	private String estado_item;
	private String foto_item;
	
	public Item(String descricao_item, String fornecedor_item, String marca_item,
			String local_item, int estoque_min_item, int estoque_max_item, String referencia_marca_item, String estado_item) {
		
		this.descricao_item = descricao_item;
		this.fornecedor_item = fornecedor_item;
		this.marca_item = marca_item;
		this.local_item = local_item;
		this.estoque_min_item = estoque_min_item;
		this.estoque_max_item = estoque_max_item;
		this.referencia_marca_item = referencia_marca_item;
		this.estado_item = estado_item;
	
	}
	
	public Item(String foto_item) {

		this.foto_item = foto_item;
	}
	
	public Item(int quant_atual_item) {
		this.quant_atual_item = quant_atual_item;
	}
	
	public Item(String descricao_item, String fornecedor_item, String marca_item, int quant_atual_item,
			String local_item, int estoque_min_item, int estoque_max_item, String referencia_marca_item,
			Date data_entrada_item, String estado_item, String foto_item) {
		super();
		this.descricao_item = descricao_item;
		this.fornecedor_item = fornecedor_item;
		this.marca_item = marca_item;
		this.quant_atual_item = quant_atual_item;
		this.local_item = local_item;
		this.estoque_min_item = estoque_min_item;
		this.estoque_max_item = estoque_max_item;
		this.referencia_marca_item = referencia_marca_item;
		this.data_entrada_item = data_entrada_item;
		this.estado_item = estado_item;
		this.foto_item = foto_item;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getDescricao_item() {
		return descricao_item;
	}
	public void setDescricao_item(String descricao_item) {
		this.descricao_item = descricao_item;
	}
	public String getFornecedor_item() {
		return fornecedor_item;
	}
	public void setFornecedor_item(String fornecedor_item) {
		this.fornecedor_item = fornecedor_item;
	}
	public String getMarca_item() {
		return marca_item;
	}
	public void setMarca_item(String marca_item) {
		this.marca_item = marca_item;
	}
	public int getCodigo_item() {
		return codigo_item;
	}
	public void setCodigo_item(int codigo_item) {
		this.codigo_item = codigo_item;
	}
	public int getQuant_atual_item() {
		return quant_atual_item;
	}
	public void setQuant_atual_item(int quant_atual_item) {
		this.quant_atual_item = quant_atual_item;
	}
	public String getLocal_item() {
		return local_item;
	}
	public void setLocal_item(String local_item) {
		this.local_item = local_item;
	}
	public int getEstoque_min_item() {
		return estoque_min_item;
	}
	public void setEstoque_min_item(int estoque_min_item) {
		this.estoque_min_item = estoque_min_item;
	}
	public int getEstoque_max_item() {
		return estoque_max_item;
	}
	public void setEstoque_max_item(int estoque_max_item) {
		this.estoque_max_item = estoque_max_item;
	}
	public String getReferencia_marca_item() {
		return referencia_marca_item;
	}
	public void setReferencia_marca_item(String referencia_marca_item) {
		this.referencia_marca_item = referencia_marca_item;
	}
	public Date getData_entrada_item() {
		return data_entrada_item;
	}
	public void setData_entrada_item(Date data_entrada_item) {
		this.data_entrada_item = data_entrada_item;
	}
	public String getEstado_item() {
		return estado_item;
	}
	public void setEstado_item(String estado_item) {
		this.estado_item = estado_item;
	}
	public String getFoto_item() {
		return foto_item;
	}
	public void setFoto_item(String foto_item) {
		this.foto_item = foto_item;
	}
	
	
}


