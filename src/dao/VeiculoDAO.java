/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cdp.Fisico;
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
public class VeiculoDAO extends GenericDAO{

    public VeiculoDAO() {
        super();
    }
    public List<Veiculos> pesquisarPorNome(String pesq) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria cons = sessao.createCriteria(Veiculos.class);
        
        cons.add(  Restrictions.like("modelo", pesq + "%" )  );

        // cons.add( Restrictions.sqlRestriction( "nome like '" + pesq + "%'" )  );
        
        cons.addOrder( Order.asc("modelo") );
        cons.addOrder( Order.asc("ano") );
   
        List lista = cons.list();
        
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
        
    }
    
}
