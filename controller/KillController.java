package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillController {
    private Process initProcess(String process) {
        try {
            return Runtime.getRuntime().exec(process);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private String os() {
        return System.getProperty("os.name");
    }

    public void listaProcessos() {
        String command = "";

        if(os().contains("Windows")) {
            command = "TASKLIST /FO TABLE";
        }
        
        if(os().contains("Linux")) {
            command = "ps -ef";
        }

        Process process = initProcess(command);

        InputStreamReader stream = new InputStreamReader(process.getInputStream());
        BufferedReader buffer = new BufferedReader(stream);

        try {
            String line = buffer.readLine();

            while(line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }
        } catch(IOException e) {
            System.out.println("Chamada inválida.");
        }

    }

    public void mataPid(int pid) {
        String command = "";

        if(os().contains("Windows")) {
            command = "TASKKILL /PID " + pid;
        }
        
        if(os().contains("Linux")) {
            command = "kill -9 " + pid;
        }

        initProcess(command);
    }

    public void mataNome(String nome) {
        String command = "";

        if(os().contains("Windows")) {
            command = "TASKKILL /IM " + nome;
        }
        
        if(os().contains("Linux")) {
            command = "pkill -f " + nome;
        }

        initProcess(command);
    }
}
