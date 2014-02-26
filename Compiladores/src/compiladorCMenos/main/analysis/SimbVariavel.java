package compiladorCMenos.main.analysis;

import java.util.ArrayList;

public class SimbVariavel extends Simbolo {

	public SimbVariavel(String nome, int nivelEscopo) {
		this.nome = nome;
		this.nivelEscopo = nivelEscopo;
	}

	@Override
	public int getTipo() {
		return tipo;
	}

	@Override
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getValor() {
		if (alocacaoSimples)
			return valor.get(0);
		return null;
	}

	@Override
	public void setValor(String valor) {
		if (alocacaoSimples)
			this.valor.set(0, valor);
	}

	@Override
	public ArrayList<String> getValores() {
		return valor;
	}

	@Override
	public void setValor(int indice, String valor) {
		if ((indice >= 0) && (indice < tamAlocacao)) {
			this.valor.set(indice, valor);
		}
	}

	@Override
	public boolean isAlocacaoSimples() {
		return alocacaoSimples;
	}

	@Override
	public void setAlocacaoSimples(boolean alocacaoSimples) {
		this.alocacaoSimples = alocacaoSimples;
		if (alocacaoSimples)
			setTamAlocacao(1);
	}

	@Override
	public int getTamAlocacao() {
		return tamAlocacao;
	}

	@Override
	public void setTamAlocacao(int tamAlocacao) {
		this.tamAlocacao = tamAlocacao;
		valor = new ArrayList<String>(tamAlocacao);
	}

}
