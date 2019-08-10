package org.pursuit.geniusplazaproficiencytest.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.pursuit.geniusplazaproficiencytest.R;
import org.pursuit.geniusplazaproficiencytest.model.Users;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {

    private List<Users.UserData> userDataList;

    public UsersAdapter(List<Users.UserData> userDataList) {
        this.userDataList = userDataList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.onBind(userDataList.get(position));

    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }
}
