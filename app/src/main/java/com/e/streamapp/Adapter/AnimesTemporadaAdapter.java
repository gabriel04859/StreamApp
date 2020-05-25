package com.e.streamapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.streamapp.AnimeItemClickListener;
import com.e.streamapp.Model.Anime;
import com.e.streamapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimesTemporadaAdapter extends RecyclerView.Adapter<AnimesTemporadaAdapter.AnimesTemporadaViewHolder>{
    private Context context;
    private List<Anime> animeList;
    AnimeItemClickListener animeItemClickListener;

    public AnimesTemporadaAdapter(Context context,List<Anime> animeList, AnimeItemClickListener animeListener){
        this.context = context;
        this.animeList = animeList;
        animeItemClickListener = animeListener;

    }

    class AnimesTemporadaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgRow;
        private TextView txtNome;

        public AnimesTemporadaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRow = itemView.findViewById(R.id.imageViewRowTemp);
            txtNome = itemView.findViewById(R.id.txtNomeRowTemp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    /*Intent intent = new Intent(context, DetalhesAnimeActivity.class);
                    intent.putExtra("nome", animeList.get(position).getNome());
                    intent.putExtra("imagem",animeList.get(position).getImg());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);*/

                    animeItemClickListener.onAnimeClick(animeList.get(position),imgRow);
                }
            });
        }

    }

    @NonNull
    @Override
    public AnimesTemporadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_recycler_temporada,parent,false);
        return new AnimesTemporadaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimesTemporadaViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        holder.imgRow.setImageResource(anime.getImg());
        holder.txtNome.setText(anime.getNome());
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }


}
