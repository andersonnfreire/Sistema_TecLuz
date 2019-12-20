
package cdp;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance ( strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String email;
    private String telefone;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Cep cep;

    public Pessoa() {
    }

    public Pessoa(int codigo, String email, String telefone, Cep cep) {
        this.codigo = codigo;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Pessoa(String email, String telefone, Cep cep) {
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }
    
}
