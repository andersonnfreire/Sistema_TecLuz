package cdp;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Anderson
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Juridico extends Pessoa {

    private String CNPJ;
    private String razaoSocial;

    public Juridico() {
        super();
    }

    public Juridico(String email, String telefone,int codigo,String CNPJ, String razaoSocial,Cep cep) {
        super(codigo, email, telefone, cep);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
    }

    public Juridico(String email, String telefone,String CNPJ, String razaoSocial, Cep cep) {
        super(email, telefone, cep);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
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

    @Override
    public String toString() {
        return getCNPJ();
    }
    public Object[] toArray()
    {
        return new Object[]
        {
            this, getCNPJ(), this,getRazaoSocial()
        };
    }
    

  
}
