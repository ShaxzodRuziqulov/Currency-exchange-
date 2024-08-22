/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:21.08.2024
 * TIME:10:59
 */
package com.example.Currency.exchange.service.mapper;

import java.util.List;

public interface EntityMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);
    List<E>toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);

}
