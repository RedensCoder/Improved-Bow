package com.Pherment.ImprovedBow.client;

public class ClientNeedSCData {
    private static int needSC;

    public static void set(int sc) {
        ClientNeedSCData.needSC = sc;
    }

    public static int getNeedSC() {
        return needSC;
    }
}
