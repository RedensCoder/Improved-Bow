package com.Pherment.ImprovedBow.client;

public class ClientSoulData {
    private static int playerSouls;

    public static void set(int souls) {
        ClientSoulData.playerSouls = souls;
    }

    public static int getPlayerSouls() {
        return playerSouls;
    }
}
