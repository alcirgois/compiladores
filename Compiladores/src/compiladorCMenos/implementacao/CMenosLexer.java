package compiladorCMenos.implementacao;


import java.io.PushbackReader;

import compiladorCMenos.lexer.Lexer;
import compiladorCMenos.lexer.LexerException;
import compiladorCMenos.node.EOF;
import compiladorCMenos.node.InvalidToken;
import compiladorCMenos.node.TComentAnin;
import compiladorCMenos.node.TFComentAnin;
import compiladorCMenos.node.TId;
import compiladorCMenos.node.Token;

public class CMenosLexer extends Lexer {
	
	private TComentAnin ultimoComent;
	
	public CMenosLexer(PushbackReader in) {
		super(in);
	}

	protected void filter() throws LexerException {
		if (state == State.NORMAL) {
			if (token instanceof TId) { // Tratamento para identifica��o de palavras chave
				if (ehPalavraChave((TId) token))
					token = new PalavraChave(token.getText(), token.getLine(), token.getPos());
			}
		} else { // State.COMENT reconhecedor de coment�rio com delimitadores '/*' e '*/'
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
	
	public boolean ehPalavraChave(TId token) {
		switch (token.getText()) {
		case "else" :
		case "if" :
		case "int" :
		case "string" :
		case "return" :
		case "void" :
		case "while" :
			return true;
		}
		return false;
	}
}