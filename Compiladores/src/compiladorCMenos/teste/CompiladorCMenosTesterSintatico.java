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
	public void testMain2() { // Teste L�xico das palavras chaves
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste2.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain3() { // Teste L�xico dos simbolos especiais
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste3.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain4() { // C�digo Java (compiladorCMenos.lexer.Lexer) editado
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
	public void testMain6() { // C�digo while extressado
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste6.cm"});
	}
	
	@Test
//	@Ignore
	public void testMain7() { // C�digo semanticamente errado
		Main tester = new Main();
		tester.main(new String[] {"codigos_teste/teste7.cm"});
	}
}
