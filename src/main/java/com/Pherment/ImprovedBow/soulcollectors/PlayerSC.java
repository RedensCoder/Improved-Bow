package com.Pherment.ImprovedBow.soulcollectors;

import com.Pherment.ImprovedBow.client.ClientSCData;
import net.minecraft.nbt.CompoundTag;

public class PlayerSC {
    private int sc;
    private final int MIN_SC = 0;
    private final int MAX_SC = 100;

    public int getSC() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public void addSC(int add) {
        this.sc = Math.min(sc + add, MAX_SC);
    }

    public void subSouls(int sub) {
    this.sc = Math.max(sc - sub, MIN_SC);
    }

    public void copyForm(PlayerSC source) {
        this.sc = source.sc;
    }

    public void saveNBTData(CompoundTag nbt) {
        setSc(ClientSCData.getPlayerSC());
        nbt.putInt("sc", sc);
    }

    public void loadNBTData(CompoundTag nbt) {
        sc = nbt.getInt("sc");
        ClientSCData.set(this.sc);
    }
}
