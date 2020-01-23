package cdp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Anderson
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Juridico extends Pessoa {

    private String CNPJ;
    private String razaoSocial;

     @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Cep cep;
    
    public Juridico() {
        super();
    }

    public Juridico(int codigo,String email, String telefone,String CNPJ, String razaoSocial,Cep cep) {
        super(codigo, email, telefone);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.cep = cep;
    }

    public Juridico(String email, String telefone,String CNPJ, String razaoSocial, Cep cep) {
        super(email, telefone);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.cep = cep;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public Cep getCep()
    {
        return cep;
    }

    public void setCep(Cep cep)
    {
        this.cep = cep;
    }
    @Override
    public String toString() {
        return getCNPJ();
    }
    public int codigo()
    {
        return getCodigo();
    }
    public Object[] toArray()
    {
        return new Object[]
        {
            getCodigo(), this,getRazaoSocial()
        };
    }
    

  
}
