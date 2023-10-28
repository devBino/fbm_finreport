/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.finreporte.files;

import java.io.File;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fbm.finreporte.repository.files.FileUtils;
import br.com.fbm.finreporte.repository.type.FileApp;

/**
 * {@code CriacaoArquivosPadrao} realiza testes para conferir
 * se os arquivos foram criados nos diretórios padrões para
 * rodar a aplicação
 * @author Fernando Bino Machado
 */
public class CriacaoArquivosPadrao {

	private static String pathArquivoFilaAtivos, pathArquivoAtivos, pathArquivoConfigs;
	
	@BeforeClass
	public static void definePathFile() {
		
		final StringBuilder basePath = new StringBuilder()
				.append( FileUtils.getHomePath() )
				.append("data/finreport/");
		
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
	
	@Test
	public void arquivoAtivosCriado() {
		
		invocarMetodosCriacao();
		
		final File file = new File(pathArquivoAtivos);
		
		Assert.assertTrue( file.exists() );
		
	}
	
	@Test
	public void arquivoFilaAtivosCriado() {
		
		invocarMetodosCriacao();
		
		final File file = new File(pathArquivoFilaAtivos);
		
		Assert.assertTrue( file.exists() );
		
	}
	
	@Test
	public void arquivoConfigsCriado() {
		
		invocarMetodosCriacao();
		
		final File file = new File(pathArquivoConfigs);
		
		Assert.assertTrue( file.exists() );
		
	}
	
	/**
	 * Método responsável por invocar as futuras rotinas
	 * que serão implementadas
	 */
	private void invocarMetodosCriacao() {
		
	}
	
}
