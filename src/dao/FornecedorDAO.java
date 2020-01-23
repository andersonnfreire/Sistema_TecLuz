/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cdp.Juridico;
import cdp.Servico;
import hibernate.ConexaoHibernate;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class FornecedorDAO extends GenericDAO{

    public FornecedorDAO(){
         super();
    }

    public List<Juridico>pesquisarNome(String nomePesq) throws SQLException {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria cons = sessao.createCriteria(Juridico.class);
       
        cons.add(  Restrictions.like("CNPJ", nomePesq + "%" )  );

        // cons.add( Restrictions.sqlRestriction( "nome like '" + pesq + "%'" )  );
        
        cons.addOrder( Order.asc("CNPJ") );
        
        List lista = cons.list();
      
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
}
