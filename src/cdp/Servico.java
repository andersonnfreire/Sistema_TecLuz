
package cdp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anderson
 */
@Entity
public class Servico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    private String status;
    
    private String tipServico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Veiculos vei;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Fisico fis;
    
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Temporal(TemporalType.DATE)
    private Date previsaoDataFim;
    
    private String extensaoRede;
    private String distancia;
    private double valorTotal;

    public Servico() {
        
    }

    public Servico(int codigo,Fisico fis, String ser,String sts, Veiculos vei,Date dataInicio, Date previsaoDataFim, String extensaoRede, String distancia, double valorTotal) {
        this.fis = fis;
        this.tipServico = ser;
        this.status = sts;
        this.vei = vei;
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.previsaoDataFim = previsaoDataFim;
        this.extensaoRede = extensaoRede;
        this.distancia = distancia;
        this.valorTotal = valorTotal;
    }

    public Servico(Fisico fis, String ser,String sts, Veiculos vei,Date dataInicio, Date previsaoDataFim, String extensaoRede, String distancia, double valorTotal) {
        
        this.tipServico = ser;
        this.status = sts;
        this.vei = vei;
        this.fis = fis;
        this.dataInicio = dataInicio;
        this.previsaoDataFim = previsaoDataFim;
        this.extensaoRede = extensaoRede;
        this.distancia = distancia;
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipServico() {
        return tipServico;
    }

    public void setTipServico(String tipServico) {
        this.tipServico = tipServico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Veiculos getVei() {
        return vei;
    }

    public void setVei(Veiculos vei) {
        this.vei = vei;
    }

    public Fisico getFis() {
        return fis;
    }

    public void setFis(Fisico fis) {
        this.fis = fis;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getPrevisaoDataFim() {
        return previsaoDataFim;
    }

    public void setPrevisaoDataFim(Date previsaoDataFim) {
        this.previsaoDataFim = previsaoDataFim;
    }

    public String getExtensaoRede() {
        return extensaoRede;
    }

    public void setExtensaoRede(String extensaoRede) {
        this.extensaoRede = extensaoRede;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Object[] toArray() {
        return new Object[] {this, tipServico};
    }
  
}
