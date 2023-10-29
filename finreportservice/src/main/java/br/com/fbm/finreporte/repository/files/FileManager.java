/**
 * Projeto Cliente/Serviço de captura de informações 
 * de ativos financeiros.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_finreport
 */
package br.com.fbm.finreporte.repository.files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * {@code FileManager} manipula linhas em arquivos,
 * inserindo, alterando ou deletando linhas.
 * @author Fernando Bino Machado
 */
public class FileManager {

	/**
	 * Retorna o próximo id para uma linha dentro de um arquivo.
	 * @param pPath
	 * @return
	 * @throws Exception
	 */
	public synchronized static int nextId(final String pPath) 
			throws Exception {
		
		//TODO BINO tratar exceções
		final Path path = Paths.get(pPath);

		final List<String> linhas = Files.readAllLines(path);
		
		int ultimaLinha = 1;
		
		if( linhas.isEmpty() ) {
			return ultimaLinha;
		}
		
		String[] dadosUltimaLinha = linhas.get( linhas.size() - 1 ).split(";");
		ultimaLinha = Integer.valueOf( dadosUltimaLinha[0] );
		
		return ++ultimaLinha;
		
	}
	
	/**
	 * Cria um arquivo e insere linhas no mesmo.
	 * @param pLinhas
	 * @param pPath
	 * @throws Exception
	 */
	public synchronized static void inserir(final String pLinha, 
			final String pPath) throws Exception {
		
		//TODO BINO tratar exceções
		final Path path = Paths.get(pPath);
		
		final File file = new File(pPath);
		
		final List<String> linhasArquivo = Files.readAllLines(path);
		
		linhasArquivo.add(new StringBuilder()
				.append(nextId(pPath))
				.append(";")
				.append(pLinha)
				.toString());
		
		if( file.exists() ) {
			file.delete();
		}
		
		Files.write(path, linhasArquivo);
		
	}
	
	/**
	 * Altera uma linha dentro de um arquivo
	 * @param pLinha
	 * @param pPath
	 * @throws Exception
	 */
	public synchronized static void alterarLinha(final String pLinha,
			final String pPath) throws Exception {
		
		//TODO BINO tratar exceções
		final Path path = Paths.get(pPath);
		
		final File file = new File(pPath);
		
		final String idLinha = pLinha.split(";")[0];
		
		final Function<String, String> fn = ln -> {
			
			if( ln.startsWith(idLinha) ) {
				return pLinha;
			}
			
			return ln;
			
		};
		
		final List<String> linhasArquivo = Files.readAllLines(path)
				.stream()
				.map(fn)
				.collect(Collectors.toList());
		
		if( file.exists() ) {
			file.delete();
		}
		
		Files.write(path, linhasArquivo);
				
	}
	
	/**
	 * Deleta uma linha de um arquivo
	 * @param pLinha
	 * @param pPath
	 * @throws Exception
	 */
	public synchronized static void deletarLinha(final String pLinha,
			final String pPath) throws Exception {
		
		//TODO BINO tratar exceções
		final Path path = Paths.get(pPath);
		
		final File file = new File(pPath);
		
		final String idLinha = pLinha.split(";")[0];
		
		final Predicate<String> ft = ln -> !ln.startsWith(idLinha);
		
		final List<String> linhasArquivo = Files.readAllLines(path)
				.stream()
				.filter(ft)
				.collect(Collectors.toList());
		
		if( file.exists() ) {
			file.delete();
		}
		
		Files.write(path, linhasArquivo);
		
	}
	
	/**
	 * Retorna todas as linhas de um arquivo
	 * @param pPath
	 * @return
	 * @throws Exception
	 */
	public synchronized static List<String> getLinhas(final String pPath) 
			throws Exception {
		
		//TODO BINO tratar exceções
		final Path path = Paths.get(pPath);
		
		return Files.readAllLines(path);
		
	}
	
	
}
