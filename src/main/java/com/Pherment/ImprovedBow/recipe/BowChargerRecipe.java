package com.Pherment.ImprovedBow.recipe;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.client.ClientNeedSCData;
import com.Pherment.ImprovedBow.client.ClientSCData;
import com.Pherment.ImprovedBow.soulcollectors.PlayerSC;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BowChargerRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final int sc;

    public BowChargerRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, int sc) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.sc = sc;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        if (recipeItems.get(0).test(pContainer.getItem(0)) && recipeItems.get(1).test(pContainer.getItem(1)) && this.sc > ClientSCData.getPlayerSC()) {
            ClientNeedSCData.set(this.sc);

            return false;
        } else if (this.sc <= ClientSCData.getPlayerSC() && recipeItems.get(0).test(pContainer.getItem(0)) && recipeItems.get(1).test(pContainer.getItem(1))) {
            ClientNeedSCData.set(0);

            return true;
        }

        return false;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<BowChargerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "bow_Charger";
    }

    public static class Serializer implements RecipeSerializer<BowChargerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(ImprovedBow.MODID, "bow_charger");

        @Override
        public BowChargerRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            int sc = GsonHelper.getAsInt(pSerializedRecipe, "soul_collectors");

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new BowChargerRecipe(pRecipeId, output, inputs, sc);
        }

        @Override
        public @Nullable BowChargerRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            int sc = buf.readInt();

            return new BowChargerRecipe(pRecipeId, output, inputs, sc);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, BowChargerRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }

    public int getSc() {
        return this.sc;
    }
}
