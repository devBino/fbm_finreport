/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.files;

import java.io.File;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fbm.finreporte.repository.FileTestRepository;
import br.com.fbm.finreporte.repository.files.VerificaCriacaoArquivosServico;

/**
 * {@code CriacaoArquivosPadrao} realiza testes para conferir
 * se os arquivos foram criados nos diretórios padrões para
 * rodar a aplicação após executar rotinas de criação dos arquivos
 * durante inicialização da aplicação
 * @author Fernando Bino Machado
 */
public class CriacaoArquivosPadrao {

	private static String pathArquivoFilaAtivos, pathArquivoAtivos, pathArquivoConfigs;
	
	@BeforeClass
	public static void definePathFile() {
		
		pathArquivoFilaAtivos = FileTestRepository.getPathArquivoFilaAtivos();
		pathArquivoAtivos = FileTestRepository.getPathArquivoAtivos();
		pathArquivoConfigs = FileTestRepository.getPathArquivoConfigs();
		
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
		VerificaCriacaoArquivosServico.checaExistenciaECriaArquivos();
	}
	
	
}
