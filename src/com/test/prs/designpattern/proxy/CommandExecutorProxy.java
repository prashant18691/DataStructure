package com.test.prs.designpattern.proxy;

import java.io.IOException;

public class CommandExecutorProxy implements CommandExecutor {
    boolean isAdmin;
    CommandExecutor executor;

    public CommandExecutorProxy(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password))
            isAdmin = true;
        executor = new CommandExecutorImpl();
    }

    @Override
    public Process executeCommand(String cmd) throws Exception {
        Process p = null;
        if (isAdmin)
           p = executor.executeCommand(cmd);
        else{
            if ("rm".startsWith(cmd))
                throw new IOException("rm commands is not accessible to non-admin users.");
            else {
            p =    executor.executeCommand(cmd);
            }
        }
        return p;
    }
}
