
package cdp;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
    private String ramoTrabalho;
    
    public Fisico() {
        super();
    }
    public Fisico(String nome, String CPF, String Sexo, Date dataNasc, String ramoTrabalho, int codigo, String email, String telefone, Cep cep) {
        super(codigo, email, telefone, cep);
        this.nome = nome;
        this.CPF = CPF;
        this.Sexo = Sexo;
        this.dataNasc = dataNasc;
        this.ramoTrabalho = ramoTrabalho;
    }

    public Fisico(String nome, String CPF, String Sexo, Date dataNasc, String ramoTrabalho, String email, String telefone, Cep cep) {
        super(email, telefone, cep);
        this.nome = nome;
        this.CPF = CPF;
        this.Sexo = Sexo;
        this.dataNasc = dataNasc;
        this.ramoTrabalho = ramoTrabalho;
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
    @Override
    public String toString()
    {
        return getNome();
    }
    public Object[] toArray()
    {
        return new Object[]
        {
            this, CPF, getDataNasc()
        };
    }
}
