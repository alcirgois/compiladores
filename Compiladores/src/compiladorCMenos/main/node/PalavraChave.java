package compiladorCMenos.main.node;

import compiladorCMenos.node.Switch;
import compiladorCMenos.node.TId;
import compiladorCMenos.node.Token;

@SuppressWarnings("nls")
public final class PalavraChave extends Token
{
    public PalavraChave(String text)
    {
        setText(text);
    }

    public PalavraChave(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TId(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
     //   ((Analysis) sw).casePalavraChave(this);
    }
}

