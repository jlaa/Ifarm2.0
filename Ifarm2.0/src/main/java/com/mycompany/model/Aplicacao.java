/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;


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

}
