inherited frCadastro2: TfrCadastro2
  Caption = 'frCadastro2'
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  inherited lbCodigo: TLabel
    Top = 32
  end
  inherited lbNome: TLabel
    Top = 72
  end
  object lbTamanho: TLabel [2]
    Left = 48
    Top = 120
    Width = 45
    Height = 13
    Caption = 'Tamanho'
  end
  inherited edCodigo: TEdit
    Top = 32
    OnEnter = edCodigoEnter
    OnExit = edCodigoExit
  end
  inherited btAdicionar: TButton
    TabOrder = 4
    OnClick = btAdicionarClick
  end
  inherited edNome: TEdit
    Top = 72
    TabOrder = 1
  end
  inherited btConsulta: TButton
    Left = 112
    Top = 272
    Caption = 'Mostrar'
    TabOrder = 6
    OnClick = btConsultaClick
  end
  object cbTamanho: TComboBox
    Left = 112
    Top = 120
    Width = 145
    Height = 21
    ItemHeight = 13
    TabOrder = 2
    Items.Strings = (
      'Tamanho P'
      'Tamanho M'
      'Tamanho G')
  end
  object ckEstampa: TCheckBox
    Left = 112
    Top = 168
    Width = 97
    Height = 17
    Caption = 'Com Estampa'
    TabOrder = 3
  end
  object btSalvar: TButton
    Left = 184
    Top = 224
    Width = 75
    Height = 25
    Caption = 'Salvar'
    TabOrder = 5
  end
  object btExcluir: TButton
    Left = 224
    Top = 272
    Width = 75
    Height = 25
    Caption = 'Excluir'
    TabOrder = 7
    OnClick = btExcluirClick
  end
end
