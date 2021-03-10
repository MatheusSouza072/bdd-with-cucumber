package com.devmatheus.bddwithcucumber;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Ent�o;
import io.cucumber.java.pt.Quando;
public class AprenderCucumber {
	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
		
	}

	@Quando("^execut�-lo$")
	public void execut�Lo() throws Throwable {
		
	}

	@Ent�o("^a especifica��o deve finalizar com sucesso$")
	public void aEspecifica��oDeveFinalizarComSucesso() throws Throwable {
		
	}
	private int contador = 0;
			
	@Dado("^que o valor do contador � (\\d+)$")
	public void queOValorDoContador�(int arg1) throws Throwable {
	    contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
	    contador += arg1;
	}

	@Ent�o("^o valor do contador ser� (\\d+)$")
	public void oValorDoContadorSer�(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, contador);
	}
}
