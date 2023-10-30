/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.processos;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fbm.finreporte.business.bo.FilaAtivoBO;
import br.com.fbm.finreporte.constants.FinReportTestConstants;
import br.com.fbm.finreporte.repository.FileTestRepository;
import br.com.fbm.finreporte.repository.files.FileManager;

/**
 * @author Fernando Bino Machado
 */
public class ProcessaTickerInfo {

	private static String pathArquivoFilaAtivos;
	
	@BeforeClass
	public static void definePathFile() {
		pathArquivoFilaAtivos = FileTestRepository.getPathArquivoFilaAtivos();
	}
	
	@Test(timeout = 15000)
	public void checkTickerProcessado() throws Exception {
		
		final List<String> linhas = FileManager.getLinhas(pathArquivoFilaAtivos);
		verificaTickerNaoPresenteFila(linhas);
		
	}
	
	private void verificaTickerNaoPresenteFila(final List<String> pLinhas)
		throws Exception {
		
		Optional<String> ticker = Optional.empty();
		
		for(final String lin : pLinhas) {
			
			final FilaAtivoBO bo = new FilaAtivoBO(lin);
			
			if( bo.getTicker().equals( FinReportTestConstants.TICKER_TESTE ) ) {
				ticker = Optional.of(bo.getTicker());
				break;
			}
			
		}
		
		if( !ticker.isPresent() ) {
			return;
		}
		
		TimeUnit.SECONDS.sleep(1);
		
		final List<String> linhas = FileManager.getLinhas(pathArquivoFilaAtivos);
		
		verificaTickerNaoPresenteFila(linhas);
		
	}
	
}
