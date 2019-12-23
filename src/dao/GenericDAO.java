/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.ConexaoHibernate;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;


public class GenericDAO {

    public GenericDAO() {

    }

    public void inserir(Object cli) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.save(cli);

        sessao.getTransaction().commit();
        sessao.close();

    }

    public void alterar(Object cli) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.update(cli);

        sessao.getTransaction().commit();
        sessao.close();

    }

    public void excluir(Object cli) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.delete(cli);

        sessao.getTransaction().commit();
        sessao.close();

    }

    public List listar(Class classe) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();

        Criteria cons = sessao.createCriteria(classe);
        List lista = cons.list();

        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }

    public Object get(Class classe, Serializable id) throws SQLException {

        Session sessao;

        sessao = hibernate.ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();

        Object obj = sessao.get(classe, id);

        sessao.getTransaction().commit();
        sessao.close();

        return obj;
    }

}
