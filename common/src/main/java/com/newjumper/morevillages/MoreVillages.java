package com.newjumper.morevillages;

import net.minecraft.resources.Identifier;

public class MoreVillages {
    public static final String MOD_ID = "morevillages";

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}