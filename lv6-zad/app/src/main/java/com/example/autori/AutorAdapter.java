package com.example.autori;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class AutorAdapter extends RecyclerView.Adapter<AutorAdapter.AutorViewHolder> {
    private ArrayList<Autor> autorList;

    public AutorAdapter(ArrayList<Autor> autorList) {
        this.autorList = autorList; }

    @NonNull
    @Override
    public AutorAdapter.AutorViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext ()).inflate ( R.layout.list_item,parent,false );
        return new AutorViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(AutorViewHolder holder, int position) {
        Autor autor = autorList.get ( position );

        holder.firstName.setText ( autor.getFirstName ());
        holder.lastName.setText ( autor.getLastName ());
        holder.bookName.setText ( autor.getBookName ());
        holder.objave.setText ( String.valueOf ( autor.getObjave ()));
        holder.prodaja.setText ( String.valueOf ( autor.getProdaja ()));
        holder.imageView.setImageResource ( R.drawable.person );
    }

    @Override
    public int getItemCount() { return autorList.size (); }

    static class AutorViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView firstName;
        TextView lastName;
        TextView bookName;
        TextView prodaja;
        TextView objave;



        AutorViewHolder(@NonNull View itemView) {
            super ( itemView );

            imageView = itemView.findViewById (R.id.imageView);
            firstName = itemView.findViewById ( R.id.firstName_TV );
            lastName = itemView.findViewById ( R.id.lastName_TV );
            bookName = itemView.findViewById ( R.id.bookName_TV );
            prodaja = itemView.findViewById ( R.id.prodaja_TV );
            objave = itemView.findViewById ( R.id.objave_TV );
        }
    }

}
