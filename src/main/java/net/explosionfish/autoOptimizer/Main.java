package net.explosionfish.autoOptimizer;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Server Optimization ready! Use at your own risk!");

        this.getCommand("optimize").setExecutor((CommandExecutor)new Optimize());

    }

    @Override
    public void onDisable() {
        System.out.println("Unable to optimize");
    }
}
