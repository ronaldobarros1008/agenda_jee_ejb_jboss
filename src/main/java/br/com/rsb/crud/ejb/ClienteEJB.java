package br.com.rsb.crud.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rsb.crud.entity.Cliente;

@Stateless
public class ClienteEJB {

	@PersistenceContext
	private EntityManager em;
	
	public void excluir(Long id) {
		
		em.remove(em.find(Cliente.class, id));
		
	}

	public void salvar(Cliente cliente) {

		em.merge(cliente);
		
	}

	public List<Cliente> listar() {
		return em.createQuery("select c FROM Cliente c").getResultList();
	}

	public void atualizar(Cliente cliente) {
		
		em.merge(cliente);
		
	}

	public Cliente obterPorId(Long id) {

		return em.find(Cliente.class, id);
		
	}

}
