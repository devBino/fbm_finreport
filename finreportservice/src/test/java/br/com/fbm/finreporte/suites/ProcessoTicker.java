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
import br.com.fbm.finreporte.processos.CheckTickerCache;
import br.com.fbm.finreporte.processos.InsereTickerFila;
import br.com.fbm.finreporte.processos.ProcessaTickerInfo;

/**
 * {@code ProcessoTicker} agrupa testes no cenário
 * de processamento de um ticker do inicio ao fim
 * @author Fernando Bino Machado
 */
@RunWith(Suite.class)
@SuiteClasses({
	CriacaoArquivosPadrao.class,
	InsereTickerFila.class,
	ProcessaTickerInfo.class,
	CheckTickerCache.class
})
public class ProcessoTicker {}
