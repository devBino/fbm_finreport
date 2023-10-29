/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.business.exception;

import br.com.fbm.finreporte.repository.type.Erro;

/**
 * {@code BusinessException} define tratamento personalizado
 * das exceções que possam ocorrer na aplicação
 * @author Fernando Bino Machado
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 7317221460746810633L;
	
	/**
	 * Define o erro personalizado de {@code Erro}
	 */
	private Erro erro;
	
	/**
	 * Define a causa de {@code BusinessException}
	 */
	private Throwable throwable;
	
	/**
	 * Instancia {@code BusinessException} recebendo um {@code Erro}
	 * @param pErro
	 */
	public BusinessException(final Erro pErro) {
		erro = pErro;
		throwable = new Throwable(Erro.ERRO_DESCONHECIDO.getMensagem());
		super.initCause(throwable);
	}
	
	/**
	 * Instancia {@code BusinessException} recebendo um {@code Erro}
	 * e um {@code Throwable}
	 * @param pErro
	 * @param pThrowable
	 */
	public BusinessException(final Erro pErro, final Throwable pThrowable) {
		erro = pErro;
		throwable = pThrowable;
		super.initCause(pThrowable);
	}
	
	@Override
	public String getMessage() {
		return erro.getMensagemErro( getCause().getMessage() );
	}
	
}
