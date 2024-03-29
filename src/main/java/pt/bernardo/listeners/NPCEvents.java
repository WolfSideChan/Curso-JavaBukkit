package pt.bernardo.listeners;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import pt.bernardo.entities.WelcomeInventory;

public class NPCEvents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if (!(e.getRightClicked() instanceof Villager)) return;
        Villager v = (Villager) e.getRightClicked();
        if (v.getCustomName() == null || !v.getCustomName().equalsIgnoreCase("§cFerreiro"))  return;
        e.setCancelled(true);
        Inventory inv = new WelcomeInventory().getInv();
        p.openInventory(inv);
        System.out.println("Codigo atualizado");
    }

}
