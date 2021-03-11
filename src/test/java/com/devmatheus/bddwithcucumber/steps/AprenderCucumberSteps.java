package com.devmatheus.bddwithcucumber.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import com.devmatheus.bddwithcucumber.converters.DateConverter;

import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent„o;
import cucumber.api.java.pt.Quando;


public class AprenderCucumberSteps {
	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
		
	}

	@Quando("^execut·-lo$")
	public void execut·Lo() throws Throwable {
		
	}

	@Ent„o("^a especificaÁ„o deve finalizar com sucesso$")
	public void aEspecificaÁ„oDeveFinalizarComSucesso() throws Throwable {
		
	}
	
	private int contador = 0;
			
	@Dado("^que o valor do contador È (\\d+)$")
	public void queOValorDoContador…(int arg1) {
	    contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) {
	    contador += arg1;
	}

	@Ent„o("^o valor do contador ser· (\\d+)$")
	public void oValorDoContadorSer·(int arg1) {
	    Assert.assertEquals(arg1, contador);
	}
	
	private Date entrega = new Date();
	
	@Dado("^que a entrega È dia (.*)$")
	public void queAEntrega…Dia(@Transform(DateConverter.class) Date data) {
	    entrega = data;
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if(tempo.equals("dias")) {
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    else if(tempo.equals("meses")) {
	    	cal.add(Calendar.MONTH, arg1);
	    }
	    entrega = cal.getTime();

	}

	@Ent„o("^a entrega ser· efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSer·EfetuadaEm(@Transform(DateConverter.class) Date data) {
		Assert.assertEquals(entrega, data);
	}
	
	@Dado("^que o ticket( especial)? È (A[A-F]{1}\\d{3})$")
	public void queOTicket…AF(String tipo, String arg1) throws Throwable {

	}

	@Dado("^que o valor da passagem È R\\$ (.*)$")
	public void queOValorDaPassagem…R$(Double numero) throws Throwable {
		//Double possui um construtor que aceita string
	}

	@Dado("^que o nome do passageiro È \"(.{5,20})\"$")
	public void queONomeDoPassageiro…(String arg1) throws Throwable {

	}

	@Dado("^que o telefone do passageiro È (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiro…(String telefone) throws Throwable {

	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {

	}

	@Ent„o("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
		
	}
}