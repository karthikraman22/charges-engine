package in.achuala.core.charges;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import in.achuala.core.charges.resource.ChargesResource;
import in.achuala.core.charges.resource.DaggerResourceFactory;
import in.achuala.core.charges.resource.ResourceFactory;
import in.achuala.core.charges.resource.TransactionResource;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {

        ServerBuilder sb = Server.builder();
        sb.http(10001);
        sb.service("/about", (ctx, req) -> HttpResponse.of("Charges Engine"));
        configureServices(sb);
        Server server = sb.build();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop().join();
            log.info("Server has been stopped.");
        }));


        server.start().join();
    }

    static void configureServices(ServerBuilder sb) {
        ResourceFactory rf =  DaggerResourceFactory.create();
        sb.annotatedService("/v1",rf.createTransactionResource());
        sb.annotatedService("/v1", rf.createChargesResource());
        sb.annotatedService("/v1", rf.createChargesAdminResource());
    }
}
