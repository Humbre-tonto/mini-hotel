package com.hotel.minihotel.support.modelmapper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.hotel.minihotel.domain.DomainModel;
import com.hotel.minihotel.rest.dto.UserModel;


public interface ModelMapper<E extends DomainModel<ID>, D extends UserModel<ID>, ID extends Serializable> extends Serializable{
	
	
	D toDto(E entity);
	List<D> toDto(List<E> entities);
	Set<D> toDto(Set<E> entities);
	Page<D> toDto(Page<E> pageOfEntities);
	
	E toEntity(D dto);
	List<E> toEntity(List<D> dtos);
	Set<E> toEntity(Set<D> dtos);

	
	E toNewEntity(D dto);
	List<E> toNewEntity(List<D> dtos);
	Set<E> toNewEntity(Set<D> dtos);
	List<E> toEntity(List<D> dtos, Boolean nullId);
}
