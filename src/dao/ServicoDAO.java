/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cdp.Servico;
import cdp.Veiculos;
import hibernate.ConexaoHibernate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Anderson
 */
public class ServicoDAO extends GenericDAO{
    public ServicoDAO() {
        super();
    }
    public List<Servico> pesquisarPorCodigo(int codigo) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria cons = sessao.createCriteria(Servico.class);
        
        cons.add(  Restrictions.eq("codigo", codigo) );

        
        cons.addOrder( Order.asc("codigo") );
   
        List lista = cons.list();
        
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
        
    }
    
}
