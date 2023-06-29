unit uConsulta1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, uConsultaPadrao, Grids, DBGrids, StdCtrls, udatamodule;

type
  TfrConsulta1 = class(TfrPadraoConsulta)
    btOrdCodigo: TButton;
    brOrdNome: TButton;
    btOrdCor: TButton;
    procedure btOrdCodigoClick(Sender: TObject);
    procedure brOrdNomeClick(Sender: TObject);
    procedure btOrdCorClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frConsulta1: TfrConsulta1;

implementation


{$R *.dfm}

procedure TfrConsulta1.btOrdCodigoClick(Sender: TObject);
begin
  inherited;
     DataModule1.tbCadastro1.IndexFieldNames := 'bdCodigo';
end;

procedure TfrConsulta1.brOrdNomeClick(Sender: TObject);
begin
  inherited;
  DataModule1.tbCadastro1.IndexFieldNames := 'bdNome';
end;

procedure TfrConsulta1.btOrdCorClick(Sender: TObject);
begin
  inherited;
    DataModule1.tbCadastro1.IndexFieldNames := 'bdCor';
end;

end.
