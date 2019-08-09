package org.pursuit.geniusplazaproficiencytest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.pursuit.geniusplazaproficiencytest.model.Users;
import org.pursuit.geniusplazaproficiencytest.network.RetrofitSingleton;
import org.pursuit.geniusplazaproficiencytest.network.UserService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitSingleton.getInstance()
                .create(UserService.class)
                .getUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Users>() {
                    @Override
                    public void accept(Users users) throws Exception {
                        Log.d("Evelyn", users.getData().get(0).getEmail());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
