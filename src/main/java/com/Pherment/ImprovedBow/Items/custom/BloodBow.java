package com.Pherment.ImprovedBow.Items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BloodBow extends BowItem {
    private final double pDamage;
    private final float pDuration;
    private final int pLevel;

    public BloodBow(Properties properties, double damage, float duration, int level) {
        super(properties);
        this.pDamage = damage;
        this.pDuration = duration;
        this.pLevel = level;
    }
    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        arrow.setBaseDamage(arrow.getBaseDamage() + this.pDamage);
        return super.customArrow(arrow);
    }



    @Override
    public void releaseUsing(ItemStack pStack, Level p_40668_, LivingEntity p_40669_, int p_40670_) {
        if (p_40669_ instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
            ItemStack itemstack = player.getProjectile(pStack);

            int i = this.getUseDuration(pStack) - p_40670_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, p_40668_, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = this.getPowerTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, pStack, player));
                    if (!p_40668_.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(p_40668_, itemstack, player);
                        abstractarrow = customArrow(abstractarrow);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);

                        AbstractArrow abstractarrow2 = arrowitem.createArrow(p_40668_, itemstack, player);
                        abstractarrow2 = customArrow(abstractarrow2);
                        abstractarrow2.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 10.0F);

                        AbstractArrow abstractarrow3 = arrowitem.createArrow(p_40668_, itemstack, player);
                        abstractarrow3 = customArrow(abstractarrow3);
                        abstractarrow3.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, -10.0F);

                        if (f == 1.0F) {
                            abstractarrow.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
                        if (j > 0) {
                            abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
                        }

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
                        if (k > 0) {
                            abstractarrow.setKnockback(k);
                        }

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
                            abstractarrow.setSecondsOnFire(100);
                        }

                        if (pLevel >= 6) {
                            abstractarrow.setSecondsOnFire(100);
                        }

                        pStack.hurtAndBreak(1, player, (p_40665_) -> {
                            p_40665_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        if (pLevel >= 5) {
                            p_40668_.addFreshEntity(abstractarrow);
                            p_40668_.addFreshEntity(abstractarrow2);
                            p_40668_.addFreshEntity(abstractarrow3);
                        } else {
                            p_40668_.addFreshEntity(abstractarrow);
                        }
                    }

                    p_40668_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (p_40668_.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        if (pLevel >= 5 && pLevel < 8) {
                            itemstack.shrink(3);
                            if (itemstack.isEmpty()) {
                                player.getInventory().removeItem(itemstack);
                            }
                        } else if (pLevel >= 8) {
                            itemstack.shrink(0);
                            if (itemstack.isEmpty()) {
                                player.getInventory().removeItem(itemstack);
                            }
                        } else {
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                player.getInventory().removeItem(itemstack);
                            }
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public float getPowerTime(int pCharge) {
        float f = (float) pCharge / this.pDuration;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.translatable("tooltip.improvedbow.level_one_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
            if (this.pLevel >= 2) {
                components.add(Component.translatable("tooltip.improvedbow.level_two_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                if (this.pLevel >= 3) {
                    components.add(Component.translatable("tooltip.improvedbow.level_three_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                    if (this.pLevel >= 4) {
                        components.add(Component.translatable("tooltip.improvedbow.level_four_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                        if (this.pLevel >= 5) {
                            components.add(Component.translatable("tooltip.improvedbow.level_five_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                            if (this.pLevel >= 6) {
                                components.add(Component.translatable("tooltip.improvedbow.level_six_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                                if (this.pLevel >= 7) {
                                    components.add(Component.translatable("tooltip.improvedbow.level_seven_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                                    if (this.pLevel >= 8) {
                                        components.add(Component.translatable("tooltip.improvedbow.level_eight_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                                        if (this.pLevel >= 9) {
                                            components.add(Component.translatable("tooltip.improvedbow.level_nine_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                                            if (this.pLevel >= 10) {
                                                components.add(Component.translatable("tooltip.improvedbow.level_ten_info").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } else {
            components.add(Component.translatable("tooltip.improvedbow.press_shift").withStyle(ChatFormatting.AQUA));
        }

        super.appendHoverText(stack, pLevel, components, flag);
    }
}
