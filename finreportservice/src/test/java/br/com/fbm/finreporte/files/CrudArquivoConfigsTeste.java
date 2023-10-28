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
 * de configs.
 * @author Fernando Bino Machado
 */
public class CrudArquivoConfigsTeste {

	private static String pathArquivoConfigs;
	
	@BeforeClass
	public static void definePathFile() {
		
		final StringBuilder basePath = new StringBuilder()
				.append( FileUtils.getHomePath() )
				.append("data/finreport/");
		
		pathArquivoConfigs = new StringBuilder()
				.append(basePath.toString())
				.append(FileApp.CONFIGS.getFileName())
				.toString();
		
	}
	
	@Test
	public void inserirLinhaArquivoConfigs() throws Exception {
	
		final Path path = Paths.get( pathArquivoConfigs.toString() );
		//TODO BINO chamar rotina de inserção de linha no arquivo
		final boolean hasLinhas = !Files.readAllLines(path).isEmpty();
	
		Assert.assertTrue(hasLinhas);
		
	}
	
	@Test
	public void atualizarLinhaArquivoAtivos() throws Exception {
		
		final String ativo = "2;consumir_apis;false";
		final Path path = Paths.get( pathArquivoConfigs.toString() );
		
		//TODO BINO chamar rotina para alterar a linha no arquivo
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeConfigEncontrada = at -> at
				.toLowerCase()
				.equals( ativo.toLowerCase() );
		
		final Optional<String> existeConfig = linhas
				.stream()
				.filter(testeConfigEncontrada)
				.findFirst();
		
		Assert.assertTrue( existeConfig.isPresent() );
		
	}
	
	@Test
	public void deletarLinhaArquivoAtivos() throws Exception {
		
		final String ativo = "3;tempo_cache;120";
		final Path path = Paths.get( pathArquivoConfigs.toString() );
		
		//TODO BINO chamar rotina para deletar linha no arquivo
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeConfigEncontrada = at -> at
				.toLowerCase()
				.equals( ativo.toLowerCase() );
		
		final Optional<String> existeConfig = linhas
				.stream()
				.filter(testeConfigEncontrada)
				.findFirst();
		
		Assert.assertTrue( !existeConfig.isPresent() );
		
	}
	
	
}
