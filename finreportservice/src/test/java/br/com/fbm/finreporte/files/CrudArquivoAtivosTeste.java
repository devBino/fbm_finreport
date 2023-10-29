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

import br.com.fbm.finreporte.repository.files.FileManager;
import br.com.fbm.finreporte.repository.files.FileUtils;
import br.com.fbm.finreporte.repository.type.FileApp;

/**
 * Realiza testes de manipulação de linhas em arquivos
 * de ativos.
 * @author Fernando Bino Machado
 */
public class CrudArquivoAtivosTeste {

	private static String pathArquivoAtivos;
	
	@BeforeClass
	public static void definePathFile() {
		
		final StringBuilder basePath = new StringBuilder()
				.append( FileUtils.getHomePath() )
				.append("data/finreport/");
		
		pathArquivoAtivos = new StringBuilder()
				.append(basePath.toString())
				.append(FileApp.ATIVOS.getFileName())
				.toString();
		
	}
	
	@Test
	public void testesArquivoAtivos() throws Exception {
		
		Assert.assertTrue("Inserindo Linhas Arquivo Ativos", inserirLinhaArquivoAtivos());
		Assert.assertTrue("Alterando Linhas Arquivo Ativos", atualizarLinhaArquivoAtivos());
		Assert.assertTrue("Deltando Linhas Arquivo Ativos", deletarLinhaArquivoAtivos());
		
	}
	
	private boolean inserirLinhaArquivoAtivos() throws Exception {
	
		final Path path = Paths.get( pathArquivoAtivos.toString() );
		
		FileManager.inserir("knri11", pathArquivoAtivos.toString());
		FileManager.inserir("hsml11", pathArquivoAtivos.toString());
		FileManager.inserir("xplg11", pathArquivoAtivos.toString());
		
		final boolean hasLinhas = !Files.readAllLines(path).isEmpty();
	
		return hasLinhas;
		
	}
	
	private boolean atualizarLinhaArquivoAtivos() throws Exception {
		
		final String ativo = "2;tgar11";
		final Path path = Paths.get( pathArquivoAtivos.toString() );
		
		FileManager.alterarLinha(ativo, pathArquivoAtivos.toString());
		
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
	
	private boolean deletarLinhaArquivoAtivos() throws Exception {
		
		final String ativo = "1;knri11";
		final Path path = Paths.get( pathArquivoAtivos.toString() );
		
		FileManager.deletarLinha(ativo, pathArquivoAtivos.toString());
		
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
