package com.e.streamapp.Model;

public class Slide {
    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    private int imagem;
    private String title;

    public Slide(int imagem, String title) {
        this.imagem = imagem;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
