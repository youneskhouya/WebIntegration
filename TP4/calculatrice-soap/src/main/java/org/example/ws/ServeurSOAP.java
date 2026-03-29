package org.example.ws;


import javax.xml.ws.Endpoint;

public class ServeurSOAP {
    public static void main(String[] args) {
        String url = "http://localhost:9000/calculatrice";
        System.out.println("Démarrage du serveur SOAP...");
        Endpoint.publish(url, new CalculatriceImp());
        System.out.println("Service disponible sur : " + url);
        System.out.println("WSDL : " + url + "?wsdl");
    }
}