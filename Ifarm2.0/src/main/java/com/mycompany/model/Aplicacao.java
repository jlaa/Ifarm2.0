/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author LucasPC
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Aplicacao {

    @PersistenceContext(name = "com.mycompany_Ifarm2.0_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean CadastrarCliente(Cliente cliente) {
        try {
            em.persist(cliente);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean AtualizaCliente(Cliente cliente) {
        try {
            em.merge(cliente);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Cliente LoginUuario(String email, String senha) {
        Cliente cliente;
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c from Cliente c where c.email like ?1 and c.senha like ?2", Cliente.class);
            query.setParameter(1, email);
            query.setParameter(2, senha);
            cliente = query.getSingleResult();
            if (cliente != null) {
                return cliente;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Cliente> pesquisaClientes(String login) {
        List<Cliente> cliente;
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c from Cliente c where c.login like ?1 ", Cliente.class);
            query.setParameter(1, login);
            cliente = query.getResultList();
            if (cliente != null) {
                return cliente;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excluirCliente(Cliente cliente) {
        em.remove(em.merge(cliente));
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean CadastrarFarmacia(Farmacia farmacia) {
        try {
            em.persist(farmacia);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean AtualizaFarmacia(Farmacia farmacia) {
        try {
            em.merge(farmacia);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Farmacia PesquisaFarmacia(String nome) {
        TypedQuery<Farmacia> query = em.createQuery(
                "SELECT f FROM Farmacia AS f", Farmacia.class);
        List<Farmacia> results = query.getResultList();

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getNome().equals(nome)) {
                return results.get(i);
            }
        }

        return null;

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean DeletaFarmacia(Farmacia farmacia) {
        try {
            em.remove(farmacia);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

}
