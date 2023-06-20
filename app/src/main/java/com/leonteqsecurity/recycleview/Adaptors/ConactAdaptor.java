package com.leonteqsecurity.recycleview.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonteqsecurity.recycleview.R;

import java.util.List;

public class ConactAdaptor extends RecyclerView.Adapter<ConactAdaptor.ContactHolder> {
   private List<Contact> contactsList;
   private  Context context;

    public ConactAdaptor(List<Contact> contacts, Context context) {
        this.contactsList = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_layout_file,parent,false);

        return new ContactHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact contact =contactsList.get(position);
        holder.contactName.setText(contact.getName());
        holder.contactName.setText(contact.getNumber());

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactHolder extends  RecyclerView.ViewHolder
    {
        private TextView contactName;




        private TextView phoneNumber;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            contactName =itemView.findViewById(R.id.contactName);
            phoneNumber =itemView.findViewById(R.id.contactNumber);
        }
    }
}
