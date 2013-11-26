package compiladorCMenos.implementacao;

import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
import java.io.PushbackReader;

import compiladorCMenos.lexer.LexerException;
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
	            
	            System.out.println("******* C- An�lise L�xica: " + args[0] + " *******");
	            
	            Token token = null;
	            int linha = 0;
	            while (!((token = lexer.next()) instanceof EOF)) {
	            	if (!(token instanceof TBranco)) {
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
	         catch (LexerException e) {
	        	 System.err.println("\nSintaxe n�o reconhecida \"" + e.getToken().getText() + "\": linha "
	        			 + e.getToken().getLine() + ", coluna " + e.getToken().getPos());
	         }catch (Exception e) {
	            System.out.println (e);
	         }
	      } else {
	         System.err.println("Arquivo de entrada n�o informado.");
	         System.exit(1);
	      }
	}

}
