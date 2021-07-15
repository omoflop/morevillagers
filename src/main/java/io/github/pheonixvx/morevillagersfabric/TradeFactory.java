package io.github.pheonixvx.morevillagersfabric;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

import java.util.Random;

public class TradeFactory implements TradeOffers.Factory {
    private final Item buyItem;
    private final int buyAmount;
    private final Item sellItem;
    private final int sellAmount;

    private final int maxUses;
    private final int experience;
    private final float multiplier;

    public TradeFactory(ItemConvertible sellItem, int sellAmount, ItemConvertible buyItem, int buyAmount, int maxUses, int experience) {
        this.buyItem = buyItem.asItem();
        this.buyAmount = buyAmount;
        this.sellItem = sellItem.asItem();
        this.sellAmount = sellAmount;
        this.maxUses = maxUses;
        this.experience = experience;
        this.multiplier = 0.05F;
    }

    public TradeOffer create(Entity entity, Random random) {
        return new TradeOffer(new ItemStack(buyItem, buyAmount), new ItemStack(sellItem, sellAmount), this.maxUses, this.experience, this.multiplier);
    }
}