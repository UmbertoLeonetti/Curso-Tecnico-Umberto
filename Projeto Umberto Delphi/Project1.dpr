program Project1;

uses
  Forms,
  uPrincipal in 'uPrincipal.pas' {frPrincipal},
  uClasses in 'uClasses.pas',
  udatamodule in 'udatamodule.pas' {DataModule1: TDataModule},
  uCadastroPadrao in 'uCadastroPadrao.pas' {frCadastroPadrao},
  uConsultaPadrao in 'uConsultaPadrao.pas' {frPadraoConsulta},
  uCadastro1 in 'uCadastro1.pas' {frCadastro1},
  uCadastro2 in 'uCadastro2.pas' {frCadastro2},
  Consulta2 in '..\10-03-2022\Projeto1\Consulta2.pas' {frConsulta2},
  uCadastro3 in 'uCadastro3.pas' {frCadastro3},
  uConsulta1 in 'uConsulta1.pas' {frConsulta1};

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(TfrPrincipal, frPrincipal);
  Application.CreateForm(TDataModule1, DataModule1);
  Application.CreateForm(TfrConsulta2, frConsulta2);
  Application.CreateForm(TfrCadastro3, frCadastro3);
  Application.CreateForm(TfrConsulta1, frConsulta1);
  Application.Run;
end.
