package com.Pherment.ImprovedBow.souls;

import com.Pherment.ImprovedBow.client.ClientSoulData;
import net.minecraft.nbt.CompoundTag;

public class PlayerSouls {
    private int souls;
    private final int MAX_SOULS = 10;
    private final int MIN_SOULS = 0;

    public int getSouls() {
        return souls;
    }

    public void addSouls(int add) {
        this.souls = Math.min(souls + add, MAX_SOULS);
    }

    public void subSouls(int sub) {
        this.souls = Math.max(souls - sub, MIN_SOULS);
    }

    public void copyForm(PlayerSouls source) {
        this.souls = source.souls;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("souls", souls);
    }

    public void loadNBTData(CompoundTag nbt) {
        souls = nbt.getInt("souls");
        ClientSoulData.set(this.souls);
    }
}
