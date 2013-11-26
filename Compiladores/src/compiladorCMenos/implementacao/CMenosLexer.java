package compiladorCMenos.implementacao;


import java.io.PushbackReader;

import compiladorCMenos.lexer.Lexer;
import compiladorCMenos.node.TId;

public class CMenosLexer extends Lexer {
	
	public CMenosLexer(PushbackReader in) {
		super(in);
	}

	protected void filter() {
		if (token instanceof TId) {
			switch (token.getText()) {
			case "else" :
			case "if" :
			case "int" :
			case "string" :
			case "return" :
			case "void" :
			case "while" :
				token = new PalavraChave(token.getText(), token.getLine(), token.getPos());
				break;
			}
		}
	}
}
