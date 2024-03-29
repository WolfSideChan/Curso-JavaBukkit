package pt.bernardo.entities;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pt.bernardo.utils.Item;

public class WelcomeInventory {

    private Inventory inv;

    public WelcomeInventory() {
        inv = Bukkit.createInventory(null, 9*3, "§6Menu de Loja");
        insertItens();
    }

    private void insertItens() {
        ItemStack i = new Item(Material.DIAMOND, 1, (short) 0).setName("&fItem 1").getItemstack();
        ItemStack i2 = new Item(Material.GOLD_INGOT, 1, (short) 0).setName("&fItem 2").getItemstack();

        inv.setItem(12, i);
        inv.setItem(14, i2);
    }

    public Inventory getInv() {
        return inv;
    }

}
