package com.jofre.sebd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jofre.sebd.domain.Pessoa;

import jakarta.persistence.TypedQuery;

@Repository
public class PessoaDaoImpl extends AbstractDao<Pessoa, Integer> implements PessoaDao{

	
	
	 //* Consulta se fosse fazer da forma convencional, mas como na classe AbstractDao 
	 //* tem um método genérico eu usarei o método  de baixo

//	@Override
//	public List<Pessoa> findByNome(String nome) {
//		TypedQuery<Pessoa> query =  getEntityManager()
//				.createQuery("select p from Pessoa p where p.nome like :nome",Pessoa.class);
//		query.setParameter("nome", nome);
//		return query.getResultList();
//	} 

	
	
	//por este:
	@Override
	public List<Pessoa> findByNome(String nome) {
		return createQuery("select p from Pessoa p where p.nome like concat('%',?1,'%')", nome);
	}

	@Override
	public List<Pessoa> findByFilialId(Integer id) {
		
		return createQuery("select p from Pessoa p where p.filial.id = ?1", id);
	}

	@Override
	public List<Pessoa> findByCartao(Long cartaoMembro) {
	
		return createQuery("select p from Pessoa p where p.cartaoMembro = ?1", cartaoMembro);
	}

	@Override
	public List<Pessoa> findByTelefone(String telefone) {
		return createQuery("select p from Pessoa p where p.telefone = ?1", telefone);
	}

}
