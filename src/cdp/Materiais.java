
package cdp;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Anderson
 */
@Entity
public class Materiais implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    private String nome;
    
    private String marca;
    
    private int quantidade_estoque;
    
    private double valorCusto;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Juridico jur;

    public Materiais() {
    }
    public Materiais(int codigo, String nome, String marca, int quantidade_estoque, double valorCusto, Juridico jur) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.quantidade_estoque = quantidade_estoque;
        this.valorCusto = valorCusto;
        this.jur = jur;
    }

    public Materiais(String nome, String marca, int quantidade_estoque, double valorCusto, Juridico jur) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade_estoque = quantidade_estoque;
        this.valorCusto = valorCusto;
        this.jur = jur;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Juridico getJur() {
        return jur;
    }

    public void setJur(Juridico jur) {
        this.jur = jur;
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
            this, getNome(), this, 
        };
    }

    
    
}
