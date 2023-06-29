unit uClasses;

interface

type
  Tpessoa = class
    public
      wCodigo: Integer;
      wNome: String;
    end;

type
  TTamanho = class(TPessoa)
    public
      wTamanho: Integer;
      wEstampa: Boolean;
    end;

type
  TCor = class(TPessoa)
   public
    wCor: integer;
   end;
{type
  TMarca = class(Tpessoa)
  public
    wMarca: String;
    wModelo: String;
    ckLoja: String;
    end;}

implementation

end.
