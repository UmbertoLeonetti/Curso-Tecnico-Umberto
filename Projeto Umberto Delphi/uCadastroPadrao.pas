unit uCadastroPadrao;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TfrCadastroPadrao = class(TForm)
    lbCodigo: TLabel;
    edCodigo: TEdit;
    lbNome: TLabel;
    btAdicionar: TButton;
    edNome: TEdit;
    btConsulta: TButton;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frCadastroPadrao: TfrCadastroPadrao;

implementation

{$R *.dfm}

end.
