/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.business.bo;

import br.com.fbm.finreporte.business.exception.BusinessException;
import br.com.fbm.finreporte.repository.type.Erro;

/**
 * {@code FilaAtivoBO} representa um ativo
 * registrado na fila de ativos
 * @author Fernando Bino Machado
 */
public class FilaAtivoBO {

	/**
	 * Define o id do registro de ativo
	 */
	private int id;
	
	/**
	 * Define o ticker do ativo
	 */
	private String ticker;
	
	/**
	 * Recebe uma linha do arquivo fila de ativos
	 * e cria uma nova instância de {@code FilaAtivoBO}
	 * @param pLinhaArquivo
	 * @throws BusinessException
	 */
	public FilaAtivoBO(final String pLinhaArquivo)
		throws BusinessException {
		
		try {
			popularCampos(pLinhaArquivo);
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_LINHA_ARQUIVO, exception);
		}
		
	}
	
	/**
	 * Cria nova instância de {@code FilaAtivoBO}
	 * recebendo os parâmetros
	 * @param id
	 * @param ticker
	 */
	public FilaAtivoBO(int id, String ticker) {
		this.id = id;
		this.ticker = ticker;
	}
	
	/**
	 * Abaixo métodos getters e setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	/**
	 * Recebe uma linha do arquivo de fila ativos e 
	 * popula os atributos dessa instância
	 * @param pLinhaArquivo
	 * @throws Exception
	 */
	private void popularCampos(final String pLinhaArquivo)
		throws Exception {
		
		final String[] dadosLinha = pLinhaArquivo.split(";");
		
		id = Integer.valueOf( dadosLinha[0] );
		ticker = dadosLinha[1];
		
	}
	
	
}
