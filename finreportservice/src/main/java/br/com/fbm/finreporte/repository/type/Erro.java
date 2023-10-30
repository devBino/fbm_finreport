/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.repository.type;

/**
 * {@code Erro} define os erro específicos
 * que poderão ocorrer durante execução da aplicação
 * @author Fernando Bino Machado
 */
public enum Erro {

	/**
	 * Erros personalizados para {@code BusinessException}
	 */
	ERRO_DESCONHECIDO( (byte)1, "Erro desconhecido"),
	ERRO_LINHA_ARQUIVO( (byte)2, "Erro ao aplicar linha do arquivo no objeto BO"),
	ERRO_MANIPULAR_ARQUIVO( (byte)3,"Erro ao manipular o arquivo");
	
	/**
	 * Define o código do erro
	 */
	byte code;
	
	/**
	 * Define a mensagem do erro
	 */
	String mensagem;
	
	/**
	 * Instancia um tipo de {@code Erro}
	 * @param pCode
	 * @param pMensagem
	 */
	Erro(final byte pCode, final String pMensagem){
		code = pCode;
		mensagem = pMensagem;
	}
	
	/**
	 * Retorna o codigo do erro
	 * @return
	 */
	public byte getCode() {
		return code;
	}
	
	/**
	 * Retorna a mensagem do erro
	 * @return
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * Recebe uma mensagem de um {@code Throwable} 
	 * e compila e retorna uma mensagem personalizada
	 * @param pMensagemEx
	 * @return
	 */
	public String getMensagemPersonalizadaErro(final String pMensagemEx) {
		
		return new StringBuilder()
				.append("[")
				.append(code)
				.append("] - ")
				.append(mensagem)
				.append("\n")
				.append(pMensagemEx)
				.toString();
		
	}
	
	
}
