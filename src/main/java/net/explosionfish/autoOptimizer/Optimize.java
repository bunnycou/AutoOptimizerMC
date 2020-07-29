package net.explosionfish.autoOptimizer;

import com.google.common.io.Files;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public class Optimize implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {

            File bukkit = new File("bukkit.yml");
            File spigot = new File("spigot.yml");
            File paper = new File("paper.yml");
            File server = new File("server.properties");

            List<String> bukkitContentL = Files.readLines(bukkit, Charset.defaultCharset());
            List<String> spigotContentL = Files.readLines(spigot, Charset.defaultCharset());
            List<String> paperContentL = Files.readLines(paper, Charset.defaultCharset());
            List<String> serverContentL = Files.readLines(server, Charset.defaultCharset());

            String bukkitContent = "";
            String spigotContent = "";
            String paperContent = "";
            String serverContent = "";

            for (String str : bukkitContentL) { bukkitContent += str + "\n"; }
            for (String str : spigotContentL) { spigotContent += str + "\n"; }
            for (String str : paperContentL) { paperContent += str + "\n"; }
            for (String str : serverContentL) { serverContent += str + "\n"; }

            //bukkit.yml optimizations
            bukkitContent = bukkitContent.replaceAll("monsters: 70", "monsters: 50");
            bukkitContent = bukkitContent.replaceAll("animals: 10", "animals: 8");
            bukkitContent = bukkitContent.replaceAll("water-animals: 15", "water-animals: 3");
            bukkitContent = bukkitContent.replaceAll("ambient: 15", "ambient: 1");

            bukkitContent = bukkitContent.replaceAll("period-in-ticks: 600", "period-in-ticks: 400");

            bukkitContent = bukkitContent.replaceAll("monster-spawns: 1", "monster-spawns: 4");

            Files.write(bukkitContent, bukkit, Charset.defaultCharset());
            System.out.println("Optimized bukkit.yml");

            //spigot.yml optimizations
            spigotContent = spigotContent.replaceAll("save-user-cache-on-stop-only: false", "save-user-cache-on-stop-only: true");

            spigotContent = spigotContent.replaceAll("mob-spawn-range: 8", "mob-spawn-range: 5");

            spigotContent = spigotContent.replaceAll("tick-inactive-villagers: true", "tick-inactive-villagers: false");

            spigotContent = spigotContent.replaceAll("exp: 3.0", "exp: 6.0");
            spigotContent = spigotContent.replaceAll("item: 2.5", "item: 4.0");

            spigotContent = spigotContent.replaceAll("arrow-despawn-rate: 1200", "arrow-despawn-rate: 300");

            Files.write(spigotContent, spigot, Charset.defaultCharset());
            System.out.println("Optimized spigot.yml");

            //paper.yml optimizations
            paperContent = paperContent.replaceAll("max-auto-save-chunks-per-tick: 24", "max-auto-save-chunks-per-tick: 6");

            paperContent = paperContent.replaceAll("optimize-explosions: false", "optimize-explosions: true");

            paperContent = paperContent.replaceAll("mob-spawner-tick-rate: 1", "mob-spawner-tick-rate: 2");

            paperContent = paperContent.replaceAll("disable-chest-cat-detection: false", "disable-chest-cat-detection: true");

            paperContent = paperContent.replaceAll("container-update-tick-rate: 1", "container-update-tick-rate: 3");

            paperContent = paperContent.replaceAll("max-entity-collisions: 8", "max-entity-collsions: 2");

            paperContent = paperContent.replaceAll("grass-spread-tick-rate: 1", "grass-spread-tick-rate: 4");

            paperContent = paperContent.replaceAll("soft: 32", "soft: 28");
            paperContent = paperContent.replaceAll("hard: 128", "hard: 96");

            paperContent = paperContent.replaceAll("non-player-arrow-despawn-rate: -1", "non-player-arrow-despawn-rate: 60");
            paperContent = paperContent.replaceAll("creative-arrow-despawn-rate: -1", "creative-arrow-despawn-rate: 60");

            paperContent = paperContent.replaceAll("prevent-moving-into-unloaded-chunks: false", "prevent-moving-into-unloaded-chunks: true");

            paperContent = paperContent.replaceAll("use-faster-eigencraft-redstone: false", "use-faster-eigencraft-redstone: true");

            paperContent = paperContent.replaceAll("armor-stands-tick: true", "armor-stands-tick: false");

            paperContent = paperContent.replaceAll("alt-item-despawn-rate: false", "alt-item-despawn-rate: true");

            paperContent = paperContent.replaceAll("anti-xray:\n      enabled: false", "anti-xray:\n      enabled: true");

            Files.write(paperContent, paper, Charset.defaultCharset());
            System.out.println("Optimized paper.yml");

            //server.properties optimizations
            serverContent = serverContent.replaceAll("view-distance=10", "view-distance=6");
            serverContent = serverContent.replaceAll("network-compression-threshold=256", "network-compression-threshold=512");

            Files.write(serverContent, server, Charset.defaultCharset());
            System.out.println("Optimized server.properties");

            File jar = new File("plugins/autoOptimizer-1.0-SNAPSHOT.jar");
            jar.delete();

        } catch (Exception ex) {
            System.out.println("Something went wrong optimizing the files\n" + ex);
            ex.printStackTrace();
        }

        return false;
    }
}
