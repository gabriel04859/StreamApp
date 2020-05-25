package com.e.streamapp.Model;

public class Anime {

    public Anime(){}

    public Anime(String nome, int img, int imgCover){
        this.nome = nome;
        this.img = img;
        this.imgCover = imgCover;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private String nome;
    private int img;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStreamLink() {
        return streamLink;
    }

    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }

    private String descricao;
    private String avaliacao;
    private String estudio;
    private String genero;
    private String streamLink;

    public int getImgCover() {
        return imgCover;
    }

    public void setImgCover(int imgCover) {
        this.imgCover = imgCover;
    }

    private int imgCover;
}
