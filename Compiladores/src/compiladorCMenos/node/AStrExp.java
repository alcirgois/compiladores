/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class AStrExp extends PExp
{
    private TStr _str_;

    public AStrExp()
    {
        // Constructor
    }

    public AStrExp(
        @SuppressWarnings("hiding") TStr _str_)
    {
        // Constructor
        setStr(_str_);

    }

    @Override
    public Object clone()
    {
        return new AStrExp(
            cloneNode(this._str_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStrExp(this);
    }

    public TStr getStr()
    {
        return this._str_;
    }

    public void setStr(TStr node)
    {
        if(this._str_ != null)
        {
            this._str_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._str_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._str_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._str_ == child)
        {
            this._str_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._str_ == oldChild)
        {
            setStr((TStr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
