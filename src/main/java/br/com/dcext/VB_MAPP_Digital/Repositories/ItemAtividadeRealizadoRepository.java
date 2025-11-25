package br.com.dcext.VB_MAPP_Digital.Repositories;

import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAtividadeRealizadoRepository extends JpaRepository<ItemAtividadeRealizado, Integer> {
}
