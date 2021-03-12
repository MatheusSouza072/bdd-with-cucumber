package com.devmatheus.bddwithcucumber.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Ent„o;
import io.cucumber.java.pt.Quando;



public class AprenderCucumberSteps {

	// Essa notaÁ„o que È importante para o Cucumber / o nome do mÈtodo n„o È relevante
	@Dado("^que criei o arquivo corretamente$") 
	public void queCrieiOArquivoCorretamente() throws Throwable {
	   
	}

	@Quando("^execut·-lo$")
	public void execut·Lo() throws Throwable {
	    
	}

	@Ent„o("^a especificaÁ„o deve finalizar com sucesso$")
	public void aEspecificaÁ„oDeveFinalizarComSucesso() throws Throwable {
	    
	}    

	/* Corresponde ao Cen·rio - Contador */
	
	private int contador = 0;
	
	@Dado("^que o valor do contador È (\\d+)$")
	public void queOValorDoContador…(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Ent„o("^o valor do contador ser· (\\d+)$")
	public void oValorDoContadorSer·(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, contador);		
	}
	
	/* Corresponde ao Cen·rio - Atraso no prazo de entrega */
	
	Date entrega = new Date();
	
				//(.*)	-> aceita tudo	
/*	@Dado("^que o prazo È (\\d+)/(\\d+)/(\\d+))$")
	public void queOPrazo…(int dia, int mes, int ano) throws Throwable {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH, dia);
	    cal.set(Calendar.MONTH, mes -1); // No java o mÍs comeÁa de 0, ent„o o mÍs de abril È 3
	    cal.set(Calendar.YEAR, ano);
	    entrega = cal.getTime(); // Passa para a entrega o valor do calend·rio
	} */
	
	@Dado("que a entrega È dia {data}")
	public void que_a_entrega_È_dia(Date data) throws Throwable {
		entrega = data;
		System.out.println(entrega);
	}
	
	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if(tempo.equals("dia")) {	    	
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    if(tempo.equals("dias")) {	    	
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }	
	    if(tempo.equals("mes")) {	    	
	    	cal.add(Calendar.MONTH, arg1);	    	
	    }
	    if(tempo.equals("meses")) {	    	
	    	cal.add(Calendar.MONTH, arg1);	    	
	    }
	    entrega = cal.getTime();
	}

	@Ent„o("^a entrega ser· afetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSer·AfetuadaEm(String data) throws Throwable {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = format.format(entrega);
	    Assert.assertEquals(data, dataFormatada);
	}
	
	/* Corresponde ao Cen·rio - Deve criar steps*/
	
	@Dado("^que o ticket( especial)? È (A.\\d{3})$")  //A[^G](\\d+)$
	public void queOTicket…AF(String tipo, String arg1) throws Throwable {
	    
	}

/*	@Dado("^que o valor da passagem È R\\$ (\\d+),(\\d{2})$")
	public void queOValorDaPassagem…R$(int arg1, int arg2) throws Throwable {
	    
	}*/
	
	@Dado("^que o valor da passagem È R\\$ (.*)$")
	public void queOValorDaPassagem…R$(Double numero) throws Throwable {
	    System.out.println(numero);
	} // Double possui um construtor que aceita 
	
	@Dado("^que o nome do passageiro È \"(.{5,20})\"$") 
	public void queONomeDoPassageiro…(String arg1) throws Throwable {
	    //^que o nome do passageiro È \"(^B.*)\"		
	}

	@Dado("^que o telefone do passageiro È (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiro…(String telefone) throws Throwable { // String devido -
	    
	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	    
	}

	@Ent„o("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	    
	}

}