
package cdp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anderson
 */
@Entity
public class Veiculos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String modelo;
    private String marca;
    private int ano;
    private String placa;
    
    @Temporal(TemporalType.DATE)
    private Date dtCompra;

    public Veiculos() {
    }

    public Veiculos(String modelo, String marca, int ano, String placa, Date dtCompra) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.dtCompra = dtCompra;
    }

    public Veiculos(int codigo, String modelo, String marca, int ano, String placa, Date dtCompra) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.dtCompra = dtCompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }
    @Override
    public String toString()
    {
        return getModelo();
    }
    public Object[] toArray()
    {
        return new Object[]
        {
            this, getModelo(), this, 
        };
    }
    
}
