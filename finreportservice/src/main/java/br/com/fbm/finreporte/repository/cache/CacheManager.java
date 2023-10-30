/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.repository.cache;

import java.util.Map;

/**
 * {@code CacheManager} gerencia instâncias únicas
 * das implementações de cache
 * @author Fernando Bino Machado
 */
public class CacheManager {

	/**
	 * Instância única de {@code AtivosInfoCache}
	 */
	AtivosInfoCache ativosInfoCache;
	
	/**
	 * Cria instância de {@code CacheManager}
	 */
	public CacheManager() {
		ativosInfoCache = AtivosInfoCache.getInstance();
	}
	
	/**
	 * Retorna dados do ativo salvo em cache
	 * @param pTicker
	 * @return
	 */
	public Map<String, String> getDadosTickerCache(final String pTicker){
		return ativosInfoCache.getInfoAtivos().get(pTicker);
	}
	
	/**
	 * Adiciona informações de um ticker em cache
	 * @param pTicker
	 * @param pMapInfo
	 */
	public void addAtivoInfo(final String pTicker, 
			final Map<String, String> pMapInfo) {
		ativosInfoCache.getInfoAtivos().put(pTicker, pMapInfo);
	}
	
	/**
	 * Remove informações de um ticker em cache
	 * @param pTicker
	 */
	public void removeAtivoInfo(final String pTicker) {
		ativosInfoCache.getInfoAtivos().remove(pTicker);
	}
	
}
