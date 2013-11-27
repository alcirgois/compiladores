package compiladorCMenos.main;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

import compiladorCMenos.lexer.Lexer;
import compiladorCMenos.lexer.LexerException;
import compiladorCMenos.main.lexer.CMenosLexer;
import compiladorCMenos.node.EOF;
import compiladorCMenos.node.TBranco;
import compiladorCMenos.node.Token;

public class Main {

	public static void main(String[] args) {
		if (args.length > 0) {
	         try {
	            /* Form our AST */
	            CMenosLexer lexer = new CMenosLexer (new PushbackReader(
	               new FileReader(args[0]), 1024));
	            
	            AnaliseLexica(args[0], lexer);
	         }
	         catch (LexerException e) {
	        	 System.err.println("\nSequência de símbolos não reconhecida \"" + e.getToken().getText() + "\": linha "
	        			 + e.getToken().getLine() + ", coluna " + e.getToken().getPos());
	         }catch (Exception e) {
	            System.out.println (e);
	         }
	      } else {
	         System.err.println("Arquivo de entrada não informado.");
	         System.exit(1);
	      }
	}
	
	public static void AnaliseLexica(String arquivo, Lexer lexer) throws LexerException, IOException {
		System.out.println("******* C- Análise Léxica: " + arquivo + " *******");
        
        Token token = null;
        int linha = 0;
        while (!((token = lexer.next()) instanceof EOF)) {
        	if (!(token instanceof TBranco)) { // Omitindo espaço em branco
        		if (linha == 0) {
        			linha = token.getLine();
        			System.out.print(linha + "-\t");
        		}
        		if (linha != token.getLine()) {
        			linha = token.getLine();
        			System.out.print("\n" + linha + "-\t");
        		}
        		System.out.print(token.getClass().getSimpleName() + "(\'" + token.getText() + "\') ");
        	}
        }
	}
}
