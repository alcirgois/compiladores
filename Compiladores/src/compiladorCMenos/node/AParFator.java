/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class AParFator extends PFator
{
    private TAPar _aPar_;
    private PExpGeral _exp_;
    private TFPar _fPar_;

    public AParFator()
    {
        // Constructor
    }

    public AParFator(
        @SuppressWarnings("hiding") TAPar _aPar_,
        @SuppressWarnings("hiding") PExpGeral _exp_,
        @SuppressWarnings("hiding") TFPar _fPar_)
    {
        // Constructor
        setAPar(_aPar_);

        setExp(_exp_);

        setFPar(_fPar_);

    }

    @Override
    public Object clone()
    {
        return new AParFator(
            cloneNode(this._aPar_),
            cloneNode(this._exp_),
            cloneNode(this._fPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParFator(this);
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

    public PExpGeral getExp()
    {
        return this._exp_;
    }

    public void setExp(PExpGeral node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._aPar_)
            + toString(this._exp_)
            + toString(this._fPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._aPar_ == child)
        {
            this._aPar_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._fPar_ == child)
        {
            this._fPar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._aPar_ == oldChild)
        {
            setAPar((TAPar) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExpGeral) newChild);
            return;
        }

        if(this._fPar_ == oldChild)
        {
            setFPar((TFPar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
