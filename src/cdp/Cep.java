package cdp;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Anderson
 */
@Entity
public class Cep implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String numero;

    
    @OneToOne(cascade=CascadeType.PERSIST)
    private Endereco endereco;

    public Cep()
    {

    }

    public Cep(int codigo,String numero, Endereco endereco)
    {
        this.codigo = codigo;
        this.numero = numero;
        this.endereco = endereco;
    }
    public Cep(String numero, Endereco endereco)
    {
        this.numero = numero;
        this.endereco = endereco;
    }

    public Endereco getEndereco()
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

}
