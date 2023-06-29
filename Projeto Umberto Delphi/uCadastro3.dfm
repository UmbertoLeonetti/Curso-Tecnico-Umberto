inherited frCadastro3: TfrCadastro3
  Width = 592
  Height = 490
  Caption = 'frCadastro3'
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  inherited lbCodigo: TLabel
    Top = 32
  end
  inherited lbNome: TLabel
    Top = 88
  end
  object lbMarca: TLabel [2]
    Left = 64
    Top = 152
    Width = 33
    Height = 13
    Caption = 'Marca:'
  end
  object lbModelo: TLabel [3]
    Left = 64
    Top = 208
    Width = 35
    Height = 13
    Caption = 'Modelo'
  end
  inherited edCodigo: TEdit
    Top = 32
  end
  inherited btAdicionar: TButton
    Left = 64
    Top = 328
    Caption = 'Salvar'
    OnClick = btAdicionarClick
  end
  inherited edNome: TEdit
    Top = 88
  end
  inherited btConsulta: TButton
    Left = 184
    Top = 320
    OnClick = btConsultaClick
  end
  object cbMarca: TComboBox
    Left = 112
    Top = 152
    Width = 145
    Height = 21
    ItemHeight = 13
    TabOrder = 4
    Items.Strings = (
      'Lacoste'
      'Adidas'
      'Nike')
  end
  object ckLoja: TCheckBox
    Left = 128
    Top = 264
    Width = 97
    Height = 17
    Caption = 'Gostou da Loja'
    TabOrder = 5
  end
  object cbModelo: TComboBox
    Left = 112
    Top = 200
    Width = 145
    Height = 21
    ItemHeight = 13
    TabOrder = 6
    Items.Strings = (
      'Manga Curta'
      'Manga Longa'
      'Regata')
  end
end
