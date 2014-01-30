/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.analysis;

import compiladorCMenos.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAPrograma(APrograma node);
    void caseASeqDeclaracao(ASeqDeclaracao node);
    void caseADeclFuncaoMain(ADeclFuncaoMain node);
    void caseAVariavelDeclaracao(AVariavelDeclaracao node);
    void caseAFuncaoDeclaracao(AFuncaoDeclaracao node);
    void caseAVariavelDeclVariavel(AVariavelDeclVariavel node);
    void caseAMatrizDeclVariavel(AMatrizDeclVariavel node);
    void caseANormalDeclFuncao(ANormalDeclFuncao node);
    void caseASemParametroDeclFuncao(ASemParametroDeclFuncao node);
    void caseAValoradoTipo(AValoradoTipo node);
    void caseAAvaloradoTipo(AAvaloradoTipo node);
    void caseAIntTipoValorado(AIntTipoValorado node);
    void caseAStringTipoValorado(AStringTipoValorado node);
    void caseATipoAvalorado(ATipoAvalorado node);
    void caseAListaSeqDeclParametro(AListaSeqDeclParametro node);
    void caseAUnicoSeqDeclParametro(AUnicoSeqDeclParametro node);
    void caseAVariavelDeclParametro(AVariavelDeclParametro node);
    void caseAMatrizDeclParametro(AMatrizDeclParametro node);
    void caseABloco(ABloco node);
    void caseASeqComando(ASeqComando node);
    void caseASemSubComandoComando(ASemSubComandoComando node);
    void caseARepeticaoComando(ARepeticaoComando node);
    void caseACondicaoComando(ACondicaoComando node);
    void caseACondicaoElseComando(ACondicaoElseComando node);
    void caseASemSubComandoComandoIfNaoCurto(ASemSubComandoComandoIfNaoCurto node);
    void caseARepeticaoIfNaoCurtoComandoIfNaoCurto(ARepeticaoIfNaoCurtoComandoIfNaoCurto node);
    void caseACondicaoElseIfNaoCurtoComandoIfNaoCurto(ACondicaoElseIfNaoCurtoComandoIfNaoCurto node);
    void caseABlocoSemSubComando(ABlocoSemSubComando node);
    void caseADeclaracaoSemSubComando(ADeclaracaoSemSubComando node);
    void caseAAtribuicaoSemSubComando(AAtribuicaoSemSubComando node);
    void caseAFuncaoSemSubComando(AFuncaoSemSubComando node);
    void caseARetornoSemSubComando(ARetornoSemSubComando node);
    void caseAVariavelComandoAtribuicao(AVariavelComandoAtribuicao node);
    void caseAMatrizComandoAtribuicao(AMatrizComandoAtribuicao node);
    void caseAComandoRepeticao(AComandoRepeticao node);
    void caseAComandoCondicao(AComandoCondicao node);
    void caseAComandoCondicaoElse(AComandoCondicaoElse node);
    void caseAComandoRepeticaoIfNaoCurto(AComandoRepeticaoIfNaoCurto node);
    void caseAComandoCondicaoElseIfNaoCurto(AComandoCondicaoElseIfNaoCurto node);
    void caseAComandoFuncao(AComandoFuncao node);
    void caseAListaSeqParametro(AListaSeqParametro node);
    void caseAUnicoSeqParametro(AUnicoSeqParametro node);
    void caseAComandoRetorno(AComandoRetorno node);
    void caseAOpBoolExpGeral(AOpBoolExpGeral node);
    void caseAExpExpGeral(AExpExpGeral node);
    void caseAOpSomaExp(AOpSomaExp node);
    void caseATermoExp(ATermoExp node);
    void caseAOpMultTermo(AOpMultTermo node);
    void caseAFatorTermo(AFatorTermo node);
    void caseAIdFator(AIdFator node);
    void caseANumFator(ANumFator node);
    void caseAStrFator(AStrFator node);
    void caseAFuncaoFator(AFuncaoFator node);
    void caseAParFator(AParFator node);
    void caseAMaiorQueOpBool(AMaiorQueOpBool node);
    void caseAMaiorOuIgualOpBool(AMaiorOuIgualOpBool node);
    void caseAMenorQueOpBool(AMenorQueOpBool node);
    void caseAMenorOuIgualOpBool(AMenorOuIgualOpBool node);
    void caseAIgualOpBool(AIgualOpBool node);
    void caseADiferenteOpBool(ADiferenteOpBool node);
    void caseASomaOpSoma(ASomaOpSoma node);
    void caseASubOpSoma(ASubOpSoma node);
    void caseAMultOpMult(AMultOpMult node);
    void caseADivOpMult(ADivOpMult node);

    void caseTBranco(TBranco node);
    void caseTPChaveElse(TPChaveElse node);
    void caseTPChaveIf(TPChaveIf node);
    void caseTPChaveInt(TPChaveInt node);
    void caseTPChaveString(TPChaveString node);
    void caseTPChaveReturn(TPChaveReturn node);
    void caseTPChaveVoid(TPChaveVoid node);
    void caseTPChaveWhile(TPChaveWhile node);
    void caseTId(TId node);
    void caseTNum(TNum node);
    void caseTStr(TStr node);
    void caseTSoma(TSoma node);
    void caseTSub(TSub node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTMenor(TMenor node);
    void caseTMaior(TMaior node);
    void caseTMenorI(TMenorI node);
    void caseTMaiorI(TMaiorI node);
    void caseTIgual(TIgual node);
    void caseTDif(TDif node);
    void caseTAtrib(TAtrib node);
    void caseTPVirg(TPVirg node);
    void caseTVirg(TVirg node);
    void caseTAPar(TAPar node);
    void caseTFPar(TFPar node);
    void caseTACol(TACol node);
    void caseTFCol(TFCol node);
    void caseTAChave(TAChave node);
    void caseTFChave(TFChave node);
    void caseTComentLinha(TComentLinha node);
    void caseTComentAnin(TComentAnin node);
    void caseTFComentAnin(TFComentAnin node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
