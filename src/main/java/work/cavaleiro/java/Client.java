package work.cavaleiro.java;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import work.cavaleiro.java.system.AdSystem;

@Getter
public class Client extends JavaPlugin {
    @Getter
    public static Client instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        AdSystem.initialize();
    }
}