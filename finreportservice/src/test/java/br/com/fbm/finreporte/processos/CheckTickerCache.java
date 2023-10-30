/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.processos;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.fbm.finreporte.constants.FinReportTestConstants;
import br.com.fbm.finreporte.repository.cache.CacheManager;

/**
 * {@code CheckTickerCache} testa se os dados do ticker 
 * foram capturados e salvos em cache
 * @author Fernando Bino Machado
 */
public class CheckTickerCache {

	@Test
	public void checarTickerSalvoEmCache() {
		
		CacheManager cacheManager = new CacheManager();
		
		Map<String, String> dadosTicker = cacheManager
				.getDadosTickerCache( FinReportTestConstants.TICKER_TESTE );
		
		Assert.assertTrue( dadosTicker != null );
		
	}
	
}
