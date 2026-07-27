package com.chinaglia.salaaluguelapi.mapper;

public interface BaseMapper<REQ, RES, E> {

	RES toDto(E entity);

	E toEntity(REQ dto);

}
