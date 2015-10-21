package javaShell;

import java.io.BufferedReader;
import java.io.File;
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
            
            while(st.hasMoreTokens()) {
                commands.add(st.nextToken());
            }
            // Change directory command
            if(commands.contains("cd")) {
                if(commands.get(commands.size() - 1).equals("cd")) {
                    File home = new File(System.getProperty("user.home"));
                    System.out.println("Home directory: " +home);
                    pb.directory(home);
                    continue;
                } else {
                    String arg = commands.get(commands.size() - 1);
                    System.out.println("Arguement passed: " +arg);
                    String cPath = pb.directory() +backSlash +arg;
                    System.out.println("Path created: " +cPath);
                    File nPath = new File(cPath);
                    pb.directory(nPath);
                    continue;
                }
            }
        }
    }
}