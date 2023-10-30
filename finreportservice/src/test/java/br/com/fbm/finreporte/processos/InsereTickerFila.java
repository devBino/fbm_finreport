/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.processos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fbm.finreporte.constants.FinReportTestConstants;
import br.com.fbm.finreporte.repository.FileTestRepository;
import br.com.fbm.finreporte.repository.files.FileManager;

/**
 * {@code InsereTickerFila} testa se um ticker foi inserido 
 * na fila para processamento
 * @author Fernando Bino Machado
 */
public class InsereTickerFila {

	private static String pathArquivoFilaAtivos;
	
	@BeforeClass
	public static void definePathFile() {
		pathArquivoFilaAtivos = FileTestRepository.getPathArquivoFilaAtivos();
	}
	
	@Test
	public void inserirRegistro() throws Exception {
		
		final Path path = Paths.get( pathArquivoFilaAtivos.toString() );
		
		FileManager.inserir(FinReportTestConstants.TICKER_TESTE, 
				pathArquivoFilaAtivos.toString());
		
		final boolean hasLinhas = !Files.readAllLines(path).isEmpty();
	
		Assert.assertTrue(hasLinhas);
		
	}
	
}
