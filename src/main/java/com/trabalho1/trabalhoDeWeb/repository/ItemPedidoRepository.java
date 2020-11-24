package com.trabalho1.trabalhoDeWeb.repository;


import com.trabalho1.trabalhoDeWeb.entity.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {


}
