unit uCadastro1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, uCadastroPadrao, StdCtrls, udatamodule, uClasses, uConsulta1;

type
  TfrCadastro1 = class(TfrCadastroPadrao)
    cbCor: TComboBox;
    lbCor: TLabel;
    procedure btAdicionarClick(Sender: TObject);
    procedure edCodigoExit(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public

    { Public declarations }
  end;

var
  frCadastro1: TfrCadastro1;

implementation

{$R *.dfm}


procedure TfrCadastro1.btAdicionarClick(Sender: TObject);
var
  wPessoa: TCor;
begin
  inherited;
    wPessoa := TCor.Create;

    wPessoa.wCodigo := StrToInt(edCodigo.Text);
    wPessoa.wNome := edNome.Text;
    wPessoa.wCor := cbCor.ItemIndex;

    DataModule1.tbCadastro1.IndexFieldNames := 'bdCodigo';
    if DataModule1.tbCadastro1.FindKey([edCodigo.Text]) then
       DataModule1.tbCadastro1.Edit
    else
       begin
        DataModule1.tbCadastro1.Insert;
        DataModule1.tbCadastro1bdCodigo.AsInteger := wPessoa.wCodigo;
        DataModule1.tbCadastro1bdNome.AsString := wPessoa.wNome;
        DataModule1.tbCadastro1bdCor.AsInteger := wPessoa.wCor;

        DataModule1.tbCadastro1.Post;
        edCodigo.SetFocus;
       end;
end;

procedure TfrCadastro1.edCodigoExit(Sender: TObject);
begin
  inherited;
    DataModule1.tbCadastro1.IndexFieldNames := 'bdCodigo';
    if DataModule1.tbCadastro1.FindKey([edCodigo.Text]) then
       begin
        edCodigo.Text := DataModule1.tbCadastro1bdCodigo.AsString;
        edNome.Text := DataModule1.tbCadastro1bdNome.AsString;
        cbCor.ItemIndex := DataModule1.tbCadastro1bdCor.AsInteger;
       end
    else
       begin;
        edNome.Text := '';
        cbCor.ItemIndex := -1;
       end;
end;
procedure TfrCadastro1.FormCreate(Sender: TObject);
begin
  inherited;
    DataModule1.pCriaTabelaCliente;
end;

end.
