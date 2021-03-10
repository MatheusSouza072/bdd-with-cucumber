package com.devmatheus.bddwithcucumber;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Ent„o;
import io.cucumber.java.pt.Quando;
public class AprenderCucumber {
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
	
	@Dado("^que a entrega È dia (\\d+)/(\\d+)/(\\d+)$")
	public void queAEntrega…Dia(int dia, int mes, int ano) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH, dia);
	    cal.set(Calendar.MONTH, mes-1);
	    cal.set(Calendar.YEAR, ano);
	    entrega = cal.getTime();
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
	public void aEntregaSer·EfetuadaEm(String data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}
	
	@Dado("^que o ticket( especial)? È (A[A-F]{1}\\d{3})$")
	public void queOTicket…AF(String tipo, String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Dado("^que o valor da passagem È R\\$ (\\d+),(\\d+)$")
	public void queOValorDaPassagem…R$(int arg1, int arg2) throws Throwable {

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