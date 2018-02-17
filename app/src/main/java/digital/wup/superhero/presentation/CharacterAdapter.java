package digital.wup.superhero.presentation;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import digital.wup.superhero.R;
import digital.wup.superhero.data.model.Character;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private Character[] charactersDataSet;

    public CharacterAdapter(Character[] characters) {
        this.charactersDataSet = characters;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.character_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(charactersDataSet[position].getName());
    }

    @Override
    public int getItemCount() {
        return charactersDataSet.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }
}
