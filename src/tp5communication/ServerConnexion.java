/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerConnexion {

    public static void Connexion() throws Exception {
        //Fonction pour envoyer les différentes informations du formulaire au serveur
        Boolean again = true;
        Socket socket = new Socket("localhost", 8089);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outSocket.println(TP5Communication.name);
        outSocket.println(TP5Communication.firstname);
        outSocket.println(TP5Communication.pieceName);
        outSocket.println(TP5Communication.placeNumber);
    }

    public static void Connexion1() throws Exception {
        //Permet de récupérer la liste des différentes pieces et de les stocker dans Playlist de TP5Communication
        List<String> test = new ArrayList<String>();
        Socket socket = new Socket("localhost", 8089);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int playNumber = 0;
        //on récupère la première info envoyée par le serveur: le nombre de piece de théâtre
        playNumber = Integer.parseInt(inSocket.readLine());
        for (int i = 0; i < playNumber; i++) {
            //On récupère ensuite toutes les noms des pièces de théâtre stockée dans la bdd et envoyées
            //par le serveur
            test.add(inSocket.readLine());
        }
        //On les stockes dans la liste Playlist de TP5Communication
        TP5Communication.Playlist = test;
    }
}
