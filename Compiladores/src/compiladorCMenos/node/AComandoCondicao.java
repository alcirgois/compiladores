/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class AComandoCondicao extends PComandoCondicao
{
    private TPChaveIf _pChaveIf_;
    private TAPar _aPar_;
    private PExpGeral _condicao_;
    private TFPar _fPar_;
    private PComando _thenComandos_;

    public AComandoCondicao()
    {
        // Constructor
    }

    public AComandoCondicao(
        @SuppressWarnings("hiding") TPChaveIf _pChaveIf_,
        @SuppressWarnings("hiding") TAPar _aPar_,
        @SuppressWarnings("hiding") PExpGeral _condicao_,
        @SuppressWarnings("hiding") TFPar _fPar_,
        @SuppressWarnings("hiding") PComando _thenComandos_)
    {
        // Constructor
        setPChaveIf(_pChaveIf_);

        setAPar(_aPar_);

        setCondicao(_condicao_);

        setFPar(_fPar_);

        setThenComandos(_thenComandos_);

    }

    @Override
    public Object clone()
    {
        return new AComandoCondicao(
            cloneNode(this._pChaveIf_),
            cloneNode(this._aPar_),
            cloneNode(this._condicao_),
            cloneNode(this._fPar_),
            cloneNode(this._thenComandos_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComandoCondicao(this);
    }

    public TPChaveIf getPChaveIf()
    {
        return this._pChaveIf_;
    }

    public void setPChaveIf(TPChaveIf node)
    {
        if(this._pChaveIf_ != null)
        {
            this._pChaveIf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pChaveIf_ = node;
    }

    public TAPar getAPar()
    {
        return this._aPar_;
    }

    public void setAPar(TAPar node)
    {
        if(this._aPar_ != null)
        {
            this._aPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aPar_ = node;
    }

    public PExpGeral getCondicao()
    {
        return this._condicao_;
    }

    public void setCondicao(PExpGeral node)
    {
        if(this._condicao_ != null)
        {
            this._condicao_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._condicao_ = node;
    }

    public TFPar getFPar()
    {
        return this._fPar_;
    }

    public void setFPar(TFPar node)
    {
        if(this._fPar_ != null)
        {
            this._fPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fPar_ = node;
    }

    public PComando getThenComandos()
    {
        return this._thenComandos_;
    }

    public void setThenComandos(PComando node)
    {
        if(this._thenComandos_ != null)
        {
            this._thenComandos_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._thenComandos_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._pChaveIf_)
            + toString(this._aPar_)
            + toString(this._condicao_)
            + toString(this._fPar_)
            + toString(this._thenComandos_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._pChaveIf_ == child)
        {
            this._pChaveIf_ = null;
            return;
        }

        if(this._aPar_ == child)
        {
            this._aPar_ = null;
            return;
        }

        if(this._condicao_ == child)
        {
            this._condicao_ = null;
            return;
        }

        if(this._fPar_ == child)
        {
            this._fPar_ = null;
            return;
        }

        if(this._thenComandos_ == child)
        {
            this._thenComandos_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._pChaveIf_ == oldChild)
        {
            setPChaveIf((TPChaveIf) newChild);
            return;
        }

        if(this._aPar_ == oldChild)
        {
            setAPar((TAPar) newChild);
            return;
        }

        if(this._condicao_ == oldChild)
        {
            setCondicao((PExpGeral) newChild);
            return;
        }

        if(this._fPar_ == oldChild)
        {
            setFPar((TFPar) newChild);
            return;
        }

        if(this._thenComandos_ == oldChild)
        {
            setThenComandos((PComando) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
