package br.com.easymoney.adapter.outbound.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymoney.adapter.outbound.database.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String>{

}
