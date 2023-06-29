inherited frCadastro1: TfrCadastro1
  Caption = 'frCadastro1'
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  inherited lbCodigo: TLabel
    Top = 40
  end
  inherited lbNome: TLabel
    Top = 88
  end
  object lbCor: TLabel [2]
    Left = 64
    Top = 136
    Width = 19
    Height = 13
    Caption = 'Cor:'
  end
  inherited edCodigo: TEdit
    Top = 40
    OnExit = edCodigoExit
  end
  inherited btAdicionar: TButton
    Caption = 'Salvar'
    TabOrder = 3
    OnClick = btAdicionarClick
  end
  inherited edNome: TEdit
    Top = 88
    TabOrder = 1
  end
  inherited btConsulta: TButton
    TabOrder = 4
  end
  object cbCor: TComboBox
    Left = 112
    Top = 128
    Width = 145
    Height = 21
    ItemHeight = 13
    TabOrder = 2
    Items.Strings = (
      'Vermelha'
      'Preta'
      'Branca')
  end
end
