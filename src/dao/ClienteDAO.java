package dao;

import cdp.Fisico;
import hibernate.ConexaoHibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class ClienteDAO extends GenericDAO
{

    public ClienteDAO() {
        super();
    }
    
    public List<Fisico> pesquisarPorNome(String pesq) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria cons = sessao.createCriteria(Fisico.class);
        
        cons.add(  Restrictions.like("cnpj", pesq + "%" )  );

        // cons.add( Restrictions.sqlRestriction( "nome like '" + pesq + "%'" )  );
        
        cons.addOrder( Order.asc("cnpj") );
        cons.addOrder( Order.asc("razaosocial") );
   
        List lista = cons.list();
        
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
        
    }

}
