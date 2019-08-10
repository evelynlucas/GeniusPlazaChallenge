package org.pursuit.geniusplazaproficiencytest.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.pursuit.geniusplazaproficiencytest.R;
import org.pursuit.geniusplazaproficiencytest.model.Users;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.first_name_textview)
    TextView firstNameTextView;

    @BindView(R.id.last_name_textview)
    TextView lastNameTextView;

    @BindView(R.id.user_imageview)
    ImageView userImageView;

    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(Users.UserData userData) {
        firstNameTextView.setText(userData.getFirst_name());
        lastNameTextView.setText(userData.getLast_name());
        Picasso.get()
                .load(userData.getAvatar())
                .into(userImageView);
    }
}
