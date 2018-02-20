package com.test.prs.designpattern.proxy;

import java.io.File;

public class TestProxy {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("admin", "admin");
        try {
            executor.executeCommand("ls -ltr");
            executor.executeCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
        }

    }
}
