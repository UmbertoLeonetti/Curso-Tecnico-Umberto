unit udatamodule;

interface

uses
  SysUtils, Classes, DB, DBTables, DBClient;

type
  TDataModule1 = class(TDataModule)
    tbCadastro1: TTable;
    dsCadastro1: TDataSource;
    dsClientData2: TDataSource;
    tbCadastro1bdCodigo: TIntegerField;
    tbCadastro1bdNome: TStringField;
    cdsCadastro2: TClientDataSet;
    tbCadastro1bdCor: TIntegerField;
    cdsCadastro2bdNome: TStringField;
    cdsCadastro2bdCodigo: TIntegerField;
    cdsCadastro2bdEstampa: TBooleanField;
    cdsCadastro2bdTamanho: TIntegerField;
  private
    { Private declarations }
  public
    procedure pCriaTabelaCliente;
    function fDiretorio: String;
    procedure pCriaDataSetCliente;
    { Public declarations }
  end;

var
  DataModule1: TDataModule1;

implementation

{$R *.dfm}

{ TDataModule1 }

function TDataModule1.fDiretorio: String;
begin
  Result := 'C:\Program Files (x86)\Borland\Delphi7\Projects\curso\Projeto Umberto\Tabela';
end;

procedure TDataModule1.pCriaDataSetCliente;
begin
    cdsCadastro2.CreateDataSet;
    cdsCadastro2.Open;
end;

procedure TDataModule1.pCriaTabelaCliente;
begin

  if not DirectoryExists(fDiretorio) then
     ForceDirectories(fDiretorio);

  tbCadastro1.Active := false;
  tbCadastro1.DatabaseName := fDiretorio;
  tbCadastro1.TableName := 'tCadastro1.db';
  tbCadastro1.TableType := ttParadox;

  if not FileExists(tbCadastro1.DatabaseName + '\' + tbCadastro1.TableName) then
  if not tbCadastro1.Exists then
     begin
      tbCadastro1.IndexDefs.Add('iCodigo', 'bdCodigo', [ixPrimary, ixUnique]);
      tbCadastro1.IndexDefs.Add('iNome', 'bdNome', [ixCaseInsensitive]);
      tbCadastro1.IndexDefs.Add('iCor', 'bdCor', [ixCaseInsensitive]);
      tbCadastro1.CreateTable;
     end;

  tbCadastro1.Open;
  tbCadastro1.Active := True;
end;

end.
