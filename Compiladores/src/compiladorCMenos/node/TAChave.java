/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiladorCMenos.node;

import compiladorCMenos.analysis.*;

@SuppressWarnings("nls")
public final class TAChave extends Token
{
    public TAChave()
    {
        super.setText("{");
    }

    public TAChave(int line, int pos)
    {
        super.setText("{");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TAChave(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAChave(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TAChave text.");
    }
}
