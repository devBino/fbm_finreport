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
 * {@code FinReportProcessorIface} define as etapas 
 * de processamento de um ativo financeiro
 * @author Fernando Bino Machado
 */
public interface FinReportProcessorIface {

	/**
	 * Verifica se existe um registro no inicio da fila
	 * @return
	 */
	boolean hasRegistro() throws BusinessException;
	
	/**
	 * Retira o registro do inicio da fila e prepara
	 * para processamento
	 */
	void prepare() throws BusinessException;
	
	/**
	 * Processa o registro
	 */
	void processar() throws BusinessException;
	
	/**
	 * Finaliza o processo, atualizando fila
	 * e atualizando informações recuperadas do registro
	 * processado
	 */
	void finalizar() throws BusinessException;
	
}
