package javaShell;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JShell {
    public static String slash = "/";
    public static void main(String[] args) throws IOException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ProcessBuilder pb = new ProcessBuilder();
        
        while(true) {
            // Get the users input from stream
            System.out.print("jsh>");
            commandLine = console.readLine();
            
            if(commandLine.equals("")) {
                continue;
            }
            // Save commands in array list
            StringTokenizer st = new StringTokenizer(commandLine);
            ArrayList<String> history = new ArrayList<>();
       
            while(st.hasMoreTokens()) {
                history.add(st.nextToken());
            }
            // Change directory command
            if(history.contains("cd")) {
                if(history.get(history.size() - 1).equals("cd")) {
                    File home = new File(System.getProperty("user.home"));
                    System.out.println("Home directory: " +home);
                    pb.directory(home);
                    continue;
                } else {
                    String arg = history.get(history.size() - 1);
                    System.out.println("Arguement passed: " +arg);
                    String cPath = pb.directory() +slash +arg;
                    System.out.println("Path created: " +cPath);
                    File nPath = new File(cPath);
                    pb.directory(nPath);
                    continue;
                }    
            } else if(history.contains("history")) {
                if(history.get(history.size() - 1).equals("history")) {
                    for(int i = 0; i > history.size() - 1; i++) {
                        System.out.println("["+i+"]" +history.get(i));
                    }
                    continue;
                }
            }
            // Pass the commands to ProcessBuilder command
            pb.command(history);
            Process proc = pb.start();
            
            // Output stream to be returned from the proc
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr)) {
                String line;
                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
    }
}