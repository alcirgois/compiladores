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
		if (state == State.COMENT) { // State.COMENT reconhecedor de coment�rio com delimitadores '/*' e '*/'
			if (token instanceof TComentAnin) { // TComentAnin = /* qualquer s�mbolo que n�o seja a sequ�ncia '*/' e n�o termine com '*'
				ultimoComent = (TComentAnin) token; // obt�m a refer�ncia do objeto com as informa��es do in�cio do coment�rio
				token = null;
			} else if (token instanceof TFComentAnin) { // TFComentAnin = um ou mais '*' seguido por um '/'
				ultimoComent.setText(ultimoComent.getText() + token.getText()); // adiciona o texto final ao coment�rio.
				token = ultimoComent;
				state = State.NORMAL;
			} else if (token instanceof EOF) // O coment�rio foi aberto e n�o foi fechado. Lan�a um erro l�xico.
				throw new LexerException(new InvalidToken(ultimoComent.getText(), ultimoComent.getLine(),
						ultimoComent.getPos()), "Token de coment�rio desconhecido.");
		}
	}
	
}