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
 * criados para rodar aplicação.
 * 
 * Cada item de {@code FileApp} tem duas características,
 * o nome do file e o tipo. O nome é literalmente o nome do arquivo e deve
 * ser informado a extensão, por exemplo, dados.txt.
 * 
 * O tipo pode ser "a" ou "d" sendo que a significa "arquivo"
 * enquanto "d" diretório.
 * 
 * @author Fernando Bino Machado
 */
public enum FileApp {

	/**
	 * Valores para diretórios e arquivos
	 */
	DIR_DATA("data","d"),
	DIR_APP("finreporte","d"),
	ATIVOS("ativos.txt","a"),
	CONFIGS("configs.txt","a"),
	FILA_ATIVOS("fila_ativos.txt","a");
	
	/**
	 * Define nome do file
	 */
	String fileName;
	
	/**
	 * Define tipo do file
	 */
	String tipo;
	
	/**
	 * Cria novo tipo de {@code FileApp}
	 * @param pFileName
	 * @param pTipo
	 */
	FileApp(final String pFileName, 
			final String pTipo) {
		fileName = pFileName;
		tipo = pTipo;
	}
	
	/**
	 * Retorna nome do file
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * Retorna tipo do file
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}
	
	
}
