package e.combatCore.pve.spawnEntities;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;


public class spawnModeCommand implements CommandExecutor {
    private static final Set<Player> spawnModePlayer = new HashSet<>();

    public static boolean isSpawnMode(Player player) {
        return spawnModePlayer.contains(player);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return false;
        }
        Player player = (Player) sender;

        if (isSpawnMode(player)) {
            spawnModePlayer.remove(player);
            player.sendMessage("You will no longer see spawnpoints");
        } else {
            spawnModePlayer.add(player);
            player.sendMessage("You will now see spawnpoints");
        }

        return false;
    }


}
