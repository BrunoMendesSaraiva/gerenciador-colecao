package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.ItemColecao;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemColecaoRepository extends JpaRepository<ItemColecao, Long> {
}
