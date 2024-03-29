package pt.bernardo.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import pt.bernardo.utils.Item;

public class Eventos implements Listener {

    @EventHandler
    public static void quandoEntrar(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        p.sendMessage("§eSeja Bem-vindo ao Servidor");

        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cSeja Bem-vindo " + p.getName()));

        /*ItemStack item = new ItemBuilder(Material.MAGMA_CREAM)
                .setDisplayName("&cRankUP - Magma")
                .setLore()
                .build();

        ItemStack head = new SkullBuilder().setOwner("WolfSide_Chan")
                .setDisplayName("&6Cabeça de &b" + p.getDisplayName())
                .build();

        p.getInventory().addItem(item, head);*/




    }

    @EventHandler
    public static void quebrarBloco(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block bloco = e.getBlock();

        if (bloco.getType() != Material.GRASS) return;
        //p.sendMessage("Você quebrou um bloco de grama");
        //p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*10, 2));

        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);

        ItemStack item = p.getInventory().getItem(0);

        if (item!= null && item.getType() == Material.DIAMOND) {
            p.sendMessage("Que legal, você tem um " + item.getType().name() + " no inventário");
        }

        ItemStack elmo = new Item(Material.DIAMOND_HELMET, 1, (short) 0)
                .setName("&bElmo Mágico")
                .getItemstack();

        if (item != null) p.getInventory().setItem(0, item);


    }

    @EventHandler
    public static void quandoPingar(ServerListPingEvent e) {
        if (!Bukkit.hasWhitelist())
            e.setMotd("§aServidor ONLINE");
        else
            e.setMotd("§cServidor em Whitelist");
    }


}
