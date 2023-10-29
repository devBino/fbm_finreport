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

	ERRO_DESCONHECIDO((byte)1, "Erro desconhecido"),
	ERRO_MANIPULAR_ARQUIVO((byte)2,"Erro ao manipular o arquivo");
	
	byte code;
	String mensagem;
	
	Erro(final byte pCode, final String pMensagem){
		code = pCode;
		mensagem = pMensagem;
	}
	
	public byte getCode() {
		return code;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getMensagemErro(final String pMensagemEx) {
		
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
