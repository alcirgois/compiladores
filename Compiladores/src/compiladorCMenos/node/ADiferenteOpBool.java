/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class ADiferenteOpBool extends POpBool
{
    private TDif _dif_;

    public ADiferenteOpBool()
    {
        // Constructor
    }

    public ADiferenteOpBool(
        @SuppressWarnings("hiding") TDif _dif_)
    {
        // Constructor
        setDif(_dif_);

    }

    @Override
    public Object clone()
    {
        return new ADiferenteOpBool(
            cloneNode(this._dif_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADiferenteOpBool(this);
    }

    public TDif getDif()
    {
        return this._dif_;
    }

    public void setDif(TDif node)
    {
        if(this._dif_ != null)
        {
            this._dif_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dif_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._dif_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dif_ == child)
        {
            this._dif_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._dif_ == oldChild)
        {
            setDif((TDif) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}