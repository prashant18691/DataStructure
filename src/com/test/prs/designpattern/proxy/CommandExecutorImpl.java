package com.test.prs.designpattern.proxy;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public Process executeCommand(String cmd) throws IOException {
        return Runtime.getRuntime().exec(cmd);
    }
}
