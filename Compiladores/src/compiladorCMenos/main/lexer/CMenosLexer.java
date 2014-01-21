package compiladorCMenos.main.lexer;


import java.io.PushbackReader;

import compiladorCMenos.lexer.Lexer;
import compiladorCMenos.lexer.LexerException;
import compiladorCMenos.node.EOF;
import compiladorCMenos.node.InvalidToken;
import compiladorCMenos.node.TComentAnin;
import compiladorCMenos.node.TFComentAnin;

public class CMenosLexer extends Lexer {
	
	private TComentAnin ultimoComent;
	
	public CMenosLexer(PushbackReader in) {
		super(in);
	}

	protected void filter() throws LexerException {
		if (state == State.COMENT) { // State.COMENT reconhecedor de comentário com delimitadores '/*' e '*/'
			if (token instanceof TComentAnin) { // TComentAnin = /* qualquer símbolo que não seja a sequência '*/' e não termine com '*'
				ultimoComent = (TComentAnin) token; // obtém a referência do objeto com as informações do início do comentário
				token = null;
			} else if (token instanceof TFComentAnin) { // TFComentAnin = um ou mais '*' seguido por um '/'
				ultimoComent.setText(ultimoComent.getText() + token.getText()); // adiciona o texto final ao comentário.
				token = ultimoComent;
				state = State.NORMAL;
			} else if (token instanceof EOF) // O comentário foi aberto e não foi fechado. Lança um erro léxico.
				throw new LexerException(new InvalidToken(ultimoComent.getText(), ultimoComent.getLine(),
						ultimoComent.getPos()), "Token de comentário desconhecido.");
		}
	}
	
}