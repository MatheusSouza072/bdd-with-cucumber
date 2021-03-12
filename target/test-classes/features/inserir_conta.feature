#language: pt
@funcionais
Funcionalidade: Cadastro de contas

Como um usuário 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#Background
Contexto:  # Define os passos que são sempre executados nos cenários
	Dado que estou acessando a aplicação
	Quando informo o usuário "matheus.santana@teste"
	E a senha "teste"
	E seleciono entrar
	Então visualizo a página inicial
	Quando seleciono Contas
	E seleciono Adicionar

Esquema do Cenário: Deve validar regras cadastro contas
	Quando informo a conta "<conta>"
	E seleciono salvar
	Então recebo a mensagem "<mensagem>"

Exemplos:
	| 			conta				| 					mensagem								 |
	|  Conta de Teste 	| Conta adicionada com sucesso! 		 |
	|  									| Informe o nome da conta 					 |
	|  Conta mesmo nome | Já existe uma conta com esse nome! |
	


# Cenários antes de ter sido modificado para o Esquema do Cenário
#Cenário: Deve inserir uma conta com sucesso
	#E informo a conta "Conta de Teste"
	#E seleciono salvar
	#Então a conta é inserida com sucesso


#Cenário: Não deve inserir uma conta sem nome
	#E informo a conta ""
	#E seleciono salvar
	#Então sou notificar que o nome da conta é obrigatório


#Cenário: Não deve inserir uma conta com nome já existente
	#E informo a conta "Conta mesmo nome"
	#E seleciono salvar
	#Então sou notificado que já existe uma conta com esse nome