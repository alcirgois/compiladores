package compiladorCMenos.teste;

import org.junit.Test;

import compiladorCMenos.main.Main;

public class CompiladorCMenosTesterSintatico {

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
	public void testMain3() { // Teste Léxico dos simbolos especiais
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste3.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain4() { // Código Java (compiladorCMenos.lexer.Lexer) editado
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste4.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain5() { // Programa teste livro de Louden (p. 498)
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste5.cm"});
	}

	@Test
//	@Ignore
	public void testMain6() { // Código while extressado
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste6.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain7() { // Código semanticamente errado
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste7.cm"});
	}
}
