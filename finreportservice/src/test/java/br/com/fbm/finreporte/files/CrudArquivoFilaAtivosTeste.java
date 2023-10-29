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
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fbm.finreporte.repository.files.FileManager;
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
	public void testesArquivoFilaAtivos() throws Exception {
		
		Assert.assertTrue("Inserindo Linhas Arquivo Fila Ativos", inserirLinhaArquivoFilaAtivo());
		Assert.assertTrue("Alterando Linhas Arquivo Fila Ativos", atualizarLinhaArquivoFilaAtivo());
		Assert.assertTrue("Deltando Linhas Arquivo Fila Ativos", deletarLinhaArquivoFilaAtivo());
		
	}
	
	private boolean inserirLinhaArquivoFilaAtivo() throws Exception {
	
		final Path path = Paths.get( pathArquivoFilaAtivos.toString() );
		
		FileManager.inserir("knri11", pathArquivoFilaAtivos.toString());
		FileManager.inserir("hsml11", pathArquivoFilaAtivos.toString());
		FileManager.inserir("xplg11", pathArquivoFilaAtivos.toString());
		
		final boolean hasLinhas = !Files.readAllLines(path).isEmpty();
	
		return hasLinhas;
		
	}
	
	private boolean atualizarLinhaArquivoFilaAtivo() throws Exception {
		
		final String ativo = "2;tgar11";
		final Path path = Paths.get( pathArquivoFilaAtivos.toString() );
		
		FileManager.alterarLinha(ativo, pathArquivoFilaAtivos.toString());
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeAtivoEncontrado = at -> at
				.toLowerCase()
				.equals( ativo.toLowerCase() );
		
		final Optional<String> existeAtivo = linhas
				.stream()
				.filter(testeAtivoEncontrado)
				.findFirst();
		
		return existeAtivo.isPresent();
		
	}
	
	private boolean deletarLinhaArquivoFilaAtivo() throws Exception {
		
		final String ativo = "1;knri11";
		
		final Path path = Paths.get( pathArquivoFilaAtivos.toString() );
		
		FileManager.deletarLinha(ativo, pathArquivoFilaAtivos.toString());
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeAtivoEncontrado = at -> at
				.toLowerCase()
				.equals( ativo.toLowerCase() );
		
		final Optional<String> existeAtivo = linhas
				.stream()
				.filter(testeAtivoEncontrado)
				.findFirst();
		
		return !existeAtivo.isPresent();
		
	}
	
	
}
