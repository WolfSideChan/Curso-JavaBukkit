package pt.bernardo.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Item {

    private ItemStack itemstack;
    private ItemMeta itemmeta;

    public Item(Material m, int quantidade, short data) {
        itemstack = new ItemStack(m, quantidade, data);
        itemmeta = itemstack.getItemMeta();
    }

    public Item setName(String nome) {
        itemmeta.setDisplayName(nome.replace("&", "§"));
        itemstack.setItemMeta(itemmeta);
        return this;
    }

    public ItemStack getItemstack() {
        return itemstack;
    }

    public Item setLore(List<String> lore){
        itemmeta.setLore(lore);
        itemstack.setItemMeta(itemmeta);
        return this;
    }

    public Item setEncantamento(Enchantment e, int forca) {
        itemmeta.addEnchant(e, forca, false);
        itemstack.setItemMeta(itemmeta);
        return this;
    }

    public Item setInquebravel() {
        itemmeta.setUnbreakable(true);
        itemstack.setItemMeta(itemmeta);
        return this;
    }

}
