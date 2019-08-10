package org.pursuit.geniusplazaproficiencytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.pursuit.geniusplazaproficiencytest.model.Users;
import org.pursuit.geniusplazaproficiencytest.network.RetrofitSingleton;
import org.pursuit.geniusplazaproficiencytest.network.UserService;
import org.pursuit.geniusplazaproficiencytest.recyclerview.UsersAdapter;
import org.pursuit.geniusplazaproficiencytest.recyclerview.UsersViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private List<Users.UserData> userDataList;
    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    private UsersViewHolder viewHolder;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        RetrofitSingleton.getInstance()
                .create(UserService.class)
                .getUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Users>() {
                    @Override
                    public void accept(Users users) throws Exception {
                        Log.d("Evelyn", users.getData().get(1).getEmail());
                        userDataList = users.getData();
                        adapter = new UsersAdapter(userDataList);

                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("Fail", throwable.toString());
                    }
                });
    }



}
