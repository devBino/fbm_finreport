/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.repository;

import br.com.fbm.finreporte.constants.FinReportTestConstants;
import br.com.fbm.finreporte.repository.files.FileUtils;
import br.com.fbm.finreporte.repository.type.FileApp;

/**
 * {@code FileTestRepository} provê métodos para utilização
 * durante testes envolvendo arquivos padrão
 * @author Fernando Bino Machado
 */
public class FileTestRepository {

	/**
	 * Strings representando os paths dos arquivos
	 */
	private static String pathArquivoFilaAtivos, pathArquivoAtivos, pathArquivoConfigs;
	
	/**
	 * Recupera o path do arquivo fila de ativos
	 * @return
	 */
	public static String getPathArquivoFilaAtivos() {
		definirBaseFileDirs();
		return pathArquivoFilaAtivos;
	}
	
	/**
	 * Recupera o path do arquivo de ativos
	 * @return
	 */
	public static String getPathArquivoAtivos() {
		definirBaseFileDirs();
		return pathArquivoAtivos;
	}
	
	/**
	 * Recupera o path do arquivo de configs
	 * @return
	 */
	public static String getPathArquivoConfigs() {
		definirBaseFileDirs();
		return pathArquivoConfigs;
	}
	
	/**
	 * Define base dos diretórios para recuperação dos paths
	 */
	private static void definirBaseFileDirs() {
		
		final StringBuilder basePath = new StringBuilder()
				.append( FileUtils.getHomePath() )
				.append( FinReportTestConstants.BASE_DIR_TESTES );
		
		pathArquivoFilaAtivos = new StringBuilder()
				.append(basePath.toString())
				.append(FileApp.FILA_ATIVOS.getFileName())
				.toString();
		
		pathArquivoAtivos = new StringBuilder()
				.append(basePath.toString())
				.append(FileApp.ATIVOS.getFileName())
				.toString();
		
		pathArquivoConfigs = new StringBuilder()
				.append(basePath.toString())
				.append(FileApp.CONFIGS.getFileName())
				.toString();
		
	}
	
	
	
}
