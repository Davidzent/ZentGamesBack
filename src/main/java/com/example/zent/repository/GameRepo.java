package com.example.zent.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zent.module.Game;


@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {

    List<Game> findByNameContaining(String name);
    Page<Game> findByNameContaining(String name, Pageable pageable);

}