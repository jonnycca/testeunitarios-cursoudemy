package br.com.servicos;

import static br.com.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.com.entidades.Filme;
import br.com.entidades.Locacao;
import br.com.entidades.Usuario;

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

	public static void main(String[] args) {
		
	}
}