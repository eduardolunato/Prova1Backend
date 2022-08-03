package br.com.prova.tech4music.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prova.tech4music.Model.Musica;
import br.com.prova.tech4music.Repository.MusicaRepository;
import br.com.prova.tech4music.shared.MusicaDTO;

@Service
public class MusicaServiceImpl implements MusicaService {
    
    @Autowired MusicaRepository repositorio;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MusicaDTO criarMusica(MusicaDTO musicaDTO) {
        Musica musica =mapper.map(musicaDTO, Musica.class);
        musica = repositorio.save(musica);
        MusicaDTO dto= mapper.map(musica,MusicaDTO.class);
        return dto;
      
    }

    @Override
    public List<MusicaDTO> obterTodos() {
        List<Musica> list =  repositorio.findAll();

        //stream
        List<MusicaDTO> musicaDTO = 
        list.
        stream().
        map(p -> mapper.map(p, MusicaDTO.class)).
        collect(Collectors.toList());
        
        return musicaDTO;

    }

    
    @Override
    public void removerMusica(String id) {
        repositorio.deleteById(id);
    }
    
    @Override
    public long contagem(){
        return repositorio.count();
        
        
    }

    @Override
    public MusicaDTO atualizarMusica(String id, MusicaDTO musicaDTO) {
        Musica musica = mapper.map(musicaDTO,Musica.class);

        musica.setId(id);
        musica = repositorio.save(musica);

        MusicaDTO dto = mapper.map(musica,MusicaDTO.class);
        return dto;
    }

    @Override
    public Optional<MusicaDTO> obterPorId(String id) {
        Optional<Musica>musica=repositorio.findById(id);
        if(musica.isPresent()){
            MusicaDTO musicaDTO = mapper.map(musica.get(), MusicaDTO.class);
            return Optional.of(musicaDTO);
        }

        return Optional.empty();
    }
    
}