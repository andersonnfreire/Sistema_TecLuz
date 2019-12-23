/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cdp.Fisico;
import cdp.Juridico;
import cih.ClasseErro;
import cih.JDCliFor;
import cih.JDMateriais;
import cih.JDPesquisarCliente;
import cih.JDPesquisarFornecedor;
import cih.JDPesquisarMaterial;
import cih.JDPesquisarServico;
import cih.JDPesquisarVeiculo;
import cih.JDServico;
import cih.JDVeiculo;
import cih.JFramePrincipal;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public final class GerenciadorCIH {

    private GerenciadorCDP gerCDP;
    
    // Objeto de Cadastro
    private JDCliFor objClienteFornecedor;
    private JDMateriais objMateriais;
    private JDVeiculo objVeiculo;
    private JDServico objServico;
    
    // Objeto de Pesquisar
    private JDPesquisarCliente objPesqCli;
    private JDPesquisarFornecedor objPesqFor;
    private JDPesquisarVeiculo objPesqVeiculo;
    private JDPesquisarMaterial objPesqMaterial;
    private JDPesquisarServico objPesqServico;
    private JFramePrincipal objTelaPrincipal;
    private ClasseErro objClasseErro;
   
    public GerenciadorCIH() {
        try {
            gerCDP = new GerenciadorCDP();
            classeErro();

        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Classe não encontrado.");
            gerCDP = null;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO de conexão. " + erro.getMessage());
            gerCDP = null;
        }
        objClienteFornecedor = null;
        objMateriais = null;
        objVeiculo = null;
        objServico = null;
        
        objPesqCli = null;
        objPesqFor = null;
        objPesqVeiculo = null;
        objPesqMaterial = null;
        objPesqServico = null;
        
        objTelaPrincipal = null;
    }

    
  
    public GerenciadorCDP getGerCDP() {
        return gerCDP;
    }

    public void classeErro() {
        objClasseErro = new ClasseErro(objTelaPrincipal);
    }
       
    public void janelaPrincipal(){
        objTelaPrincipal = new JFramePrincipal(null, true, this, true);
        objTelaPrincipal.setVisible(true);
    }

    public void janelaCadCliente()
    {
        objClienteFornecedor = new JDCliFor(null, true, this, true);
        objClienteFornecedor.setVisible(true);
    }
    public void janelaCadMateriais()
    {
        objMateriais = new JDMateriais(null,true,this,true);
        objMateriais.setVisible(true);
    }
    public void janelaCadVeiculos()
    {
        objVeiculo = new JDVeiculo(null, true, this, true);
        objVeiculo.setVisible(true);
    }
    public void janelaCadServico()
    {
        objServico = new JDServico(null, true, this, true);
        objServico.setVisible(true);
    }
    public void janelaPesqCliente()
    {
        if (objPesqCli == null)
        {
            objPesqCli = new JDPesquisarCliente(null, true, this);
        }
        objPesqCli.setVisible(true);
    }
    public void janelaPesqFor()
    {
        if (objPesqFor == null)
        {
            objPesqFor = new JDPesquisarFornecedor(null, true, this);
        }
        objPesqFor.setVisible(true);
    }
    public void janelaPesqVeiculo()
    {
        if(objPesqVeiculo == null)
        {
            objPesqVeiculo = new JDPesquisarVeiculo(null, true, this);
        }
        objPesqVeiculo.setVisible(true);
    }
    public void janelaPesqMaterial()
    {
        if(objPesqMaterial == null)
        {
            objPesqMaterial = new JDPesquisarMaterial(null, true, this);
        }
        objPesqMaterial.setVisible(true);
    }
    public void janelaPesqServico()
    {
        if(objPesqServico == null)
        {
            objPesqServico = new JDPesquisarServico(null, true, this);
        }
        objPesqServico.setVisible(true);
    }
    
    public void carregarAlterarCliente(Fisico fisico)
    {
        objClienteFornecedor = new JDCliFor(null, true, this, false,fisico,null);
        objClienteFornecedor.setVisible(true);
    }
    public void carregarAlterarFornecedor(Juridico juridico)
    {
        objClienteFornecedor = new JDCliFor(null, true, this,false,null,juridico );
        objClienteFornecedor.setVisible(true);
    }
   
    public ClasseErro getObjClasseErro() {
        return objClasseErro;
    }
 
    public GerenciadorCDP getCtrlDom() {
        return gerCDP;
    }
    public static void main(String[] args) {

        GerenciadorCIH gerCCI = new GerenciadorCIH();
        gerCCI.janelaPrincipal();

    }

}
