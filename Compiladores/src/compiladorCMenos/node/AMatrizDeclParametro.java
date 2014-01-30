/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import java.util.*;
import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class AMatrizDeclParametro extends PDeclParametro
{
    private PTipoValorado _tipo_;
    private final LinkedList<TMult> _dimens_ = new LinkedList<TMult>();
    private TId _nome_;

    public AMatrizDeclParametro()
    {
        // Constructor
    }

    public AMatrizDeclParametro(
        @SuppressWarnings("hiding") PTipoValorado _tipo_,
        @SuppressWarnings("hiding") List<?> _dimens_,
        @SuppressWarnings("hiding") TId _nome_)
    {
        // Constructor
        setTipo(_tipo_);

        setDimens(_dimens_);

        setNome(_nome_);

    }

    @Override
    public Object clone()
    {
        return new AMatrizDeclParametro(
            cloneNode(this._tipo_),
            cloneList(this._dimens_),
            cloneNode(this._nome_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMatrizDeclParametro(this);
    }

    public PTipoValorado getTipo()
    {
        return this._tipo_;
    }

    public void setTipo(PTipoValorado node)
    {
        if(this._tipo_ != null)
        {
            this._tipo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tipo_ = node;
    }

    public LinkedList<TMult> getDimens()
    {
        return this._dimens_;
    }

    public void setDimens(List<?> list)
    {
        for(TMult e : this._dimens_)
        {
            e.parent(null);
        }
        this._dimens_.clear();

        for(Object obj_e : list)
        {
            TMult e = (TMult) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._dimens_.add(e);
        }
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
            + toString(this._tipo_)
            + toString(this._dimens_)
            + toString(this._nome_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tipo_ == child)
        {
            this._tipo_ = null;
            return;
        }

        if(this._dimens_.remove(child))
        {
            return;
        }

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
        if(this._tipo_ == oldChild)
        {
            setTipo((PTipoValorado) newChild);
            return;
        }

        for(ListIterator<TMult> i = this._dimens_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((TMult) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._nome_ == oldChild)
        {
            setNome((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
