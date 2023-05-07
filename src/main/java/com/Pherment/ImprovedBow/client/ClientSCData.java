package com.Pherment.ImprovedBow.client;

public class ClientSCData {
    private static int playerSC;

    public static void set(int sc) {
        ClientSCData.playerSC = sc;
    }

    public static int getPlayerSC() {
        return playerSC;
    }
}
