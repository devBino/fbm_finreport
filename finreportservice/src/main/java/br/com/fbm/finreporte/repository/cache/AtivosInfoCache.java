/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.repository.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code AtivosInfoCache} armazena em cache as informações
 * recuperadas dos ativos.
 * @author Fernando Bino Machado
 */
public class AtivosInfoCache {

	/**
	 * Representa a instancia única de {@code AtivosInfoCache}
	 */
	private static AtivosInfoCache instance;
	
	/**
	 * Representa as informações dos ativos recuperadas em tempo de execução
	 */
	private Map<String, Map<String, String>> infoAtivos;
	
	/**
	 * Cria instância única de {@code AtivosInfoCache}
	 */
	private AtivosInfoCache() {
		infoAtivos = new HashMap<>();
	}
	
	/**
	 * Retorna instância única de {@code AtivosInfoCache}
	 * @return
	 */
	public static AtivosInfoCache getInstance() {
		
		if(instance == null) {
			instance = new AtivosInfoCache();
		}
		
		return instance;
		
	}
	
	/**
	 * Retorna informações dos ativos processados
	 * @return
	 */
	public Map<String, Map<String, String>> getInfoAtivos() {
		return infoAtivos;
	}
	
	
}
