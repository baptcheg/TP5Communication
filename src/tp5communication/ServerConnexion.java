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
        String saisie;
        String retour;
        Boolean again = true;
        Socket socket = new Socket("localhost", 4444);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outSocket.println(TP5Communication.name);
        outSocket.println(TP5Communication.firstname);
        outSocket.println(TP5Communication.pieceName);
        outSocket.println(TP5Communication.placeNumber);
    }
    
    public static void Connexion1() throws Exception {
        List<String> test = new ArrayList<String>();
        String saisie;
        String retour;
        Boolean again = true;
        Socket socket = new Socket("localhost", 4444);
        System.out.println((java.net.InetAddress.getLocalHost()).toString());
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       // boolean test=false;
        
        //test.add(inSocket.readLine());
        String line="czc";
        while(again){
        test.add(inSocket.readLine());
        }
        TP5Communication.Playlist=test;

    }
}
