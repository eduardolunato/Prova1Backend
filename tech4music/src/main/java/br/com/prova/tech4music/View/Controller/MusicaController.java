package br.com.prova.tech4music.View.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.tech4music.Service.MusicaService;
import br.com.prova.tech4music.View.Model.MusicaRequest;
import br.com.prova.tech4music.View.Model.MusicaResponse;
import br.com.prova.tech4music.shared.MusicaDTO;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {

    @Autowired
    private MusicaService servico;

    ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<MusicaResponse>> obterTodos(){
        //return servico.obterTodos();
        List<MusicaDTO>musicaDTO=servico.obterTodos();
        List<MusicaResponse>musicaResp =
        musicaDTO.
        stream().
        map(p -> mapper.map(p,MusicaResponse.class)).
        collect(Collectors.toList());
        return new ResponseEntity<>(musicaResp,HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaResponse> criarproduto(@RequestBody @Valid MusicaRequest musi){
        MusicaDTO musicaDTO = mapper.map(musi, MusicaDTO.class);
        musicaDTO = servico.criarMusica(musicaDTO);
        MusicaResponse musicaResponse= mapper.map(musicaDTO,MusicaResponse.class);
        return new ResponseEntity<>(musicaResponse,HttpStatus.CREATED);
    }

    @PutMapping(value ="/{id}" )
    public ResponseEntity<MusicaResponse> atualizarMusica(@PathVariable String id, @RequestBody MusicaRequest musicaRequest){
        MusicaDTO musicaDTO= mapper.map(musicaRequest, MusicaDTO.class);
        musicaDTO = servico.atualizarMusica(id, musicaDTO);
        MusicaResponse musicaResponse = mapper.map(musicaDTO,MusicaResponse.class);
        return new ResponseEntity<>(musicaResponse,HttpStatus.OK);
    }

 
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removerMusica(@PathVariable String id) {
       servico.removerMusica(id); 
       return new ResponseEntity<>("Deletado com Sucesso!",HttpStatus.OK);
    }

    @GetMapping("/contagem")
    public long contagemMusicas(){
        return servico.contagem();
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<MusicaResponse> obterPorId(@PathVariable String id){
        Optional<MusicaDTO> musicaDto = servico.obterPorId(id);
        
        if(musicaDto.isPresent()){
            MusicaResponse musicaResponse = mapper.map(musicaDto.get(),MusicaResponse.class);
            return new ResponseEntity<>(musicaResponse,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}