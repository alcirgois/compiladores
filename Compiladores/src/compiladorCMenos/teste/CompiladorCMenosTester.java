package compiladorCMenos.teste;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import compiladorCMenos.implementacao.Main;

public class CompiladorCMenosTester {

	@Test
//	@Ignore
	public void testMain1() { // Exemplo do slide: Um programa para calcular o mdc, segundo o algoritmo de Euclides
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste1.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain2() { // Teste Léxico das palavras chaves
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste2.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain3() { // Teste Léxico das palavras chaves
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste3.cm"});
	}

}
