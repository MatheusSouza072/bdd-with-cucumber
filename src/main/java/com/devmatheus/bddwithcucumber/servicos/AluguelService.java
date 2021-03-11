package com.devmatheus.bddwithcucumber.servicos;

import java.util.Calendar;

import com.devmatheus.bddwithcucumber.entidades.Filme;
import com.devmatheus.bddwithcucumber.entidades.NotaAluguel;
import com.devmatheus.bddwithcucumber.utils.DateUtils;

public class AluguelService {
	public NotaAluguel alugar(Filme filme) {
		if (filme.getEstoque() == 0) 
			throw new RuntimeException("Filme sem estoque");
		
		NotaAluguel nota = new NotaAluguel();
		
		nota.setPreco(filme.getAluguel());
		nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
		filme.setEstoque(filme.getEstoque()-1);
		
		return nota;
	}

}