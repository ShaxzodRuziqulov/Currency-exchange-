/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:10:43
 */
package com.example.Currency.exchange.repository;

import com.example.Currency.exchange.entity.User;
import com.example.Currency.exchange.entity.enumirated.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("update users u set u.status=:status where u.id=:id")
    public User updateByStatus(@Param("id") Long id, @Param("status") Status status);
}
