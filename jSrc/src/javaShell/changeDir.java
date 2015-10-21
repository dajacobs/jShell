package javaShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class changeDir {
    public static String backSlash = "\\";
    public static void main(String[] args) throws IOException {
        String commandLine = null;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ProcessBuilder pb = new ProcessBuilder();
        
        while(true) {
            // Get the users input from stream
            System.out.print("jsh>");
            
            if(commandLine.equals("")) {
                continue;
            }
            // Save commands in array list
            StringTokenizer st = new StringTokenizer(commandLine);
            ArrayList<String> commands = new ArrayList<>();
            }
        }
    }
}