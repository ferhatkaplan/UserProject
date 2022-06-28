package com.ecodation.userproject;

//CRUD < JPaRepository < PagingAndSorting

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
}
