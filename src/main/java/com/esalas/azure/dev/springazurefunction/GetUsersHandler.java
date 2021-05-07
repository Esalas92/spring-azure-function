package com.esalas.azure.dev.springazurefunction;

import com.esalas.azure.dev.springazurefunction.model.User;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.List;
import java.util.Optional;

public class GetUsersHandler extends FunctionInvoker<Optional<Void>, List<User>> {
    @FunctionName("getUsers")
    public List<User> execute(@HttpTrigger(name = "request", methods = { HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request, ExecutionContext context) {
        context.getLogger().info( "Request for Github user list" );
        return handleRequest( Optional.empty(), context );
    }
}
