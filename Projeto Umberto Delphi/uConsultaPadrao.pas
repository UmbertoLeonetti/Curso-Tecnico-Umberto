unit uConsultaPadrao;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Grids, DBGrids, udatamodule;

type
  TfrPadraoConsulta = class(TForm)
    grConsultaPadrao: TDBGrid;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frPadraoConsulta: TfrPadraoConsulta;

implementation

{$R *.dfm}

end.
