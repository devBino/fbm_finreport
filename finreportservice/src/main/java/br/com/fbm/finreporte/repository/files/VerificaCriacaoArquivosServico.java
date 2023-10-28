/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.finreporte.repository.files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.fbm.finreporte.repository.type.FileApp;

/**
 * {@code CheckCreatedDefaultFiles} tem a responsabilidade
 * de checar se os arquivos default da aplicação já estão criados.
 * @author Fernando Bino Machado
 */
public class VerificaCriacaoArquivosServico {
	
	/**
	 * Constantes para difenciar tipos de arquivo
	 */
	private static final String DIRETORIOS = "d";
	private static final String ARQUIVOS = "a";

	/**
	 * Cria diretórios padrão para inicialização da aplicação
	 */
	public static void checaExistenciaECriaArquivos() {
		
		final StringBuilder basePath = new StringBuilder()
				.append( FileUtils.getHomePath() )
				.append("data/");
		
		//cria pasta data dentro do home path
		final File dataDir = new File(basePath.toString());
		
		if( !dataDir.exists() ) {
			dataDir.mkdir();
		}
		
		basePath.append("finreport/");
		
		//cria pasta finreport dentro da pasta data
		final File finReportDir = new File(basePath.toString());
		
		if( !finReportDir.exists() ) {
			finReportDir.mkdir();
		}
		
		//cria arquivos dentro do diretório padrão do serviço
		criarArquivosPadrao(basePath.toString());
		
	}

	/**
	 * Cria arquivos padrões para inicialização da aplicação
	 * @param pBasePath
	 */
	private static void criarArquivosPadrao(final String pBasePath) {
		
		final StringBuilder baseDir = new StringBuilder()
				.append(pBasePath);
		
		for( FileApp fType : FileApp.values() ) {
			
			if( fType.getTipo().equals( DIRETORIOS ) ) {
				continue;
			}
			
			final StringBuilder nameFileDir = new StringBuilder()
					.append( baseDir.toString() )
					.append( fType.getFileName() );
			
			final File file = new File( nameFileDir.toString() );
			
			if( file.exists() ) {
				continue;
			}
			
			final Path path = Paths.get( file.getPath() );
			
			try {
				Files.write(path, "".getBytes());
			}catch(final Exception exception) {
				//TODO BINO tratar exceção em demanda futura
			}
			
		}
		
	}
	
	
}
