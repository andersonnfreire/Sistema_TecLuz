
package dao;

import cdp.Fisico;
import cdp.Materiais;
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
public class MateriaisDAO extends GenericDAO{

    public MateriaisDAO() {
        super();
    }
    
    public List<Materiais> pesquisarPorNome(String pesq) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria cons = sessao.createCriteria(Materiais.class);
        
        cons.add(  Restrictions.like("nome", pesq + "%" )  );

        // cons.add( Restrictions.sqlRestriction( "nome like '" + pesq + "%'" )  );
        
        cons.addOrder( Order.asc("nome") );
   
        List lista = cons.list();
        
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
        
    }
    
}
