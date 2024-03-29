package pt.bernardo.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pt.bernardo.entities.WelcomeInventory;
import pt.bernardo.utils.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Ajuda implements CommandExecutor {

    private HashMap<Player, Long> ajuda = new HashMap<>();

    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {

        if (s instanceof ConsoleCommandSender) return true;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("ajuda")) {

            if (ajuda.containsKey(p) && !(System.currentTimeMillis() >= ajuda.get(p))) {
                p.sendMessage("§cAguarde " + converter(p) + " segundos para executar este comando.");
                return false;
            } else {
                ajuda.remove(p);
            }

            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));

            if (args.length == 0) {
                p.sendMessage("");
                p.sendMessage("Digite /ajuda 1 - Para o servidor");
                p.sendMessage("Digite /ajuda 2 - Para Youtube");
                return true;
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("1")) {
                    p.sendMessage("§aEste é a ajuda do Servidor");

                    ItemStack i = new Item(Material.GOLD_INGOT, 1, (short) 0)
                            .setName("&bOlá Mundo")
                            .setLore(Arrays.asList("§6Opah um ouro", "§fBem legal"))
                            .setEncantamento(Enchantment.DURABILITY, 2)
                            .getItemstack();

                    ItemStack picareta = new Item(Material.WOOD_PICKAXE, 1, (short) 0)
                            .setEncantamento(Enchantment.DIG_SPEED, 3)
                            .setInquebravel()
                            .getItemstack();

                    p.getInventory().addItem(i);
                    p.getInventory().addItem(picareta);


                    return true;

                } else {
                    p.sendMessage("§eEste é a ajuda do Youtube");
                    p.openInventory(new WelcomeInventory().getInv());
                    return true;
                }
            }

        }

        return false;
    }

    private long converter(Player p) {
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return 1+ TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }


}
