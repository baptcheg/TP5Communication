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
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;


public class TP5Communication {

    static String name;
    static String firstname;
    static int placeNumber;
    static String pieceName;
    static List<String> Playlist;
    
    public static void main(String[] args) throws Exception  {
        ServerConnexion.Connexion1();
                for(String elem: Playlist)
       {
       	 System.out.println (elem);
       }
        IG f = new IG();
        f.RunIG(); 
    }
    
    public static void display(){
        System.out.println(name);
        System.out.println(firstname);
        System.out.println(pieceName);
        System.out.println(placeNumber);        

    }
    public static void setString(String userName, String userFirstname, String userPieceName, int userPlaceNumber){
        name=userName;
        firstname  = userFirstname;
        pieceName = userPieceName;
        placeNumber = userPlaceNumber; 
    }
}
