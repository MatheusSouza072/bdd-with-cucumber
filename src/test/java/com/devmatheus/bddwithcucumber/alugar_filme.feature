# language: pt
Funcionalidade: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar crit�rios de aceita��o

Cen�rio: Deve executar especifica��o
  Dado que criei o arquivo corretamente
  Quando execut�-lo
  Ent�o a especifica��o deve finalizar com sucesso

Cen�rio: Deve incrementar contador
  Dado que o valor do contador � 15
  Quando eu incrementar em 3
  Ent�o o valor do contador ser� 18
  
Cen�rio: Deve calcular atraso na entrega
	Dado que a entrega � dia 05/07/2020
	Quando a entrega atrasar em 2 dias
	Ent�o a entrega ser� efetuada em 07/07/2020
	
Cen�rio: Deve calcular atraso na entrega da China
	Dado que a entrega � dia 05/07/2020
	Quando a entrega atrasar em 2 meses
	Ent�o a entrega ser� efetuada em 05/09/2020
	
Cen�rio: Deve criar steps gen�ricos para estes passos
    Dado que o ticket � AF345
    E que o valor da passagem � R$ 230,45
    E que o nome do passageiro � "Fulano da Silva"
    E que o telefone do passageiro � 9999-9999
    Quando criar os steps
    Ent�o o teste vai funcionar

Cen�rio: Deve reaproveitar os steps "Dado" do cen�rio anterior
    Dado que o ticket � AB167
    Dado que o ticket especial � AB167
    Dado que o valor da passagem � R$ 1120,23
    Dado que o nome do passageiro � "Cicrano de Oliveira"
    Dado que o telefone do passageiro � 9888-8888

#Cen�rio: Deve negar todos os steps "Dado" dos cen�rios anteriores
    #Dado que o ticket � CD123
    #Dado que o ticket � AG1234
    #Dado que o valor da passagem � R$ 1.1345,56
    #Dado que o nome do passageiro � "Beltrano Souza Matos de Alc�ntara Azevedo"
    #Dado que o telefone do passageiro � 1234-5678
    #Dado que o telefone do passageiro � 999-2223 