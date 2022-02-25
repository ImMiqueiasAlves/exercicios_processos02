package controller;

import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
    private String os() {
        return System.getProperty("os.name");
    }

    public void ip() {
        String command = "";
        if(os().contains("Windows"))
            command = "ipconfig";
        if(os().contains("Linux"))
            command = "ifconfig";
        
        
    }
}