package com.devmatheus.bddwithcucumber.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import com.devmatheus.bddwithcucumber.entidades.Filme;
import com.devmatheus.bddwithcucumber.entidades.NotaAluguel;
import com.devmatheus.bddwithcucumber.entidades.TipoAluguel;
import com.devmatheus.bddwithcucumber.servicos.AluguelService;
import com.devmatheus.bddwithcucumber.utils.DateUtils;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel;
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
	    filme = new Filme();
	    filme.setEstoque(arg1);
	}

	@Dado("^que o pre�o do aluguel seja R\\$ (\\d+)$")
	public void queOPre�oDoAluguelSejaR$(int arg1) throws Throwable {
		filme.setAluguel(arg1);
	}
	
	@Dado("^um filme$")
	public void umFilme(DataTable table) throws Throwable {
	    Map<String, String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	    String tipo = map.get("tipo");
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;

	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
		
	}

	@Ent�o("^o pre�o do aluguel ser� R\\$ (\\d+)$")
	public void oPre�oDoAluguelSer�R$(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, nota.getPreco());
	}

	@Ent�o("^o estoque do filme ser� (\\d+) unidade$")
	public void oEstoqueDoFilmeSer�Unidade(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, filme.getEstoque());
	}
	
	@Ent�o("^n�o ser� poss�vel por falta de estoque$")
	public void n�oSer�Poss�velPorFaltaDeEstoque() throws Throwable {
	    Assert.assertEquals("Filme sem estoque", erro);
	}
	
	@Dado("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Ent�o("^a data de entrega ser� em (\\d+) dias?$")
	public void aDataDeEntregaSer�EmDias(int arg1) throws Throwable {
		Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
		Date dataReal = nota.getDataEntrega();
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Ent�o("^a pontu��o recebida ser� de (\\d+) pontos$")
	public void aPontu��oRecebidaSer�DePontos(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPontuacao());
	}
}