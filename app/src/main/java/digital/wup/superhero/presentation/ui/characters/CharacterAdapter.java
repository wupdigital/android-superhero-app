package digital.wup.superhero.presentation.ui.characters;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import digital.wup.superhero.R;
import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.presentation.Navigation;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private Character[] charactersDataSet;
    private CharactersContract.CharactersView charactersView;

    public CharacterAdapter(Character[] characters, CharactersContract.CharactersView charactersView) {
        this.charactersDataSet = characters;
        this.charactersView = charactersView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.character_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(charactersDataSet[holder.getAdapterPosition()].getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Navigation.CHARACTER_ID, String.valueOf(charactersDataSet[holder.getAdapterPosition()].getId()));

                charactersView.navigateToDetails(bundle);
            }
        });
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
