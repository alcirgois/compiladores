package compiladorCMenos.main;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.ArrayList;

import compiladorCMenos.lexer.Lexer;
import compiladorCMenos.lexer.LexerException;
import compiladorCMenos.main.lexer.CMenosLexer;
import compiladorCMenos.node.EOF;
import compiladorCMenos.node.Start;
import compiladorCMenos.node.TBranco;
import compiladorCMenos.node.Token;
import compiladorCMenos.parser.Parser;
import compiladorCMenos.parser.ParserException;

public class Main {

	public static void main(String[] args) {
		if (args.length > 0) {
	         try {
	            CMenosLexer lexer = new CMenosLexer (new PushbackReader(
	               new FileReader(args[0]), 1024));
	            Parser parser = new Parser(lexer);
	            /*Start start =*/ parser.parse();
	            //start.apply();
	         }
	         catch (LexerException e) {
	        	 System.err.println("\nSequ�ncia de s�mbolos n�o reconhecida: \"" + e.getToken().getText() + "\", linha "
	        			 + e.getToken().getLine() + ", coluna " + e.getToken().getPos());
	         }
	         catch (ParserException e) {
	        	 if (e.getToken() instanceof EOF) {
	        		 System.err.println("\nSint�xe n�o aceita: espera-se que a �ltima declara��o seja a fun��o \"void main(void){...}\"");
	        	 } else {
	        		 System.err.println("\nSint�xe n�o aceita: \"" + e.getToken().getText() + "\" declarado quando se espera "
	        			 + getTokensEsperados(e.getMessage()) + ", linha " + e.getToken().getLine() + ", coluna " + e.getToken().getPos());
	        	 }
	         }
	         catch (Exception e) {
	            System.out.println (e);
	         }
	      } else {
	         System.err.println("Arquivo de entrada n�o informado.");
	         System.exit(1);
	      }
		if (6 == 5 != true && false || true){}
	}
	
	public void testeLexico(String[] args) {
		if (args.length > 0) {
	         try {
	            CMenosLexer lexer = new CMenosLexer (new PushbackReader(
	               new FileReader(args[0]), 1024));
	            AnaliseLexica(args[0], lexer);
	         }
	         catch (LexerException e) {
	        	 System.err.println("\nSequ�ncia de s�mbolos n�o reconhecida: \"" + e.getToken().getText() + "\", linha "
	        			 + e.getToken().getLine() + ", coluna " + e.getToken().getPos());
	         }catch (Exception e) {
	            System.out.println (e);
	         }
	      } else {
	         System.err.println("Arquivo de entrada n�o informado.");
	         System.exit(1);
	      }
	}
	
	public static String getTokensEsperados(String messagemErro) {
		String[] tokens;
		messagemErro = messagemErro.substring(messagemErro.indexOf("expecting:") + 11);
		tokens = messagemErro.split("'(,[. - '])?");
		String texto = "";
		
		for (String token : tokens) {
			
			if (token.length() > 0){
				if(token.startsWith("id"))
					texto = texto + "\"" + "vari�vel" + "\" ou";
				
				else if(token.startsWith("EOF"))
					texto = texto + "\"" + "Fim de Arquivo" + "\" ou";
					
				else
					texto = texto + "\"" + token + "\" ou ";
			}
		}
		
		return texto.substring(0, texto.length() - 4);
	}
	
	public void AnaliseLexica(String arquivo, Lexer lexer) throws LexerException, IOException {
		System.out.println("******* C- An�lise L�xica: " + arquivo + " *******");
        
        Token token = null;
        int linha = 0;
        while (!((token = lexer.next()) instanceof EOF)) {
        	if (!(token instanceof TBranco)) { // Omitindo espa�o em branco
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
