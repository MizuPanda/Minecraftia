package com.mizupanda.minecraftia.models.events;

import com.mizupanda.minecraftia.models.StatEnum;
import com.mizupanda.minecraftia.models.handlers.StatsHandler;
import com.mizupanda.minecraftia.models.objects.EntityStat;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import org.slf4j.Logger;


@EventBusSubscriber(modid = "minecraftia")
public class AttackEventHandler {
    private static final Logger LOGGER = LogUtils.getLogger();


    @SubscribeEvent
    public static void onEntityHit(AttackEntityEvent event) {
        final Player player = event.getEntity();

            if (!player.level().isClientSide) {
                if (event.getTarget() instanceof LivingEntity target) {
                    // Get the StatsHandler from both the player and the target
                    EntityStat playerStats = StatsHandler.getEntityStats(player);
                    // EntityStat targetStats = StatsHandler.getEntityStats(target);

                    // Displaying Player Stats
                    LOGGER.info(player.getScoreboardName());
                    LOGGER.info(playerStats.toString());

                    // LOGGER.info("Target Stats:");
                    //LOGGER.info(targetStats.toString());

                    playerStats.increaseStat(StatEnum.STRENGTH, 1);
                    StatsHandler.saveStatToNBT(player, StatEnum.STRENGTH, playerStats.getStrength());
                }
            }

    }
}