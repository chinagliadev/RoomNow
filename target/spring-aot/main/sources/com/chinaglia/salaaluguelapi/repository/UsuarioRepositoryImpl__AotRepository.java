package com.chinaglia.salaaluguelapi.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * AOT generated JPA repository implementation for {@link UsuarioRepository}.
 */
@Generated
public class UsuarioRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public UsuarioRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link UsuarioRepository#existsByCpf(java.lang.String)}.
   */
  public boolean existsByCpf(String cpf) {
    String queryString = "SELECT u.id FROM Usuario u WHERE u.cpf = :cpf";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("cpf", cpf);
    query.setMaxResults(1);

    return !query.getResultList().isEmpty();
  }

  /**
   * AOT generated implementation of {@link UsuarioRepository#findByEmail(java.lang.String)}.
   */
  public UserDetails findByEmail(String email) {
    String queryString = "SELECT u FROM Usuario u WHERE u.email = :email";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("email", email);

    return (UserDetails) convertOne(query.getSingleResultOrNull(), false, UserDetails.class);
  }
}
