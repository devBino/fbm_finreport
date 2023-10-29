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
	public void testesArquivoConfigs() throws Exception {
		
		Assert.assertTrue("Inserindo Linhas Arquivo Configs", inserirLinhaArquivoConfigs());
		Assert.assertTrue("Alterando Linhas Arquivo Configs", atualizarLinhaArquivoConfigs());
		Assert.assertTrue("Deltando Linhas Arquivo Configs", deletarLinhaArquivoConfigs());
		
	}
	
	private boolean inserirLinhaArquivoConfigs() throws Exception {
	
		final Path path = Paths.get( pathArquivoConfigs.toString() );
		
		FileManager.inserir("confi1;true", pathArquivoConfigs.toString());
		FileManager.inserir("confi2;false", pathArquivoConfigs.toString());
		FileManager.inserir("confi3;true", pathArquivoConfigs.toString());
		
		final boolean hasLinhas = !Files.readAllLines(path).isEmpty();
	
		return hasLinhas;
		
	}
	
	private boolean atualizarLinhaArquivoConfigs() throws Exception {
		
		final String config = "2;confi20;true";
		
		final Path path = Paths.get( pathArquivoConfigs.toString() );
		
		FileManager.alterarLinha(config, pathArquivoConfigs.toString());
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeConfigEncontrada = at -> at
				.toLowerCase()
				.equals( config.toLowerCase() );
		
		final Optional<String> existeConfig = linhas
				.stream()
				.filter(testeConfigEncontrada)
				.findFirst();
		
		return existeConfig.isPresent();
		
	}
	
	private boolean deletarLinhaArquivoConfigs() throws Exception {
		
		final String config = "1;confi1;true";
		
		final Path path = Paths.get( pathArquivoConfigs.toString() );
		
		FileManager.deletarLinha(config, pathArquivoConfigs.toString());
		
		final List<String> linhas = Files.readAllLines(path);
		
		final Predicate<String> testeConfigEncontrada = at -> at
				.toLowerCase()
				.equals( config.toLowerCase() );
		
		final Optional<String> existeConfig = linhas
				.stream()
				.filter(testeConfigEncontrada)
				.findFirst();
		
		return !existeConfig.isPresent();
		
	}
	
	
}
