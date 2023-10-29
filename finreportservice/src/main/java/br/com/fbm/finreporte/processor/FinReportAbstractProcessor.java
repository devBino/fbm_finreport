/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.processor;

import br.com.fbm.finreporte.business.exception.BusinessException;

/**
 * {@code FinReportAbstractProcessor} define uma implementação abstrata de processamento
 * de ativos financeiros, baseada em {@code FinReportProcessorIface}
 * 
 * @author Fernando Bino Machado
 */
public class FinReportAbstractProcessor 
	implements FinReportProcessorIface {

	@Override
	public boolean hasRegistro() throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void prepare() throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void processar() throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void finalizar() throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
}
