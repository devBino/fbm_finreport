/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

import br.com.fbm.finreporte.repository.files.FileUtils;
import br.com.fbm.finreporte.repository.type.FileApp;

/**
 * Realiza testes de manipulação de linhas em arquivos
 * de fila de ativos.
 * @author Fernando Bino Machado
 */
public class CrudArquivoFilaAtivosTeste {

	private static String pathArquivoFilaAtivos;
	
	@BeforeClass
	public static void definePathFile() {
		
		final StringBuilder basePath = new StringBuilder()
				.append( FileUtils.getHomePath() )
				.append("data/finreport/");
		
		pathArquivoFilaAtivos = new StringBuilder()
				.append(basePath.toString())
				.append(FileApp.FILA_ATIVOS.getFileName())
				.toString();
		
	}
	
	@Test
	public void inserirLinhaArquivoFilaAtivo() throws Exception {
	
		final Path path = Paths.get( pathArquivoFilaAtivos.toString() );
		//TODO BINO chamar rotina de inserção de linha no arquivo
		final boolean hasLinhas = !Files.readAllLines(path).isEmpty();
	
		Assert.assertTrue(hasLinhas);
		
	}
	
	@Test
	public void atualizarLinhaArquivoFilaAtivo() throws Exception {
		
		final String ativo = "2;tgar11";
		final Path path = Paths.get( pathArquivoFilaAtivos.toString() );
		
		//TODO BINO chamar rotina para alterar a linha no arquivo
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeAtivoEncontrado = at -> at
				.toLowerCase()
				.equals( ativo.toLowerCase() );
		
		final Optional<String> existeAtivo = linhas
				.stream()
				.filter(testeAtivoEncontrado)
				.findFirst();
		
		Assert.assertTrue( existeAtivo.isPresent() );
		
	}
	
	@Test
	public void deletarLinhaArquivoFilaAtivo() throws Exception {
		
		final String ativo = "3;bcff11";
		final Path path = Paths.get( pathArquivoFilaAtivos.toString() );
		
		//TODO BINO chamar rotina para deletar linha no arquivo
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeAtivoEncontrado = at -> at
				.toLowerCase()
				.equals( ativo.toLowerCase() );
		
		final Optional<String> existeAtivo = linhas
				.stream()
				.filter(testeAtivoEncontrado)
				.findFirst();
		
		Assert.assertTrue( !existeAtivo.isPresent() );
		
	}
	
	
}
