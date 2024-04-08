package pt.bernardo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pt.bernardo.commands.Ajuda;
import pt.bernardo.commands.Entidades;
import pt.bernardo.listeners.Eventos;
import pt.bernardo.listeners.Inventory;
import pt.bernardo.listeners.NPCEvents;
import pt.bernardo.managers.PlayerBlockManagers;
import pt.bernardo.utils.MYSQL;


public class Main extends JavaPlugin {

    public static Main instance;
    private static MYSQL mysql;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(getConfig().getString("Mensagem").replace("&", "§"));
        loadConfig();
        registerEvents();
        registerCommands();
        //startScheduler();
        mysql = new MYSQL("root", "vertrigo", "localhost", 3306, "aula");
        PlayerBlockManagers.insert();
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static MYSQL getMySQL() {
        return mysql;
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new Eventos(), this);
        Bukkit.getPluginManager().registerEvents(new Inventory(), this);
        Bukkit.getPluginManager().registerEvents(new NPCEvents(), this);
    }

    private void registerCommands() {
        getCommand("ajuda").setExecutor(new Ajuda());
        getCommand("entidade").setExecutor(new Entidades());
    }

   /* public void startScheduler() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {

            Bukkit.getConsoleSender().sendMessage("Olá");
            int online = Bukkit.getOnlinePlayers().size();
            System.out.println(online);

        }, 0, 20 * 5);
    }*/

    public Main getInstance() {
        return instance;
    }

}

