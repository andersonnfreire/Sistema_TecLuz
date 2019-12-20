package cdp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anderson
 */
@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    
    private double valorTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    Fisico fisico;
    
    @OneToMany(mappedBy = "venda", fetch = FetchType.EAGER)
    List<ItemVenda> itemVenda;
    
    private String valorUnitario;

    public Venda() {
        itemVenda = new ArrayList();
    }   

    public Venda(Date date) {
        this.dataCompra = date;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fisico getFisico() {
        return fisico;
    }

    public void setFisico(Fisico fisico) {
        this.fisico = fisico;
    }

    public List<ItemVenda> getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(List<ItemVenda> itemVenda) {
        this.itemVenda = itemVenda;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return String.valueOf(valorTotal);
    }
        public Object[] toArray()
    {
        return new Object[]
        {
            getFisico(), this
        };
    }

}
