/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.business.generic;

import br.com.fbm.finreporte.business.service.FinReportService;

/**
 * {@code FinReportGeneric} define implementação genérica de 
 * {@code FinReportService}
 * @author Fernando Bino Machado
 */
public class FinReportGeneric implements FinReportService {

	protected String ticker;
	
	@Override
	public void setTicker(String pTicker) {
		ticker = pTicker;
	}
	
	@Override
	public void webScrapingInfo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void realTimeInfo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void donwloads() {
		// TODO Auto-generated method stub
		
	}
	
	
}
