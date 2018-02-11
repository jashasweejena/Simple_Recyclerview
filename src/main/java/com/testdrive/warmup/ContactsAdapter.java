package com.testdrive.warmup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Jashaswee on 2/10/2018.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
private List<Contact> mContacts;

private Context mContext;

public ContactsAdapter(Context context, List<Contact> contacts)
{
    mContacts = contacts;
    mContext = context;
}

private Context getContexT(){
    return mContext;
}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textView = holder.nameTextView;
        Button button = holder.messageButton;
        Contact contact = mContacts.get(position);
        textView.setText(mContacts.get(position).getName());
        Log.d(TAG, "onBindViewHolder: " + textView.getText());
        button.setText(contact.isOnline() ? "Online":"Offline");
        button.setEnabled(contact.isOnline());
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+ mContacts.size());
        return mContacts.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public Button messageButton;


        public ViewHolder(View itemView)
        {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
