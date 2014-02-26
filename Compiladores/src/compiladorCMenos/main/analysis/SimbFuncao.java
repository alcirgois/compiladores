package compiladorCMenos.main.analysis;

import java.util.ArrayList;
import java.util.LinkedList;

import compiladorCMenos.node.PComando;
import compiladorCMenos.node.PParametro;

public class SimbFuncao extends Simbolo {

	private LinkedList<PParametro> parametros;
	private LinkedList<PComando> comandos;

	public SimbFuncao(String nome, int nivelEscopo) {
		alocacaoSimples = true;
		tamAlocacao = 1;
		valor = new ArrayList<String>(1);
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

	public LinkedList<PParametro> getParametros() {
		return parametros;
	}

	public void setParametros(LinkedList<PParametro> parametros) {
		this.parametros = parametros;
	}

	@Override
	public boolean isAlocacaoSimples() {
		return alocacaoSimples;
	}

	@Override
	public void setAlocacaoSimples(boolean alocacaoSimples) {
		// nada
	}

	@Override
	public int getTamAlocacao() {
		return 1;
	}

	@Override
	public void setTamAlocacao(int tamAlocacao) {
		// nada
	}

	@Override
	public ArrayList<String> getValores() {
		return valor;
	}

	@Override
	public void setValor(int indice, String valor) {
		if ((indice >= 0) && (indice < tamAlocacao))
			this.valor.set(indice, valor);
	}

	public LinkedList<PComando> getComandos() {
		return comandos;
	}

	public void setComandos(LinkedList<PComando> comandos) {
		this.comandos = comandos;
	}

}
