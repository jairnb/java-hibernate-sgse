/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.model.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import safety.model.database.HibernateUtil;

/**
 *
 * @author Jair
 */
@Entity
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue
    private UUID id_funcionario;
    private String nome;
    private String cargo;
    private boolean estado;

    public void adicionarFuncionario(Funcionario funcionario) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Funcionario> listFuncionario(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List result = em.createQuery("from Funcionario").getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }
    public UUID getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(UUID id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    
    
    
}
