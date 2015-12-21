package net.minedust.system.lobby.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingBreakEvent.RemoveCause;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import net.minedust.system.lobby.plugin.Plugin_Main;

public class AllListeners implements Listener{
	
	@EventHandler
	public void onEnchantItem(EnchantItemEvent e){
		if(!e.getEnchanter().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onEntityBlockForm(EntityBlockFormEvent e){
		boolean cancel = true;
		if(e.getEntity() instanceof Player){
			if(((Player)e.getEntity()).getGameMode().equals(GameMode.CREATIVE))cancel = false;
		}
		e.setCancelled(cancel);
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof Player)e.setCancelled(true);
		else if(!e.getCause().equals(DamageCause.VOID))e.setCancelled(true);
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onEntityRegainHealth(EntityRegainHealthEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onHangingBreak(HangingBreakEvent e){
		if(!e.getCause().equals(RemoveCause.ENTITY))e.setCancelled(true);
	}
	
	@EventHandler
	public void onHangingBreakByEntity(HangingBreakByEntityEvent e){
		if(e.getRemover() instanceof Player){
			if(!((Player)e.getRemover()).getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onHangingPlace(HangingPlaceEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onItemDespawn(ItemDespawnEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onItemMerge(ItemMergeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent e){
		e.setCancelled(true);
	}
//TODO
	@EventHandler
	public void onPlayerAnimation(PlayerAnimationEvent e){
		if(e.getAnimationType().equals(PlayerAnimationType.ARM_SWING))e.setCancelled(true);
	}
//TODO
	@EventHandler
	public void onPlayerAchievementAwarded(PlayerAchievementAwardedEvent e){
		e.setCancelled(true);
	}
//TODO
	@EventHandler
	public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerBedEnter(PlayerBedEnterEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onBucketFill(PlayerBucketFillEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e){
		e.setDeathMessage("");
		e.setKeepInventory(true);
		e.setDroppedExp(0);
		e.setKeepLevel(true);
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerItemConsume(PlayerItemConsumeEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerPortal(PlayerPortalEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerShearEntity(PlayerShearEntityEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e){
		e.getEntity().remove();
	}
	
	@EventHandler
	public void onVehicleDestroy(VehicleDestroyEvent e){
		if(e.getAttacker() instanceof Player){
			if(!((Player)e.getAttacker()).getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
		}else e.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockBurn(BlockBurnEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getItem() != null)
		if(e.getItem().getType().equals(org.bukkit.Material.GRASS)){
			e.setCancelled(true);
			Plugin_Main.BungeeSendPlayer(e.getPlayer(), "Freebuild");
		}
	}
	
}
