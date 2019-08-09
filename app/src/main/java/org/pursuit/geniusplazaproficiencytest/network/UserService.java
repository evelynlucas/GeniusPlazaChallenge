package org.pursuit.geniusplazaproficiencytest.network;

import org.pursuit.geniusplazaproficiencytest.model.Users;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserService {

    String ENDPOINT_URL = "users";

    @GET(ENDPOINT_URL)
    Single<Users> getUserData();

}
