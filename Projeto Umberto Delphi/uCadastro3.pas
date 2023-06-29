unit uCadastro3;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, uCadastroPadrao, StdCtrls, uClasses;

type
  TfrCadastro3 = class(TfrCadastroPadrao)
    cbMarca: TComboBox;
    lbMarca: TLabel;
    ckLoja: TCheckBox;
    cbModelo: TComboBox;
    lbModelo: TLabel;
    procedure FormCreate(Sender: TObject);
    procedure btAdicionarClick(Sender: TObject);
    procedure btConsultaClick(Sender: TObject);
  private
   wStringList: TStringList;

   procedure pMensagem;
   function fDiretorio: String;
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frCadastro3: TfrCadastro3;

implementation

{$R *.dfm}

{ TfrCadastroPadrao1 }

function TfrCadastro3.fDiretorio: String;
begin
    Result := 'C:\Program Files (x86)\Borland\Delphi7\Projects\curso\Projeto Umberto\StringList';
end;

procedure TfrCadastro3.pMensagem;
var
  wLoja, wMarca, wModelo: String;
  //wItem: TMarca;
begin
  inherited;

    if ckLoja.Checked then
       wLoja := 'Sim'
    else
       wLoja := 'Não';

    wMarca := '';
      if cbMarca.ItemIndex = 0 then
         wMarca := 'Lacoste'
      else
         if cbMarca.ItemIndex = 1 then
            wMarca := 'Adidas'
      else
          if cbMarca.ItemIndex = 2 then
             wMarca := 'Nike';

    wModelo := '';
      if cbModelo.ItemIndex = 0 then
         wModelo := 'Manga Curta'
      else
        if cbModelo.ItemIndex = 1 then
           wModelo := 'Manga Longa'
      else
        if cbModelo.ItemIndex = 2 then
           wModelo := 'Regata';

   wStringList.Add ('Codigo: ' + edCodigo.Text + ' | Nome: ' + edNome.Text + ' | Marca: ' + wMarca + ' | Modelo: ' + wModelo + ' | Gosotu da Loja: ' + wLoja);
end;

procedure TfrCadastro3.FormCreate(Sender: TObject);
begin
  inherited;
    wStringList := TstringList.Create;
      if FileExists (fDiretorio) then
         wStringList.LoadFromFile(fDiretorio)
end;

procedure TfrCadastro3.btAdicionarClick(Sender: TObject);
begin
  inherited;
    pmensagem;
end;

procedure TfrCadastro3.btConsultaClick(Sender: TObject);
var
  contador: integer;
  Texto: String;
begin
  inherited;
    for contador := 0 to wStringList.Count-1 do
      Texto := Texto + #13 + wStringList [contador];

    showmessage(Texto);

  if not DirectoryExists(fDiretorio) then
  ForceDirectories(fDiretorio);
  wStringList.SaveToFile(fDiretorio);

end;

end.
