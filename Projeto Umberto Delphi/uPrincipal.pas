unit uPrincipal;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, uCadastro1, uCadastro2, uCadastro3;

type
  TfrPrincipal = class(TForm)
    btAbrirCadastro1: TButton;
    btAbrirCadastro2: TButton;
    btAbrirCadastro3: TButton;
    procedure btAbrirCadastro1Click(Sender: TObject);
    procedure btAbrirCadastro2Click(Sender: TObject);
    procedure btAbrirCadastro3Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frPrincipal: TfrPrincipal;

implementation

{$R *.dfm}

procedure TfrPrincipal.btAbrirCadastro1Click(Sender: TObject);
var
  wTela : TfrCadastro1;
begin
  wTela := TfrCadastro1.Create(Self);
  wTela.Show;
end;

procedure TfrPrincipal.btAbrirCadastro2Click(Sender: TObject);
var
  wTela : TfrCadastro2;
begin
  wTela := TfrCadastro2.Create(Self);
  wTela.Show;
end;

procedure TfrPrincipal.btAbrirCadastro3Click(Sender: TObject);
var
  wTela : TfrCadastro3;
begin
  wTela := TfrCadastro3.Create(Self);
  wTela.Show;
end;

end.
