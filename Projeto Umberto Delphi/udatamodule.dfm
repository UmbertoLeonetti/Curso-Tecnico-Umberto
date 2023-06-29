object DataModule1: TDataModule1
  OldCreateOrder = False
  Left = 192
  Top = 117
  Height = 334
  Width = 478
  object tbCadastro1: TTable
    Left = 128
    Top = 40
    object tbCadastro1bdCodigo: TIntegerField
      FieldName = 'bdCodigo'
    end
    object tbCadastro1bdNome: TStringField
      FieldName = 'bdNome'
      Size = 150
    end
    object tbCadastro1bdCor: TIntegerField
      FieldName = 'bdCor'
    end
  end
  object dsCadastro1: TDataSource
    DataSet = tbCadastro1
    Left = 200
    Top = 40
  end
  object dsClientData2: TDataSource
    DataSet = cdsCadastro2
    Left = 208
    Top = 128
  end
  object cdsCadastro2: TClientDataSet
    Aggregates = <>
    Params = <>
    Left = 128
    Top = 128
    object cdsCadastro2bdNome: TStringField
      FieldName = 'bdNome'
      Size = 150
    end
    object cdsCadastro2bdCodigo: TIntegerField
      FieldName = 'bdCodigo'
    end
    object cdsCadastro2bdEstampa: TBooleanField
      FieldName = 'bdEstampa'
    end
    object cdsCadastro2bdTamanho: TIntegerField
      FieldName = 'bdTamanho'
    end
  end
end
