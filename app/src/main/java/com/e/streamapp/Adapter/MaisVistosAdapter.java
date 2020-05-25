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

import java.util.List;

public class MaisVistosAdapter extends RecyclerView.Adapter<MaisVistosAdapter.MaisVistosViewHolder> {
    private Context context;
    private List<Anime> animeList;
    AnimeItemClickListener animeItemClickListener;

    public MaisVistosAdapter(Context context, List<Anime> animeList, AnimeItemClickListener animeListener){
        this.context = context;
        this.animeList = animeList;
        animeItemClickListener = animeListener;
    }

    class MaisVistosViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNome;
        private ImageView imageViewRow;
        public MaisVistosViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txtNomeRow);
            imageViewRow = itemView.findViewById(R.id.imageViewRow);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    /*Intent intent = new Intent(context, DetalhesAnimeActivity.class);
                    intent.putExtra("nome", animeList.get(position).getNome());
                    intent.putExtra("imagem",animeList.get(position).getImg());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);*/

                    animeItemClickListener.onAnimeClick(animeList.get(position),imageViewRow);
                }
            });
        }
    }

    @NonNull
    @Override
    public MaisVistosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_recycler_mais_vistos,parent, false);
        return new MaisVistosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaisVistosViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        holder.txtNome.setText(anime.getNome());
        holder.imageViewRow.setImageResource(anime.getImg());

    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }


}
