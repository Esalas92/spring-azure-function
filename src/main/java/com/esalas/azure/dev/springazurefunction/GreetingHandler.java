package com.esalas.azure.dev.springazurefunction;

import com.esalas.azure.dev.springazurefunction.model.User;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class GreetingHandler extends FunctionInvoker<User, User> {
    @FunctionName("getUser")
    public User execute(@HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request, ExecutionContext context) {
        context.getLogger().info( String.format("Request for : [%s]", request.getBody().map(User::getLogin)) );
        return handleRequest(request.getBody().get(), context);
    }
}
