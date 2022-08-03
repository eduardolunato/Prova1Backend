package br.com.prova.tech4music.View.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaRequest {
    private String id;
    @NotBlank(message = "O nome não deve estar em branco")
    @NotEmpty(message = "O nome não pode ser vazio")
    @Size(min = 5, message = "O tamnho mínimo para nome é 5 caracteres")
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int anoLancamento;
    private String compositor;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
}
