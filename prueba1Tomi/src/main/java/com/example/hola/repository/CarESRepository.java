package com.example.hola.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.hola.model.CarES;

public interface CarESRepository extends ElasticsearchRepository<CarES, String>
{
	
}