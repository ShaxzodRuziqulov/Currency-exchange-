/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:10:46
 */
package com.example.Currency.exchange.repository;

import com.example.Currency.exchange.entity.Currency;
import com.example.Currency.exchange.entity.enumirated.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("update currency c set c.status=:status where c.id=:id")
    void updateByStatus(@Param("id") Long id, @Param("status") Status status);
    @Query("select c from currency c where c.code=:code")
    Currency getCurrencyByCode(String code);
}
