/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cdp.Juridico;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class FornecedorDAO {
    public FornecedorDAO() throws ClassNotFoundException, SQLException
    {

    }
    public List pesquisarNome(String nomePesq) throws SQLException
    {
        Session sessao = null;
        List<Juridico> lista = null;
        try
        {
            sessao = hibernate.ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            Criteria consulta;
            consulta = sessao.createCriteria(Juridico.class);

            consulta.add(Restrictions.like("cnjp", "%" + nomePesq + "%"));
            lista = consulta.list();

            sessao.getTransaction().commit();

        } catch (HibernateException he)
        {
            sessao.getTransaction().rollback();
        } finally
        {
            if (sessao != null)
            {
                sessao.close();
            }
            return lista;
        }
    }
}
