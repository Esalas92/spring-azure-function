package com.esalas.azure.dev.springazurefunction;

import com.esalas.azure.dev.springazurefunction.model.User;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class GreetingService {
    public User getUser(User user) {
        UserService service = UserServiceGenerator.createService(UserService.class);
        Call<User> callSync = service.getUser( user.getLogin() );

        try {
            Response<User> response = callSync.execute();
            return response.body();
        } catch (IOException ex) {
            return null;
        }
    }

    public List<User> getUsers() {
        UserService service = UserServiceGenerator.createService(UserService.class);
        Call<List<User>> callSync = service.getUsers( 10, null );

        try {
            Response<List<User>> response = callSync.execute();
            return response.body();
        } catch (IOException ex) {
            return null;
        }
    }
}