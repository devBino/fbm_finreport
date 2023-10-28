/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.repository.files;

/**
 * {@code FileUtils} provê métodos úteis para
 * manipulação de arquivos conforme necessidade da aplicação
 * @author Fernando Bino Machado
 */
public class FileUtils {

	/**
	 * Recpera o path do usuário no sistema operacional,
	 * se for em windows, substitui a barra invertida por 
	 * barra normal 
	 * @return
	 */
	public static String getHomePath() {
		
		if( System.getProperties().getProperty("os.name")
				.toLowerCase().contains("windows") ) {
			
			final StringBuilder pathUser = new StringBuilder( 
					System.getProperties().getProperty("user.home") )
					.append("/");
			
			removerBarraWindows(pathUser);
			
			return pathUser.toString();
			
		}
		
		return System.getProperties().getProperty("user.home") + "/";
		
	}
	
	/**
	 * Remove a barra de file paths em windows
	 * @param pFilePath
	 */
	private static void removerBarraWindows(final StringBuilder pFilePath) {
		
		final String homePathTratado = pFilePath.toString().replace("\\", "/");
		
		pFilePath.delete(0, pFilePath.length());
		pFilePath.append(homePathTratado);
		
	}

	
}
