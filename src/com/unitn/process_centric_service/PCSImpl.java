package com.unitn.process_centric_service;

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

    @Override
    public String getDescription() {
        return "THIS IS: " + ProcessCentricService.class.getSimpleName();
    }

    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException {
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        if (HOSTNAME.equals("127.0.0.1")) {
            HOSTNAME = "localhost";
        }
        String PORT = "6902";
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
