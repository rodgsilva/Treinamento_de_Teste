package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {
	
	private LocacaoService service;
	
	@Parameter
	public List<Filme> filmes;
	
	@Parameter(value=1)
	public Double valorLocacao;
	
	@Parameter(value=2)
	public String cenario;
	
	@Before
	public void setup(){
		service = new LocacaoService();
	}
	
	private static Filme filme1 = new Filme("filme 1", 2,4.0);
	private static Filme filme2 = new Filme("filme 2", 2,4.0);
	private static Filme filme3 = new Filme("filme 3", 2,4.0);
	private static Filme filme4 = new Filme("filme 4", 2,4.0);
	private static Filme filme5 = new Filme("filme 5", 2,4.0);
	private static Filme filme6 = new Filme("filme 6", 2,4.0);
	private static Filme filme7 = new Filme("filme 7", 2,4.0);
	
	@Parameters(name="{2}")
	public static Collection<Object[]> getParametros(){
		return Arrays.asList(new Object[][] {
			{Arrays.asList(filme1,filme2),8.0, "2 Filmes: Sem Desconto"},
			{Arrays.asList(filme1,filme2,filme3),11.0, "3 Filmes: 25%"},
			{Arrays.asList(filme1,filme2,filme3,filme4),13.0, "4 Filmes: 50%"},
			{Arrays.asList(filme1,filme2,filme3,filme4,filme5),14.0, "5 Filmes: 75%"},
			{Arrays.asList(filme1,filme2,filme3,filme4,filme5,filme6),14.0, "6 Filmes: 100%"},
			{Arrays.asList(filme1,filme2,filme3,filme4,filme5,filme6,filme7),18.0, "7 Filmes: Sem desconto"}
		});
		
	}
	
	@Test
	public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
		
		//cenario		
		Usuario usuario = new Usuario("Usuario 1");
						
		//acao		
		Locacao resultado = service.alugarFilme(usuario, filmes);
				
		//verifica��o
		assertThat(resultado.getValor(), is(valorLocacao));		
		
	}	
	
	public void print() {
		System.out.println(valorLocacao);
	}
	

}
