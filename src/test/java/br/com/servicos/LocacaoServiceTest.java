package br.com.servicos;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import br.com.entidades.Filme;
import br.com.entidades.Locacao;
import br.com.entidades.Usuario;
import br.com.utils.DataUtils;

public class LocacaoServiceTest {

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
