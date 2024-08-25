package com.mizupanda.minecraftia.models.handlers;

import com.mizupanda.minecraftia.Constants;
import com.mizupanda.minecraftia.models.StatEnum;
import com.mizupanda.minecraftia.models.objects.EntityStat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

public final class StatsHandler {
    private static final String STATS_TAG = "MinecraftiaEntityStats";

    public static void saveStatsToNBT(LivingEntity entity, EntityStat stats) {
        CompoundTag nbt = new CompoundTag();
        nbt.putDouble(Constants.STRENGTH_STAT, stats.getStrength());
        nbt.putDouble(Constants.SPEED_STAT, stats.getSpeed());
        nbt.putDouble(Constants.HEALTH_STAT, stats.getHealth());
        nbt.putDouble(Constants.DEFENSE_STAT, stats.getDefense());
        nbt.putDouble(Constants.AGILITY_STAT, stats.getAgility());
        nbt.putDouble(Constants.LUCK_STAT, stats.getLuck());

        entity.getPersistentData().put(STATS_TAG, nbt);
    }

    public static void saveStatToNBT(LivingEntity entity, StatEnum stat, double value) {
        // Retrieve the existing NBT tag or create a new one if it doesn't exist
        CompoundTag nbt = entity.getPersistentData().getCompound(STATS_TAG);

        // Save the specific stat based on the statName
        switch (stat) {
            case STRENGTH -> nbt.putDouble(Constants.STRENGTH_STAT, value);
            case SPEED -> nbt.putDouble(Constants.SPEED_STAT, value);
            case AGILITY -> nbt.putDouble(Constants.AGILITY_STAT, value);
            case HEALTH -> nbt.putDouble(Constants.HEALTH_STAT, value);
            case DEFENSE -> nbt.putDouble(Constants.DEFENSE_STAT, value);
            case LUCK -> nbt.putDouble(Constants.LUCK_STAT, value);
        }

        // Store the updated NBT data back into the entity's persistent data
        entity.getPersistentData().put(STATS_TAG, nbt);
    }

    public static void loadStatsFromNBT(LivingEntity entity) {
        if (!entity.getPersistentData().contains(STATS_TAG)) {
            final EntityStat stats = new EntityStat();
            saveStatsToNBT(entity, stats);
        }
    }

    public static EntityStat getEntityStats(LivingEntity entity) {
        final CompoundTag nbt = entity.getPersistentData();
        final EntityStat stats = new EntityStat();

        if (nbt.contains(STATS_TAG)) {
            final CompoundTag statsTag = nbt.getCompound(STATS_TAG);

            stats.fromNBT(statsTag);
        }

        return stats;
    }
}
