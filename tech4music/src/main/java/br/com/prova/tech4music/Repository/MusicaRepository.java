package br.com.prova.tech4music.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.prova.tech4music.Model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String>{
    
    
}