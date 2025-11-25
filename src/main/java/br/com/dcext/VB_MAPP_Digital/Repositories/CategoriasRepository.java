package br.com.dcext.VB_MAPP_Digital.Repositories;

import br.com.dcext.VB_MAPP_Digital.Entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer > {
}
