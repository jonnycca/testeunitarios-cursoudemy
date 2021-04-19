package br.com.servicos;

import static br.com.utils.DataUtils.adicionarDias;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import br.com.entidades.Filme;
import br.com.entidades.Locacao;
import br.com.entidades.Usuario;
import br.com.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar metodo para salvar
		
		return locacao;
	}

	@Test
	public void teste() {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario1");
		Filme filme = new Filme("Filme1", 3, 5.0);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//validacao
		assertTrue(locacao.getValor() == 5.0);
		assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}