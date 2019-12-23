
package cci;

import cdp.Cep;
import cdp.Endereco;
import dao.ClienteDAO;
import dao.GenericDAO;
import cdp.Fisico;
import cdp.Juridico;
import cdp.Materiais;
import cdp.Servico;
import cdp.Veiculos;
import cih.JFramePrincipal;
import dao.FornecedorDAO;
import dao.MateriaisDAO;
import dao.ServicoDAO;
import dao.VeiculoDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1547816
 */
public class GerenciadorCDP {

    GenericDAO genDAO;
    ClienteDAO cliDAO;
    FornecedorDAO forDAO;
    VeiculoDAO veiDAO;
    MateriaisDAO matDAO;
    ServicoDAO serDAO;

    public GerenciadorCDP() throws ClassNotFoundException, SQLException {

        genDAO = new GenericDAO();
        cliDAO = new ClienteDAO();
        forDAO = new FornecedorDAO();
        veiDAO = new VeiculoDAO();
        matDAO = new MateriaisDAO();
        serDAO = new ServicoDAO();
    }
    
    // INSERIR, ALTERAR, PESQUISAR o CLIENTE FISICO
    public int inserirPessoaF(String nome, String CPF, String Sexo, Date dataNasc, String ramoTrabalho,
            String email, String telefone, String logradouro, String complemento, String numero,
            String bairro, String cidade, String estado, String cep)
            throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco(logradouro, complemento, numero, bairro, cidade, estado);
        Cep objCep = new Cep(cep, objEndereco);
        Fisico objCli = new Fisico(nome, CPF, Sexo, dataNasc, ramoTrabalho, email, telefone, objCep);
  
        genDAO.inserir(objEndereco);
        
        genDAO.inserir(objCep);
          
        genDAO.inserir(objCli);

        return objCli.getCodigo();

    }

    public int alterarPessoaF(int id, String nome, String CPF, String Sexo, Date dataNasc, String ramoTrabalho,
            String email, String telefone, String logradouro, String complemento, String numero,
            String bairro, String cidade, String estado, String cep) throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco(logradouro, complemento, numero, bairro, cidade, estado);
        Cep objCep = new Cep(cep, objEndereco);
        Fisico objCli = new Fisico(nome, CPF, Sexo, dataNasc, ramoTrabalho, email, telefone, objCep);

        genDAO.alterar(objEndereco);
        
        genDAO.alterar(objCep);
        
        genDAO.alterar(objCli);
        
        
        return objCli.getCodigo();
    }
   
    public void pesquisarCliente(JTable tabela, String pesq) throws SQLException
    {

        List lista = null;
        Fisico fisico;

        // APAGAR a TABELA
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);

        lista = cliDAO.pesquisarPorNome(pesq);

        Iterator<Fisico> it = lista.iterator();
        while (it.hasNext())
        {
            fisico = it.next();
            ((DefaultTableModel) tabela.getModel()).addRow(fisico.toArray());
        }
    }
    
    
    // INSERIR, ALTERAR, PESQUISAR o CLIENTE JURIDICO
    public int inserirPessoaJ(String CNPJ,String razaoSocial,
            String email, String telefone, String logradouro, String complemento, String numero,
            String bairro, String cidade, String estado, String cep)
            throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco(logradouro, complemento, numero, bairro, cidade, estado);

        Cep objCep = new Cep(cep, objEndereco);
        Juridico objCliJ = new Juridico(CNPJ, razaoSocial, email,telefone, objCep);

        genDAO.inserir(objEndereco);
        
        genDAO.inserir(objCep);
    
        genDAO.inserir(objCliJ);
        
        return objCliJ.getCodigo();

    }

    public int alterarPessoaJ(int id, String CNPJ,String razaoSocial,
            String email, String telefone, String logradouro, String complemento, String numero,
            String bairro, String cidade, String estado, String cep) throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco(logradouro, complemento, numero, bairro, cidade, estado);
        Cep objCep = new Cep(cep, objEndereco);
        Juridico objCliJ = new Juridico(CNPJ,razaoSocial, email, telefone, objCep);

        
        genDAO.alterar(objEndereco);
        
        genDAO.alterar(objCep);
        
        genDAO.alterar(objCliJ);
        return objCliJ.getCodigo();
    }
   
    public void pesquisarClienteJuridico(JTable tabela, String pesq) throws SQLException
    {

        List lista = null;
        Juridico juridico;

        // APAGAR a TABELA
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);

        lista = forDAO.pesquisarNome(pesq);

        Iterator<Juridico> it = lista.iterator();
        while (it.hasNext())
        {
            juridico = it.next();
            ((DefaultTableModel) tabela.getModel()).addRow(juridico.toArray());
        }
    }
    
 
    public int inserirMaterial(String nome,String marca,int quantidade,double valorCusto,Juridico juridico)
            throws SQLException, ClassNotFoundException {

        
        Materiais mat = new Materiais(nome, marca, quantidade, valorCusto, juridico);
  
        genDAO.inserir(mat);

        return mat.getCodigo();
    }
    
    public void pesquisarMaterial(JTable tabela, String pesq) throws SQLException
    {

        List lista = null;
        Materiais material;

        // APAGAR a TABELA
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);

        lista = matDAO.pesquisarPorNome(pesq);

        Iterator<Materiais> it = lista.iterator();
        while (it.hasNext())
        {
            material = it.next();
            ((DefaultTableModel) tabela.getModel()).addRow(material.toArray());
        }
    }
    
    
    public int inserirVeiculo(String modelo,String marca,int quant,String placa, Date dataCompra)
            throws SQLException, ClassNotFoundException {

        //System.err.println("Dados :" + modelo + marca + quant + placa+dataCompra);
        Veiculos objVei = new Veiculos(modelo, marca,quant,placa,dataCompra);

        genDAO.inserir(objVei);

        return objVei.getCodigo();

    }
    public int alterarVeiculo(int id, String modelo,String marca,int quant,String placa, Date dataCompra) 
            throws SQLException, ClassNotFoundException {

       Veiculos objVei = new Veiculos(modelo, marca,quant,placa,dataCompra);

        genDAO.alterar(objVei);
        return objVei.getCodigo();
    }
    public void pesquisarVeiculo(JTable tabela, String pesq) throws SQLException
    {

        List lista = null;
        Veiculos veiculo;

        // APAGAR a TABELA
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);

        lista = veiDAO.pesquisarPorNome(pesq);

        Iterator<Veiculos> it = lista.iterator();
        while (it.hasNext())
        {
            veiculo = it.next();
            ((DefaultTableModel) tabela.getModel()).addRow(veiculo.toArray());
        }
    }
    
    public int inserirServico(Fisico cli,String st,Veiculos veiculo,String distancia,Date dataEntrega,double valorTotal,String tipoServ)
            throws SQLException, ClassNotFoundException {

        Servico objServ = new Servico(cli, tipoServ, st, veiculo, dataEntrega, dataEntrega, distancia, distancia, valorTotal);
  
        genDAO.inserir(objServ);

        return objServ.getCodigo();

    }

    public int alterarServico(int id, String nome, String CPF, String Sexo, Date dataNasc, String ramoTrabalho,
            String email, String telefone, String logradouro, String complemento, String numero,
            String bairro, String cidade, String estado, String cep) throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco(logradouro, complemento, numero, bairro, cidade, estado);
        Cep objCep = new Cep(cep, objEndereco);
        Fisico objCli = new Fisico(nome, CPF, Sexo, dataNasc, ramoTrabalho, email, telefone, objCep);

        genDAO.alterar(objEndereco);
        
        genDAO.alterar(objCep);
        
        genDAO.alterar(objCli);
        
        
        return objCli.getCodigo();
    }
    
    public void pesquisarServico(JTable tabela, int pesq) throws SQLException
    {

        List lista = null;
        Servico serv;

        // APAGAR a TABELA
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);

        lista = serDAO.pesquisarPorCodigo(pesq);

        Iterator<Servico> it = lista.iterator();
        while (it.hasNext())
        {
            serv = it.next();
            ((DefaultTableModel) tabela.getModel()).addRow(serv.toArray());
        }
    }
   
     public List listarClientes() throws SQLException
    {
        return genDAO.listar(Fisico.class);
    }
    public List listarFornecedores() throws SQLException
    {
        return genDAO.listar(Juridico.class);
    }
    public List listaMaterial() throws SQLException
    {
        return genDAO.listar(Materiais.class);
    }
    public List listarVendas() throws SQLException
    {
        return genDAO.listar(JFramePrincipal.class);
    }

    
    /*
    public int inserirVeiculo(String modelo,String marca,int quant,String placa, Date dataCompra)
            throws SQLException, ClassNotFoundException {

        System.err.println("Dados :" + modelo + marca + quant + placa+dataCompra);
        Veiculos objVei = new Veiculos(modelo, marca,quant,placa,dataCompra);

        genDAO.inserir(objVei);

        return objVei.getCodigo();

    }
    
    */
    public void carregarCombo( Class classe, JComboBox combo) {
        
        List lista;
        lista = genDAO.listar(classe);
        combo.setModel(new DefaultComboBoxModel( lista.toArray() ) );
    }
    private Date criarData(String strData) throws Exception {
        if (strData == null || "".equals(strData)) {
            return null;
        }

        Date date = null;
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Converter de STRING para DATE
        date = formato.parse(strData);
        return date;
    }

    
}
