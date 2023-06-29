unit uCadastro2;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, uCadastroPadrao, StdCtrls, udatamodule, uClasses, Consulta2;

type
  TfrCadastro2 = class(TfrCadastroPadrao)
    cbTamanho: TComboBox;
    lbTamanho: TLabel;
    ckEstampa: TCheckBox;
    btSalvar: TButton;
    btExcluir: TButton;
    procedure FormCreate(Sender: TObject);
    procedure btAdicionarClick(Sender: TObject);
    procedure btConsultaClick(Sender: TObject);
    procedure edCodigoExit(Sender: TObject);
    procedure edCodigoEnter(Sender: TObject);
    procedure btExcluirClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frCadastro2: TfrCadastro2;

implementation

{$R *.dfm}

procedure TfrCadastro2.FormCreate(Sender: TObject);
begin
  inherited;
    DataModule1.pCriaDataSetCliente;
end;

procedure TfrCadastro2.btAdicionarClick(Sender: TObject);
begin
  inherited;
   DataModule1.cdsCadastro2.IndexFieldNames := 'bdCodigo';
   if DataModule1.cdsCadastro2.FindKey([edCodigo.Text]) then
      DataModule1.cdsCadastro2.Edit
   else
      DataModule1.cdsCadastro2.Insert;


   DataModule1.cdsCadastro2bdCodigo.AsInteger := DataModule1.cdsCadastro2.RecordCount + 1;
   DataModule1.cdsCadastro2bdNome.AsString := edNome.Text;
   DataModule1.cdsCadastro2bdTamanho.AsInteger  := cbtamanho.ItemIndex;
   DataModule1.cdsCadastro2bdEstampa.AsBoolean := ckEstampa.Checked;
   DataModule1.cdsCadastro2.Post;
end;

procedure TfrCadastro2.btConsultaClick(Sender: TObject);
var
  wTexto: String;
  wTamanho: String;
  wEstampa: String;
begin
  inherited;
  wTexto := '';
  DataModule1.cdsCadastro2.First;
  while not DataModule1.cdsCadastro2.Eof do
    begin
      if DataModule1.cdsCadastro2bdTamanho.AsInteger = 0 then
         wTamanho := 'Tamanho P'
      else
      if DataModule1.cdsCadastro2bdTamanho.AsInteger = 1 then
         wTamanho := 'Tamanho M'
      else
        wTamanho := 'Tamanho G';

      if not DataModule1.cdsCadastro2bdEstampa.AsBoolean then
             wEstampa := 'Não'
      else
             wEstampa := 'Sim';

             wTexto := wTexto + #13 + 'Codigo: ' + DataModule1.cdsCadastro2bdCodigo.AsString + ' | Nome: ' + DataModule1.cdsCadastro2bdNome.AsString +
                         ' | Sexo : ' + wTamanho + ' | Estrangeiro: ' + wEstampa;

      DataModule1.cdsCadastro2.Next;
end;

  ShowMessage(wTexto);

end;

procedure TfrCadastro2.edCodigoExit(Sender: TObject);
begin
  inherited;
    DataModule1.cdsCadastro2.IndexFieldNames := 'bdCodigo';
      if DataModule1.cdsCadastro2.FindKey([edCodigo.Text]) then
        begin
          edNome.Text := DataModule1.cdsCadastro2bdNome.AsString;
          cbTamanho.ItemIndex := DataModule1.cdsCadastro2bdTamanho.AsInteger;
          ckEstampa.Checked := DataModule1.cdsCadastro2bdEstampa.AsBoolean;
        end
      else
        begin
          edNome.Text := '';
          cbTamanho.ItemIndex := -1;
          ckEstampa.Checked := False;
        end;
end;

procedure TfrCadastro2.edCodigoEnter(Sender: TObject);
begin
  inherited;
     btExcluir.Enabled := False;
end;

procedure TfrCadastro2.btExcluirClick(Sender: TObject);
begin
  inherited;
    DataModule1.cdsCadastro2.IndexFieldNames := 'bdCodigo';
      if DataModule1.cdsCadastro2.FindKey([edCodigo.Text]) then
         DataModule1.cdsCadastro2.Delete;
end;

end.
