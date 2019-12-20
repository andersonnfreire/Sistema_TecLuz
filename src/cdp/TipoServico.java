
package cdp;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Anderson
 */
@Entity
public class TipoServico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nome;

    //@OneToMany( mappedBy = "TipoServico", fetch = FetchType.LAZY)
    //private List<Servico> servico;

       
    public TipoServico() {
    }

    public TipoServico(String nome) {
        this.nome = nome;
    }

    public TipoServico(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
//    public List<Servico> getServico() {
//        return servico;
//    }
//
//    public void setServico(List<Servico> servico) {
//        this.servico = servico;
//    }
    
    @Override
    public String toString()
    {
        return getNome();
    }
    
}
