package com.esalas.azure.dev.springazurefunction;

import com.esalas.azure.dev.springazurefunction.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface UserService {
    @GET("/users")
    public Call<List<User>> getUsers(
            @Query("per_page") Integer per_page,
            @Query("page") Integer page);

    @GET("/users/{username}")
    public Call<User> getUser(@Path("username") String username);
}
