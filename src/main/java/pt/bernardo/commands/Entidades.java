package pt.bernardo.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class Entidades implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("entidade")) {
            if (args.length == 0) {
                p.sendMessage("§aA entidade foi spawnada");
                spawnarNPC(p);
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("remover")) {
                    for (World world : Bukkit.getWorlds()) {
                        for (Entity en : world.getEntities()) {
                            if (en.getCustomName() != null) en.remove();;
                        }
                    }
                }
            }
        }

        return false;
    }

    /*private void spawnerEntidade(Player p) {

        Skeleton esqueleto = (Skeleton) p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);

        ItemStack i = new Item(Material.IRON_SWORD, 1, (short) 0).getItemstack();

        esqueleto.getEquipment().setItemInMainHand(i);
        esqueleto.getEquipment().setItemInMainHandDropChance(100);
        esqueleto.setCustomName("§cBoss NARINHA");
        esqueleto.setCustomNameVisible(true);
        esqueleto.setAI(false);

    }*/

    private void spawnarNPC(Player p) {
        Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
        villager.setCustomNameVisible(true);
        villager.setCustomName("§cFerreiro");
        villager.setProfession(Villager.Profession.BLACKSMITH);
        villager.setCareer(Villager.Career.WEAPON_SMITH);
        villager.setAI(false);
        //villager.setInvulnerable(true);
    }


}
