package com.devmatheus.bddwithcucumber.servicos;

import java.util.Calendar;

import com.devmatheus.bddwithcucumber.entidades.Filme;
import com.devmatheus.bddwithcucumber.entidades.NotaAluguel;
import com.devmatheus.bddwithcucumber.entidades.TipoAluguel;
import com.devmatheus.bddwithcucumber.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Filme sem estoque");

		NotaAluguel nota = new NotaAluguel();
		
		switch (tipoAluguel) {
			case COMUM:
				nota.setPreco(filme.getAluguel());
				nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
				nota.setPontuacao(1);
				break;
			case EXTENDIDO:
				nota.setPreco(2 * filme.getAluguel());
				nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
				nota.setPontuacao(2);
				break;
			case SEMANAL:
				nota.setPreco(3 * filme.getAluguel());
				nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
				nota.setPontuacao(3);
		}
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}
}