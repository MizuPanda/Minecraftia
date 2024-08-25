package com.mizupanda.minecraftia.models.events;

import com.mizupanda.minecraftia.models.handlers.StatsHandler;
import com.mizupanda.minecraftia.models.objects.EntityStat;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.slf4j.Logger;

@EventBusSubscriber(modid = "minecraftia")
public class EntityEventHandler {
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void onMobSpawn(FinalizeSpawnEvent event) {
        loadEntityStats(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerSpawn(PlayerEvent.PlayerLoggedInEvent event) {
        loadEntityStats(event.getEntity());

        // For debugging
        if (!event.getEntity().level().isClientSide) {
            final EntityStat stats = StatsHandler.getEntityStats(event.getEntity());
            LOGGER.info(stats.toString());
        }
    }

    private static void loadEntityStats(LivingEntity entity) {
        if (!entity.level().isClientSide) {
            StatsHandler.loadStatsFromNBT(entity);
        }
    }
}
