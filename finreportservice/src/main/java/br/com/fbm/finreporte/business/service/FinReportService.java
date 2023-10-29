/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.business.service;

/**
 * {@code FinReportService} define regras para processamento
 * de ativos financeiros
 * @author Fernando Bino Machado
 */
public interface FinReportService {

	/**
	 * Define o ticker para processamento
	 * @param pTicker
	 */
	void setTicker(final String pTicker);
	
	/**
	 * Recupera informações via web scraping
	 * de uma ou mais urls
	 */
	void webScrapingInfo();
	
	/**
	 * Consome alguma API definida para informações real time
	 */
	void realTimeInfo();
	
	/**
	 * Realiza donwloads de documentos de uma 
	 * ou mais urls defindas
	 */
	void donwloads();
	
}
