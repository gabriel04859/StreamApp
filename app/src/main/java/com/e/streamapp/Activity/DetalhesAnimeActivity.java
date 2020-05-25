package com.e.streamapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.streamapp.R;
import com.squareup.picasso.Picasso;

public class DetalhesAnimeActivity extends AppCompatActivity {
    private TextView txtNome, txtDescricao;
    private ImageView imgAnime, imgCover;

    private static String nome;
    private static int img, imagemCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_anime);
        iniciaComponentes();
        getSupportActionBar().setTitle(nome);


        //imgAnime.setImageResource(img);



    }

    private void iniciaComponentes(){
        txtNome = findViewById(R.id.txtNomeDetalhes);
        txtDescricao = findViewById(R.id.textViewDescricaoDetalhes);
        imgAnime = findViewById(R.id.imageViewDetalhes);
        imgCover = findViewById(R.id.imageViewCover);

        nome = getIntent().getStringExtra("nome");
        img = getIntent().getIntExtra("imagem",0);
        imagemCover = getIntent().getIntExtra("imagemCover",0);

        txtNome.setText(nome);
        Picasso.get().load(img).into(imgAnime);
        Picasso.get().load(imagemCover).into(imgCover);

        imgCover.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

    }
}
