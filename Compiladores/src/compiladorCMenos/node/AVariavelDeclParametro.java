/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class AVariavelDeclParametro extends PDeclParametro
{
    private PTipoValorado _tipoValorado_;
    private TId _id_;

    public AVariavelDeclParametro()
    {
        // Constructor
    }

    public AVariavelDeclParametro(
        @SuppressWarnings("hiding") PTipoValorado _tipoValorado_,
        @SuppressWarnings("hiding") TId _id_)
    {
        // Constructor
        setTipoValorado(_tipoValorado_);

        setId(_id_);

    }

    @Override
    public Object clone()
    {
        return new AVariavelDeclParametro(
            cloneNode(this._tipoValorado_),
            cloneNode(this._id_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariavelDeclParametro(this);
    }

    public PTipoValorado getTipoValorado()
    {
        return this._tipoValorado_;
    }

    public void setTipoValorado(PTipoValorado node)
    {
        if(this._tipoValorado_ != null)
        {
            this._tipoValorado_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tipoValorado_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tipoValorado_)
            + toString(this._id_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tipoValorado_ == child)
        {
            this._tipoValorado_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tipoValorado_ == oldChild)
        {
            setTipoValorado((PTipoValorado) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}