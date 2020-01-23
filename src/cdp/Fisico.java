
package cdp;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Anderson
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Fisico extends Pessoa {
    
    private String nome;
    private String CPF;
    private String Sexo;
    
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Cep cep;
    
    private String ramoTrabalho;
    
    public Fisico() {
        super();
    }
    public Fisico(int codigo,String nome, String CPF, String Sexo, Date dataNasc, String ramoTrabalho, String email, String telefone, Cep cep) {
        super(codigo, email, telefone);
        this.nome = nome;
        this.CPF = CPF;
        this.Sexo = Sexo;
        this.dataNasc = dataNasc;
        this.ramoTrabalho = ramoTrabalho;
        this.cep = cep;
    }

    public Fisico(String nome, String CPF, String Sexo, Date dataNasc, String ramoTrabalho, String email, String telefone, Cep cep) {
        super(email, telefone);
        this.nome = nome;
        this.CPF = CPF;
        this.Sexo = Sexo;
        this.dataNasc = dataNasc;
        this.ramoTrabalho = ramoTrabalho;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getDataNasc() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        return formato.format(dataNasc);
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getRamoTrabalho() {
        return ramoTrabalho;
    }

    public void setRamoTrabalho(String ramoTrabalho) {
        this.ramoTrabalho = ramoTrabalho;
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
    public String toString()
    {
        return getNome();
    }
    public Object[] toArray()
    {
        return new Object[]
        {
             getCodigo(),this,getCPF(), getDataNasc(),getRamoTrabalho()
        };
    }
}
