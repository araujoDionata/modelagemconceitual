package com.dionata.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dionata.cursomc.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
