package compiladorCMenos.main.analysis;

import java.util.ArrayList;

public abstract class Simbolo {
	protected int nivelEscopo;
	protected int tipo;
	protected boolean alocacaoSimples;
	protected int tamAlocacao; 
	protected String nome;
	protected ArrayList<String> valor;

	public abstract int getTipo();
	public abstract void setTipo(int tipo);
	public abstract String getNome();
	public abstract void setNome(String nome);
	public abstract String getValor();
	public abstract void setValor(String valor);
	public abstract ArrayList<String> getValores();
	public abstract void setValor(int indice, String valor);
	public abstract boolean isAlocacaoSimples();
	public abstract void setAlocacaoSimples(boolean alocacaoSimples);
	public abstract int getTamAlocacao();
	public abstract void setTamAlocacao(int tamAlocacao);
}
