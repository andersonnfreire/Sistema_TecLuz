package cih;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson
 */
public class ClasseErro
{
    private final Object obj;

    public ClasseErro(Object obj)
    {
        this.obj = obj;
    }
    

    public void exibir( String mensagem)
    {
        JOptionPane.showMessageDialog((Component)obj, mensagem);

    }

}
