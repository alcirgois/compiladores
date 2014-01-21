/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.analysis;

import compiladorCMenos.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

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
