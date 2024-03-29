package pt.bernardo;

import pt.bernardo.commands.Ajuda;
import pt.bernardo.commands.Entidades;
import pt.bernardo.listeners.Eventos;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pt.bernardo.listeners.Inventory;
import pt.bernardo.listeners.NPCEvents;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(getConfig().getString("Mensagem").replace("&", "§"));
        loadConfig();
        registerEvents();
        registerCommands();
        //startScheduler();
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
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

}