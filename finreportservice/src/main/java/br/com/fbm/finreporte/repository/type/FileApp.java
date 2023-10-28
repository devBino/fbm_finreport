/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.finreporte.repository.type;

/**
 * {@code FileApp} determina os arquivos a serem
 * criados para rodar aplicação
 * 
 * @author Fernando Bino Machado
 */
public enum FileApp {

	/**
	 * Valores para diretórios e arquivos
	 */
	DIR_DATA("data"),
	DIR_APP("finreporte"),
	ATIVOS("ativos.txt"),
	CONFIGS("configs.txt"),
	FILA_ATIVOS("fila_ativos.txt");
	
	String fileName;
	
	/**
	 * Cria novo tipo de {@code FileApp}
	 * @param pFileName
	 */
	FileApp(final String pFileName) {
		fileName = pFileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	
}
