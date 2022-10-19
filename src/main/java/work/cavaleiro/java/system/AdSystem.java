package work.cavaleiro.java.system;

import org.bukkit.Bukkit;
import work.cavaleiro.java.Client;

import java.util.ArrayList;
import java.util.List;

public class AdSystem {

    private static final int count = 120;
    private static List<String> messages = new ArrayList<>();

    static {
        messages.add(Client.getInstance().getConfig().getString("system.ad"));
    }
    
    public static void initialize() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Client.getInstance(), new Runnable() {
            int timer = count;
            int index = 1;
            public void run() {
                timer -= 1;

                if (timer == 0) {
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(messages.get(index)));
                }

                index += 1;
                if (index >= messages.size())
                    index = 1;
            }
        }, 0, 20);
    }
}
