
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
public class ItemVenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private int quantidade;
    
    private double preco;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Materiais mat;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Venda venda;
    

    public ItemVenda() {
    }

    public ItemVenda(int quantidade, Materiais mat, Venda venda,double preco) {
        this.quantidade = quantidade;
        this.mat = mat;
        this.venda = venda;
    }

    public ItemVenda(int codigo, int quantidade, Materiais mat, Venda venda,double preco) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.mat = mat;
        this.venda = venda;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Materiais getMat() {
        return mat;
    }

    public void setMat(Materiais mat) {
        this.mat = mat;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
}
