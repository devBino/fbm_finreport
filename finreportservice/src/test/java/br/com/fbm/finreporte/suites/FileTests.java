/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.fbm.finreporte.files.CriacaoArquivosPadrao;
import br.com.fbm.finreporte.files.CrudArquivoAtivosTeste;
import br.com.fbm.finreporte.files.CrudArquivoConfigsTeste;
import br.com.fbm.finreporte.files.CrudArquivoFilaAtivosTeste;

/**
 * Suite de testes para agrupar testes
 * em default files do serviço.
 * @author Fernando Bino Machado
 */
@RunWith(Suite.class)
@SuiteClasses({
	CriacaoArquivosPadrao.class,
	CrudArquivoConfigsTeste.class,
	CrudArquivoAtivosTeste.class,
	CrudArquivoFilaAtivosTeste.class
})
public class FileTests {}
