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

@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Farmacia PesquisaFarmacia(String nome) {
          TypedQuery<Farmacia> query = em.createQuery(
      "SELECT f FROM Farmacia AS f WHERE f.nome like ?1", Farmacia.class);
          query.setParameter(1, nome);
          
        Farmacia result = query.getSingleResult();
           
        return result;
        
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean DeletaFarmacia(Farmacia farmacia) {
        try {
            em.remove(em.merge(farmacia));
        } catch (Exception ex) {
            return false;
        }
        return true;

    }
    
    public List<Remedio> PesquisaRemedio(String nome){
        
        TypedQuery<Remedio> query = em.createQuery(
      "SELECT r FROM Remedio AS r WHERE r.nome like ?1", Remedio.class);
        query.setParameter(1, nome);
        
           List<Remedio> results = query.getResultList();
           
        return results;
        
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean InserirCartao(CartaoDeCredito cartao) {
        try {
            em.persist(cartao);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public CartaoDeCredito PesquisaCartao(String numeroCartao) {
        try {
            TypedQuery<CartaoDeCredito> query = em.createQuery(
                    "SELECT c FROM CartaoDeCredito AS c where c.numero_cartao = ?1 ", CartaoDeCredito.class);
            query.setParameter(1, numeroCartao);
            CartaoDeCredito cartao = query.getSingleResult();
            if (cartao != null) {
                return cartao;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;

    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<CartaoDeCredito> listarCartao(String login) {
        try {
           TypedQuery<CartaoDeCredito> query = em.createQuery(
                    "SELECT ca FROM Cliente AS c, CartaoDeCredito ca where c.login = ?1", CartaoDeCredito.class);
            query.setParameter(1, login);
            
           List<CartaoDeCredito> cartaos = query.getResultList();
            
            if (cartaos != null) {
                return cartaos;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public CartaoDeCredito listaCartaos(Long id) {
        try {
            CartaoDeCredito cartao= em.find(CartaoDeCredito.class, id);
            if (cartao != null) {
                return cartao;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;

    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean AlterarCartao(CartaoDeCredito cartao) {
        try {
            em.merge(cartao);
            
        } catch (Exception ex) {
            return false;
        }
        return true;

    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean DeletaCartao(CartaoDeCredito cartao) {
        try {
            em.remove(em.merge(cartao));
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

}
