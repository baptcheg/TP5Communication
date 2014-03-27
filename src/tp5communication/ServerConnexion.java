/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5communication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerConnexion {

    public static void Connexion() throws Exception {
        //Fonction pour envoyer les différentes informations du formulaire au serveur
        Socket socket = new Socket("localhost", 8089);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outSocket.println("aaaa");
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

    public static void ConnexionTest() throws Exception {
        //Permet de récupérer la liste des différentes pieces et de les stocker dans Playlist de TP5Communication
        List<String> test = new ArrayList<String>();
        Socket socket = new Socket("localhost", 8089);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        // PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        //BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        Object object = inSocket.readObject();
        test = (ArrayList<String>) object;
        
        TP5Communication.Playlist = test;
    }

    public static String Connexion3() throws Exception {
        //Fonction pour envoyer les différentes informations du formulaire au serveur
        Socket socket = new Socket("localhost", 8089);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String availablePlace = inSocket.readLine();
        String availablePlace2 = inSocket.readLine();
        String availablePlace3 = inSocket.readLine();
        String a = inSocket.readLine();

        System.out.println(availablePlace2);
        System.out.println("LOLLLL");
        System.out.println(a);

        List<String> test2 = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            test2.add(availablePlace);
            System.out.println(test2.get(i));
        }

        System.out.println(availablePlace);
        return availablePlace;
    }

    public static String getNumberPlaceAvailable(String piece) throws Exception {
        //Fonction pour envoyer les différentes informations du formulaire au serveur
        System.out.println("Envoi au serveuuuuur: " + piece);
        Socket socket = new Socket("localhost", 8089);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outSocket.println("go");
        outSocket.println(piece);
        String availablePlace = inSocket.readLine();
        System.out.println("NB places restantes: "+availablePlace);
        return availablePlace;
    }
        public static void StopUpdatePlaceAvailable() throws Exception {
        //Fonction pour envoyer les différentes informations du formulaire au serveur
        System.out.println("Envoi au serveuuuuur: ENDD");
        Socket socket = new Socket("localhost", 8089);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outSocket.println("ENDD");
    }
}
