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

	private int id;
	private String ticker;
	
	public FilaAtivoBO(final String pLinhaArquivo)
		throws BusinessException {
		
		try {
			popularCampos(pLinhaArquivo);
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_LINHA_ARQUIVO, exception);
		}
		
	}
	
	public FilaAtivoBO(int id, String ticker) {
		this.id = id;
		this.ticker = ticker;
	}
	
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
	
	private void popularCampos(final String pLinhaArquivo)
		throws Exception {
		
		final String[] dadosLinha = pLinhaArquivo.split(";");
		
		id = Integer.valueOf( dadosLinha[0] );
		ticker = dadosLinha[1];
		
	}
	
	
}
