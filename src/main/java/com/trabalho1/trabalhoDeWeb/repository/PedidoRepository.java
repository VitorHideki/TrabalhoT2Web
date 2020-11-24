package com.trabalho1.trabalhoDeWeb.repository;

import com.trabalho1.trabalhoDeWeb.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
