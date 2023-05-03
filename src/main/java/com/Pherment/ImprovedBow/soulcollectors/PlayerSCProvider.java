package com.Pherment.ImprovedBow.soulcollectors;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerSCProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerSC> PLAYER_SC = CapabilityManager.get(new CapabilityToken<PlayerSC>() {});

    private PlayerSC sc = null;
    private final LazyOptional<PlayerSC> optional = LazyOptional.of(this::createPlayerSC);

    private PlayerSC createPlayerSC() {
        if (this.sc == null) {
            this.sc = new PlayerSC();
        }

        return this.sc;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_SC) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerSC().saveNBTData(nbt);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerSC().loadNBTData(nbt);
    }
}
