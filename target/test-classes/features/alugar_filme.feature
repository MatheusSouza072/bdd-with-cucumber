# language: pt  
@unit�rios
Funcionalidade: Alugar Filme
	Como um usu�rio
	Eu quero cadastrar alugu�is de filmes 
	Para controlar pre�os e datas de entrega
	

Cen�rio: Deve alugar um filme com sucesso
 #Sem DataTable	
	#Dado um filme com estoque de 2 unidades
	#E que o pre�o de aluguel seja R$ 3
		
	Dado um filme     
	 | estoque | 2		 |
	 | preco   | 3 		 |
	 | tipo    | comum |
	
	Quando alugar
	Ent�o o pre�o do aluguel ser� R$ 3
	E a data de entrega ser� em 1 dia
	E o estoque do filme ser� 1 unidade

	
Cen�rio: N�o deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar
	Ent�o n�o ser� poss�vel por falta de estoque
	E o estoque do filme ser� 0 unidade
	
#Scenario Outline	
Esquema do Cen�rio: Deve dar condi��es conforme tipo de aluguel
	Dado um filme com estoque de 2 unidades
	E que o pre�o de aluguel seja R$ <preco>
	E que o pre�o de aluguel seja R$ <preco>
	E que o tipo de aluguel seja <tipo> 
	Quando alugar
	Ent�o o pre�o do aluguel ser� R$ <valor>
	E a data de entrega ser� em <qtdDias> dias
	E a pontua��o ser� de <pontuacao> pontos
	
#Examples
Exemplos:	
	|  preco  |  tipo       |  valor  | qtdDias  |  pontuacao  |
	|    4    |  extendido  |    8		|    3     |     2       |
	|    4    |  comum      |    4		|    1     |     1       |
	|    10   |  extendido  |   20		|    3     |     2       |
	|    5    |  semanal		|   15		|    7     |     3       |

# Cen�rio antes de criar o Esquema do Cen�rio
#Cen�rio: Deve dar condi��es especiais para categoria extendida 
	#Dado um filme com estoque de 2 unidades
	#E que o pre�o de aluguel seja R$ 4
	#E que o tipo de aluguel seja extendido 
	#Quando alugar
	#Ent�o o pre�o do aluguel ser� R$ 8
	#E a data de entrega ser� em 3 dias
	#E a pontua��o ser� de 2 pontos
	

#Cen�rio: Deve alugar para categoria comum
	#Dado um filme com estoque de 2 unidades
	#E que o pre�o de aluguel seja R$ 4
	#E que o tipo de aluguel seja comum 
	#Quando alugar
	#Ent�o o pre�o do aluguel ser� R$ 4
	#E a data de entrega ser� em 1 dia
	#E a pontua��o ser� de 1 pontos