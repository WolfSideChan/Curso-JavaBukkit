package pt.bernardo.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Inventory implements Listener {

    @EventHandler
    public void quandoClicar(InventoryClickEvent e) {
        if (e.getInventory().getName() != "§6Menu de Loja") return;
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();

        //VERIFICAÇÃO POR TIPO DE ITEM

        /*if (i.getType() == Material.DIAMOND) {
            p.closeInventory();
            p.sendMessage("§aVocê clicou em um diamante");
        }

        if (i.getType() == Material.GOLD_INGOT) {
            p.closeInventory();
            p.sendMessage("§6Você clicou no Ouro");
        }*/

        if (i == null) return;

        if (!(i.hasItemMeta() && i.getItemMeta().hasDisplayName())) return;



        if(i.getItemMeta().getDisplayName().equalsIgnoreCase("&fItem 1")) p.sendMessage("§aVocê clicou em um diamante");

        if (i.getItemMeta().getDisplayName().equalsIgnoreCase("&fItem 2")) p.sendMessage("§6Você clicou no Ouro");

    }

}
