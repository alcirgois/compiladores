/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class ADeclVarIntComando extends PComando
{
    private TId _nome_;

    public ADeclVarIntComando()
    {
        // Constructor
    }

    public ADeclVarIntComando(
        @SuppressWarnings("hiding") TId _nome_)
    {
        // Constructor
        setNome(_nome_);

    }

    @Override
    public Object clone()
    {
        return new ADeclVarIntComando(
            cloneNode(this._nome_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADeclVarIntComando(this);
    }

    public TId getNome()
    {
        return this._nome_;
    }

    public void setNome(TId node)
    {
        if(this._nome_ != null)
        {
            this._nome_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nome_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._nome_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._nome_ == child)
        {
            this._nome_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._nome_ == oldChild)
        {
            setNome((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
