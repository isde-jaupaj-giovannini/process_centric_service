package com.unitn.process_centric_service;

import com.unitn.bl_service.BLService;
import com.unitn.bl_service.BLService_Service;
import com.unitn.local_database.UserData;
import com.unitn.storage_service.Goal;
import com.unitn.storage_service.Storage;
import com.unitn.storage_service.StorageService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;

/**
 * Created by erinda on 1/24/16.
 */
@WebService( endpointInterface = "com.unitn.process_centric_service.ProcessCentricService",
        serviceName="PCService")
public class PCSImpl  implements ProcessCentricService{

    StorageService storage = new Storage().getStorageServiceImplPort();
    BLService blService = new BLService_Service().getBLServiceImplPort();

    @Override
    public String getDescription() {
        return "THIS IS: " + ProcessCentricService.class.getSimpleName();
    }

    @Override
    public boolean userExists(int telegramId) {
        return storage.userExists(telegramId);
    }

    @Override
    public boolean registerNewUser(UserData user) {
        return blService.registerNewUser(user);
    }

    @Override
    public boolean saveGoal(int telegramId, Goal goal) {
        return storage.saveGoal(telegramId, goal);
    }

    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException {
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        if (HOSTNAME.equals("127.0.0.1")) {
            HOSTNAME = "localhost";
        }
        String PORT = "6901";
        String BASE_URL = "/ws/pcservice";

        if (String.valueOf(System.getenv("PORT")) != "null") {
            PORT = String.valueOf(System.getenv("PORT"));
        }

        String endpointUrl = PROTOCOL + HOSTNAME + ":" + PORT + BASE_URL;
        System.out.println("Starting "+ ProcessCentricService.class.getSimpleName() +"...");
        System.out.println("--> Published. Check out " + endpointUrl + "?wsdl");
        Endpoint.publish(endpointUrl, new PCSImpl());
    }
}
