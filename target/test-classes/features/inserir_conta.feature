#language: pt
@funcionais
Funcionalidade: Cadastro de contas

Como um usu�rio 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#Background
Contexto:  # Define os passos que s�o sempre executados nos cen�rios
	Dado que estou acessando a aplica��o
	Quando informo o usu�rio "matheus.santana@teste"
	E a senha "teste"
	E seleciono entrar
	Ent�o visualizo a p�gina inicial
	Quando seleciono Contas
	E seleciono Adicionar

Esquema do Cen�rio: Deve validar regras cadastro contas
	Quando informo a conta "<conta>"
	E seleciono salvar
	Ent�o recebo a mensagem "<mensagem>"

Exemplos:
	| 			conta				| 					mensagem								 |
	|  Conta de Teste 	| Conta adicionada com sucesso! 		 |
	|  									| Informe o nome da conta 					 |
	|  Conta mesmo nome | J� existe uma conta com esse nome! |
	


# Cen�rios antes de ter sido modificado para o Esquema do Cen�rio
#Cen�rio: Deve inserir uma conta com sucesso
	#E informo a conta "Conta de Teste"
	#E seleciono salvar
	#Ent�o a conta � inserida com sucesso


#Cen�rio: N�o deve inserir uma conta sem nome
	#E informo a conta ""
	#E seleciono salvar
	#Ent�o sou notificar que o nome da conta � obrigat�rio


#Cen�rio: N�o deve inserir uma conta com nome j� existente
	#E informo a conta "Conta mesmo nome"
	#E seleciono salvar
	#Ent�o sou notificado que j� existe uma conta com esse nome