package e.combatCore.pve.spawnEntities;
import e.combatCore.pve.spawnEntities.spawnModeCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static java.lang.Math.floor;

public class spawnModeLogic implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player Player = event.getPlayer();
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)){
            return;
        }
        if(spawnModeCommand.isSpawnMode(Player)) {
            event.setCancelled(true);
            openGUI(Player);
        }

    }
    private void openGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 3*9, "Confirmation");
        Filler(gui);

        gui.setItem((9+(9/2)-1), new ItemStack(Material.RED_CONCRETE));
        gui.setItem((9+(9/2)+1), new ItemStack(Material.LIME_CONCRETE));

        player.openInventory(gui);

    }
    private void Filler(Inventory gui){
        ItemStack Filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack[] contents = new ItemStack[gui.getSize()];
        Arrays.fill(contents, Filler);
        gui.setContents(contents);
    }

}
