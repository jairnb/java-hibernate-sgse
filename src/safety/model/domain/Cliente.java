package safety.model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import safety.model.database.HibernateUtil;

@Entity
public class Cliente implements Serializable {

    @Id  
    @Column(name="id_cliente")
    private long idCliente;
    private String nome;
    private String sobrenome;
    private int nif;
    private int telefone;
    private String email;   

    
    
    public List<Cliente> listCliente(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List result = em.createQuery("from Cliente").getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }
    
    public void guardarCliente(Cliente cliente){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }
    
    public void alterarCliente(Cliente cliente){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminarCliente(Cliente cliente){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Cliente clienteRemover = em.find(Cliente.class, cliente.getIdCliente());
        em.remove(clienteRemover);
        em.getTransaction().commit();
        em.close();
    }
//    public boolean guardarCliente(Cliente cliente){
//        Session session = HibernateUtil.getSession();
//        session.getTransaction().begin();
//        session.persist(cliente);
//        session.getTransaction().commit();
//        session.close();
//        return true;
//    }
//    
//    public void alterarCliente(Cliente cliente){
//        Session session = HibernateUtil.getSession();
//        session.getTransaction().begin();
//        session.merge(cliente);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    public void eliminarCliente(Cliente cliente){
//        Session session = HibernateUtil.getSession();
//        session.getTransaction().begin();
//        session.find(Cliente.class, cliente.getIdCliente());
//        session.remove(cliente);
//        session.getTransaction().commit();
//        session.close();
//    }
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    

}
