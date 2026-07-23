package com.chinaglia.salaaluguelapi.mapper;

public interface BaseMapper<D, E> {
	
	D toDto(E entity);
	
	E toEntity(D dto);
	
}

