package compiladorCMenos.main.analysis;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import compiladorCMenos.analysis.AnalysisAdapter;
import compiladorCMenos.node.AAtribuicaoComando;
import compiladorCMenos.node.AAtribuicaoMatrizExp;
import compiladorCMenos.node.AAtribuicaoVarExp;
import compiladorCMenos.node.ABlocoComando;
import compiladorCMenos.node.ACondicaoComando;
import compiladorCMenos.node.ADeclMatrizIntComando;
import compiladorCMenos.node.ADeclMatrizStrComando;
import compiladorCMenos.node.ADeclVarIntComando;
import compiladorCMenos.node.ADeclVarStrComando;
import compiladorCMenos.node.ADiferenteExp;
import compiladorCMenos.node.ADivExp;
import compiladorCMenos.node.AFuncaoExp;
import compiladorCMenos.node.AFuncaoIntDeclaracao;
import compiladorCMenos.node.AFuncaoMain;
import compiladorCMenos.node.AFuncaoStrDeclaracao;
import compiladorCMenos.node.AIgualExp;
import compiladorCMenos.node.AMaiorIgualExp;
import compiladorCMenos.node.AMaiorQueExp;
import compiladorCMenos.node.AMatrizExp;
import compiladorCMenos.node.AMatrizIntDeclaracao;
import compiladorCMenos.node.AMatrizStrDeclaracao;
import compiladorCMenos.node.AMenorIgualExp;
import compiladorCMenos.node.AMenorQueExp;
import compiladorCMenos.node.AMultExp;
import compiladorCMenos.node.ANumExp;
import compiladorCMenos.node.AParamMatrizIntParametro;
import compiladorCMenos.node.AParamMatrizStrParametro;
import compiladorCMenos.node.AParamVarIntParametro;
import compiladorCMenos.node.AParamVarStrParametro;
import compiladorCMenos.node.AProcedDeclaracao;
import compiladorCMenos.node.APrograma;
import compiladorCMenos.node.ARepeticaoComando;
import compiladorCMenos.node.ARetornoComando;
import compiladorCMenos.node.ASomaExp;
import compiladorCMenos.node.AStrExp;
import compiladorCMenos.node.ASubExp;
import compiladorCMenos.node.AVarExp;
import compiladorCMenos.node.AVarIntDeclaracao;
import compiladorCMenos.node.AVarStrDeclaracao;
import compiladorCMenos.node.Node;
import compiladorCMenos.node.PComando;
import compiladorCMenos.node.PDeclaracao;
import compiladorCMenos.node.PExp;
import compiladorCMenos.node.PParametro;
import compiladorCMenos.node.Start;

public class DepthFirstAdapterCMenos extends AnalysisAdapter {

	private final int FUNCAO_MAIN_REDEFINIDA = 0;
	private final int FUNCAO_MAIN_NOME = 1;
	
	private final int TIPO_VOID = 0;
	private final int TIPO_INT = 1;
	private final int TIPO_STR = 2;
	
	private int nivelEscopo = 0;
	
	private Hashtable<String, Simbolo> tabelaDeSimbolos;
	
    public Simbolo getSimbolo(String nome) {
        if(this.tabelaDeSimbolos == null) {
            return null;
        }
        return this.tabelaDeSimbolos.get(nome);
    }

    public void setSimbolo(String nome, Simbolo simbolo) {
        if(this.tabelaDeSimbolos == null) {
            this.tabelaDeSimbolos = new Hashtable<String, Simbolo>(1);
        }

        if(simbolo != null) {
            this.tabelaDeSimbolos.put(nome, simbolo);
        }
        else {
            this.tabelaDeSimbolos.remove(nome);
        }
    }
	
	public void inStart(Start node) {
        defaultIn(node);
    }

    public void outStart(Start node) {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node) {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node) {
        // Do nothing
    }

    @Override
    public void caseStart(Start node) {
        inStart(node);
        node.getPPrograma().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAPrograma(APrograma node) {
        armazenarSimbolosDaLinguagem();
    }

    public void outAPrograma(APrograma node) {
        defaultOut(node);
    }

    @Override
    public void caseAPrograma(APrograma node) {
        inAPrograma(node);
        {
            List<PDeclaracao> copy = new ArrayList<PDeclaracao>(node.getDecls());
            for(PDeclaracao e : copy) {
                e.apply(this);
            }
        }
        if(node.getFuncMain() != null) {
            node.getFuncMain().apply(this);
        }
        outAPrograma(node);
    }

    public void inAVarIntDeclaracao(AVarIntDeclaracao node) {
        defaultIn(node);
    }

    public void outAVarIntDeclaracao(AVarIntDeclaracao node) {
        SimbVariavel id = new SimbVariavel(node.getNome().getText(), nivelEscopo);
        id.setTipo(TIPO_INT);
        id.setAlocacaoSimples(true);
        id.setValor("" + 0);
        
        setSimbolo(id.getNome(), id);
    }

    @Override
    public void caseAVarIntDeclaracao(AVarIntDeclaracao node) {
        inAVarIntDeclaracao(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outAVarIntDeclaracao(node);
    }

    public void inAVarStrDeclaracao(AVarStrDeclaracao node) {
        defaultIn(node);
    }

    public void outAVarStrDeclaracao(AVarStrDeclaracao node) {
    	SimbVariavel id = new SimbVariavel(node.getNome().getText(), nivelEscopo);
        id.setTipo(TIPO_STR);
        id.setAlocacaoSimples(true);
        id.setValor("");
        
        setSimbolo(id.getNome(), id);
    }

    @Override
    public void caseAVarStrDeclaracao(AVarStrDeclaracao node) {
        inAVarStrDeclaracao(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outAVarStrDeclaracao(node);
    }

    public void inAMatrizIntDeclaracao(AMatrizIntDeclaracao node) {
        defaultIn(node);
    }

    public void outAMatrizIntDeclaracao(AMatrizIntDeclaracao node) {
    	SimbVariavel id = new SimbVariavel(node.getNome().getText(), nivelEscopo);
        id.setTipo(TIPO_INT);
        id.setAlocacaoSimples(false);
        id.setTamAlocacao(Integer.valueOf(node.getDimen().getText()));
        
        setSimbolo(id.getNome(), id);
    }

    @Override
    public void caseAMatrizIntDeclaracao(AMatrizIntDeclaracao node) {
        inAMatrizIntDeclaracao(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        if(node.getDimen() != null) {
            node.getDimen().apply(this);
        }
        outAMatrizIntDeclaracao(node);
    }

    public void inAMatrizStrDeclaracao(AMatrizStrDeclaracao node) {
        defaultIn(node);
    }

    public void outAMatrizStrDeclaracao(AMatrizStrDeclaracao node) {
    	SimbVariavel id = new SimbVariavel(node.getNome().getText(), nivelEscopo);
        id.setTipo(TIPO_STR);
        id.setAlocacaoSimples(false);
        id.setTamAlocacao(Integer.valueOf(node.getDimen().getText()));
        
        setSimbolo(id.getNome(), id);
    }

    @Override
    public void caseAMatrizStrDeclaracao(AMatrizStrDeclaracao node) {
        inAMatrizStrDeclaracao(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        if(node.getDimen() != null) {
            node.getDimen().apply(this);
        }
        outAMatrizStrDeclaracao(node);
    }

    public void inAProcedDeclaracao(AProcedDeclaracao node) {
        defaultIn(node);
    }

    public void outAProcedDeclaracao(AProcedDeclaracao node) {
    	if (node.getNome().getText().equals("main"))
    		gerarErro(FUNCAO_MAIN_REDEFINIDA);

        SimbFuncao id = new SimbFuncao(node.getNome().getText(), nivelEscopo);
        id.setTipo(TIPO_VOID);
        id.setParametros(node.getPars());
        id.setComandos(node.getBloco());

        setSimbolo(getNomeFuncao(id), id);
    }

    @Override
    public void caseAProcedDeclaracao(AProcedDeclaracao node) {
        inAProcedDeclaracao(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        /*{
            List<PParametro> copy = new ArrayList<PParametro>(node.getPars());
            for(PParametro e : copy) {
                e.apply(this);
            }
        }
        {
            List<PComando> copy = new ArrayList<PComando>(node.getBloco());
            for(PComando e : copy) {
                e.apply(this);
            }
        }*/
        outAProcedDeclaracao(node);
    }

    public void inAFuncaoIntDeclaracao(AFuncaoIntDeclaracao node) {
        defaultIn(node);
    }

    public void outAFuncaoIntDeclaracao(AFuncaoIntDeclaracao node) {
    	if (node.getNome().getText().equals("main"))
    		gerarErro(FUNCAO_MAIN_REDEFINIDA);

    	SimbFuncao id = new SimbFuncao(node.getNome().getText(), nivelEscopo);
        id.setTipo(TIPO_INT);
        id.setParametros(node.getPars());
        id.setComandos(node.getBloco());

        setSimbolo(getNomeFuncao(id), id);
    }

    @Override
    public void caseAFuncaoIntDeclaracao(AFuncaoIntDeclaracao node) {
        inAFuncaoIntDeclaracao(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        /*{
            List<PParametro> copy = new ArrayList<PParametro>(node.getPars());
            for(PParametro e : copy) {
                e.apply(this);
            }
        }
        {
            List<PComando> copy = new ArrayList<PComando>(node.getBloco());
            for(PComando e : copy) {
                e.apply(this);
            }
        }*/
        outAFuncaoIntDeclaracao(node);
    }

    public void inAFuncaoStrDeclaracao(AFuncaoStrDeclaracao node) {
        defaultIn(node);
    }

    public void outAFuncaoStrDeclaracao(AFuncaoStrDeclaracao node) {
    	if (node.getNome().getText().equals("main"))
    		gerarErro(FUNCAO_MAIN_REDEFINIDA);

    	SimbFuncao id = new SimbFuncao(node.getNome().getText(), nivelEscopo);
        id.setTipo(TIPO_STR);
        id.setParametros(node.getPars());
        id.setComandos(node.getBloco());

        setSimbolo(getNomeFuncao(id), id);
    }

    @Override
    public void caseAFuncaoStrDeclaracao(AFuncaoStrDeclaracao node) {
        inAFuncaoStrDeclaracao(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        /*{
            List<PParametro> copy = new ArrayList<PParametro>(node.getPars());
            for(PParametro e : copy) {
                e.apply(this);
            }
        }
        {
            List<PComando> copy = new ArrayList<PComando>(node.getBloco());
            for(PComando e : copy) {
                e.apply(this);
            }
        }*/
        outAFuncaoStrDeclaracao(node);
    }

    public void inAFuncaoMain(AFuncaoMain node) {
        nivelEscopo++;
    }

    public void outAFuncaoMain(AFuncaoMain node) {
        if (!node.getNome().getText().equals("main"))
        	gerarErro(FUNCAO_MAIN_NOME);
        
    	nivelEscopo--;
    }

	@Override
    public void caseAFuncaoMain(AFuncaoMain node) {
        inAFuncaoMain(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        {
            List<PComando> copy = new ArrayList<PComando>(node.getBloco());
            for(PComando e : copy) {
                e.apply(this);
            }
        }
        outAFuncaoMain(node);
    }

    public void inAParamVarIntParametro(AParamVarIntParametro node) {
        defaultIn(node);
    }

    public void outAParamVarIntParametro(AParamVarIntParametro node) {
        defaultOut(node);
    }

    @Override
    public void caseAParamVarIntParametro(AParamVarIntParametro node) {
        inAParamVarIntParametro(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outAParamVarIntParametro(node);
    }

    public void inAParamVarStrParametro(AParamVarStrParametro node) {
        defaultIn(node);
    }

    public void outAParamVarStrParametro(AParamVarStrParametro node) {
        defaultOut(node);
    }

    @Override
    public void caseAParamVarStrParametro(AParamVarStrParametro node) {
        inAParamVarStrParametro(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outAParamVarStrParametro(node);
    }

    public void inAParamMatrizIntParametro(AParamMatrizIntParametro node) {
        defaultIn(node);
    }

    public void outAParamMatrizIntParametro(AParamMatrizIntParametro node) {
        defaultOut(node);
    }

    @Override
    public void caseAParamMatrizIntParametro(AParamMatrizIntParametro node) {
        inAParamMatrizIntParametro(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outAParamMatrizIntParametro(node);
    }

    public void inAParamMatrizStrParametro(AParamMatrizStrParametro node) {
        defaultIn(node);
    }

    public void outAParamMatrizStrParametro(AParamMatrizStrParametro node) {
        defaultOut(node);
    }

    @Override
    public void caseAParamMatrizStrParametro(AParamMatrizStrParametro node) {
        inAParamMatrizStrParametro(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outAParamMatrizStrParametro(node);
    }

    public void inABlocoComando(ABlocoComando node) {
        defaultIn(node);
    }

    public void outABlocoComando(ABlocoComando node) {
        defaultOut(node);
    }

    @Override
    public void caseABlocoComando(ABlocoComando node) {
        inABlocoComando(node);
        {
            List<PComando> copy = new ArrayList<PComando>(node.getComando());
            for(PComando e : copy) {
                e.apply(this);
            }
        }
        outABlocoComando(node);
    }

    public void inADeclVarIntComando(ADeclVarIntComando node) {
        defaultIn(node);
    }

    public void outADeclVarIntComando(ADeclVarIntComando node) {
        defaultOut(node);
    }

    @Override
    public void caseADeclVarIntComando(ADeclVarIntComando node) {
        inADeclVarIntComando(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outADeclVarIntComando(node);
    }

    public void inADeclVarStrComando(ADeclVarStrComando node) {
        defaultIn(node);
    }

    public void outADeclVarStrComando(ADeclVarStrComando node) {
        defaultOut(node);
    }

    @Override
    public void caseADeclVarStrComando(ADeclVarStrComando node) {
        inADeclVarStrComando(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outADeclVarStrComando(node);
    }

    public void inADeclMatrizIntComando(ADeclMatrizIntComando node) {
        defaultIn(node);
    }

    public void outADeclMatrizIntComando(ADeclMatrizIntComando node) {
        defaultOut(node);
    }

    @Override
    public void caseADeclMatrizIntComando(ADeclMatrizIntComando node) {
        inADeclMatrizIntComando(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        if(node.getDimen() != null) {
            node.getDimen().apply(this);
        }
        outADeclMatrizIntComando(node);
    }

    public void inADeclMatrizStrComando(ADeclMatrizStrComando node) {
        defaultIn(node);
    }

    public void outADeclMatrizStrComando(ADeclMatrizStrComando node) {
        defaultOut(node);
    }

    @Override
    public void caseADeclMatrizStrComando(ADeclMatrizStrComando node) {
        inADeclMatrizStrComando(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        if(node.getDimen() != null) {
            node.getDimen().apply(this);
        }
        outADeclMatrizStrComando(node);
    }

    public void inAAtribuicaoComando(AAtribuicaoComando node) {
        defaultIn(node);
    }

    public void outAAtribuicaoComando(AAtribuicaoComando node) {
        defaultOut(node);
    }

    @Override
    public void caseAAtribuicaoComando(AAtribuicaoComando node) {
        inAAtribuicaoComando(node);
        if(node.getValor() != null) {
            node.getValor().apply(this);
        }
        outAAtribuicaoComando(node);
    }

    public void inARetornoComando(ARetornoComando node) {
        defaultIn(node);
    }

    public void outARetornoComando(ARetornoComando node) {
        defaultOut(node);
    }

    @Override
    public void caseARetornoComando(ARetornoComando node) {
        inARetornoComando(node);
        if(node.getValor() != null) {
            node.getValor().apply(this);
        }
        outARetornoComando(node);
    }

    public void inARepeticaoComando(ARepeticaoComando node) {
        defaultIn(node);
    }

    public void outARepeticaoComando(ARepeticaoComando node) {
        defaultOut(node);
    }

    @Override
    public void caseARepeticaoComando(ARepeticaoComando node) {
        inARepeticaoComando(node);
        if(node.getTeste() != null) {
            node.getTeste().apply(this);
        }
        if(node.getBloco() != null) {
            node.getBloco().apply(this);
        }
        outARepeticaoComando(node);
    }

    public void inACondicaoComando(ACondicaoComando node) {
        defaultIn(node);
    }

    public void outACondicaoComando(ACondicaoComando node) {
        defaultOut(node);
    }

    @Override
    public void caseACondicaoComando(ACondicaoComando node) {
        inACondicaoComando(node);
        if(node.getTeste() != null) {
            node.getTeste().apply(this);
        }
        if(node.getBlocoThen() != null) {
            node.getBlocoThen().apply(this);
        }
        if(node.getBlocoElse() != null) {
            node.getBlocoElse().apply(this);
        }
        outACondicaoComando(node);
    }

    public void inAAtribuicaoVarExp(AAtribuicaoVarExp node) {
        defaultIn(node);
    }

    public void outAAtribuicaoVarExp(AAtribuicaoVarExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAAtribuicaoVarExp(AAtribuicaoVarExp node) {
        inAAtribuicaoVarExp(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        if(node.getValor() != null) {
            node.getValor().apply(this);
        }
        outAAtribuicaoVarExp(node);
    }

    public void inAAtribuicaoMatrizExp(AAtribuicaoMatrizExp node) {
        defaultIn(node);
    }

    public void outAAtribuicaoMatrizExp(AAtribuicaoMatrizExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAAtribuicaoMatrizExp(AAtribuicaoMatrizExp node) {
        inAAtribuicaoMatrizExp(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        if(node.getIndice() != null) {
            node.getIndice().apply(this);
        }
        if(node.getValor() != null) {
            node.getValor().apply(this);
        }
        outAAtribuicaoMatrizExp(node);
    }

    public void inAMaiorQueExp(AMaiorQueExp node) {
        defaultIn(node);
    }

    public void outAMaiorQueExp(AMaiorQueExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorQueExp(AMaiorQueExp node) {
        inAMaiorQueExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outAMaiorQueExp(node);
    }

    public void inAMaiorIgualExp(AMaiorIgualExp node) {
        defaultIn(node);
    }

    public void outAMaiorIgualExp(AMaiorIgualExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorIgualExp(AMaiorIgualExp node) {
        inAMaiorIgualExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outAMaiorIgualExp(node);
    }

    public void inAMenorQueExp(AMenorQueExp node) {
        defaultIn(node);
    }

    public void outAMenorQueExp(AMenorQueExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAMenorQueExp(AMenorQueExp node) {
        inAMenorQueExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outAMenorQueExp(node);
    }

    public void inAMenorIgualExp(AMenorIgualExp node) {
        defaultIn(node);
    }

    public void outAMenorIgualExp(AMenorIgualExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAMenorIgualExp(AMenorIgualExp node) {
        inAMenorIgualExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outAMenorIgualExp(node);
    }

    public void inAIgualExp(AIgualExp node) {
        defaultIn(node);
    }

    public void outAIgualExp(AIgualExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAIgualExp(AIgualExp node) {
        inAIgualExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outAIgualExp(node);
    }

    public void inADiferenteExp(ADiferenteExp node) {
        defaultIn(node);
    }

    public void outADiferenteExp(ADiferenteExp node) {
        defaultOut(node);
    }

    @Override
    public void caseADiferenteExp(ADiferenteExp node) {
        inADiferenteExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outADiferenteExp(node);
    }

    public void inASomaExp(ASomaExp node) {
        defaultIn(node);
    }

    public void outASomaExp(ASomaExp node) {
        defaultOut(node);
    }

    @Override
    public void caseASomaExp(ASomaExp node) {
        inASomaExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outASomaExp(node);
    }

    public void inASubExp(ASubExp node) {
        defaultIn(node);
    }

    public void outASubExp(ASubExp node) {
        defaultOut(node);
    }

    @Override
    public void caseASubExp(ASubExp node) {
        inASubExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outASubExp(node);
    }

    public void inAMultExp(AMultExp node) {
        defaultIn(node);
    }

    public void outAMultExp(AMultExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAMultExp(AMultExp node) {
        inAMultExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outAMultExp(node);
    }

    public void inADivExp(ADivExp node) {
        defaultIn(node);
    }

    public void outADivExp(ADivExp node) {
        defaultOut(node);
    }

    @Override
    public void caseADivExp(ADivExp node) {
        inADivExp(node);
        if(node.getEsq() != null) {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null) {
            node.getDir().apply(this);
        }
        outADivExp(node);
    }

    public void inAVarExp(AVarExp node) {
        defaultIn(node);
    }

    public void outAVarExp(AVarExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAVarExp(AVarExp node) {
        inAVarExp(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        outAVarExp(node);
    }

    public void inAMatrizExp(AMatrizExp node) {
        defaultIn(node);
    }

    public void outAMatrizExp(AMatrizExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAMatrizExp(AMatrizExp node) {
        inAMatrizExp(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        if(node.getIndice() != null) {
            node.getIndice().apply(this);
        }
        outAMatrizExp(node);
    }

    public void inANumExp(ANumExp node) {
        defaultIn(node);
    }

    public void outANumExp(ANumExp node) {
        defaultOut(node);
    }

    @Override
    public void caseANumExp(ANumExp node) {
        inANumExp(node);
        if(node.getNum() != null) {
            node.getNum().apply(this);
        }
        outANumExp(node);
    }

    public void inAStrExp(AStrExp node) {
        defaultIn(node);
    }

    public void outAStrExp(AStrExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAStrExp(AStrExp node) {
        inAStrExp(node);
        if(node.getStr() != null) {
            node.getStr().apply(this);
        }
        outAStrExp(node);
    }

    public void inAFuncaoExp(AFuncaoExp node) {
        defaultIn(node);
    }

    public void outAFuncaoExp(AFuncaoExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAFuncaoExp(AFuncaoExp node) {
        inAFuncaoExp(node);
        if(node.getNome() != null) {
            node.getNome().apply(this);
        }
        {
            List<PExp> copy = new ArrayList<PExp>(node.getArgs());
            for(PExp e : copy) {
                e.apply(this);
            }
        }
        outAFuncaoExp(node);
    }
    
    private void armazenarSimbolosDaLinguagem() {
    	setSimbolo(TIPO_INT + "input()", null);
    	setSimbolo(TIPO_STR + "input()", null);
    	setSimbolo(TIPO_VOID + "output(" + TIPO_INT + ")", null);
    	setSimbolo(TIPO_VOID + "output(" + TIPO_STR + ")", null);
    }
    
    private String getNomeFuncao(SimbFuncao simbFuncao) {
    	StringBuilder nome = new StringBuilder();
    	nome.append(simbFuncao.getTipo());
    	nome.append(simbFuncao.getNome());
    	nome.append("(");
    	for (PParametro parametro : simbFuncao.getParametros()) {
			if (parametro instanceof AParamVarIntParametro)
				nome.append(TIPO_INT);
			else if (parametro instanceof AParamMatrizIntParametro)
				nome.append(TIPO_INT + "[]");
			else if (parametro instanceof AParamVarStrParametro)
				nome.append(TIPO_STR);
			else if (parametro instanceof AParamMatrizStrParametro)
				nome.append(TIPO_STR + "[]");
		}
    	nome.append(")");

    	return nome.toString();
    }
    
    private void gerarErro(int idErro) {
		// TODO MENSAGENS DE ERRO	
	}
}
