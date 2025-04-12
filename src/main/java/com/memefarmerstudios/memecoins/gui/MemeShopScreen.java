package com.memefarmerstudios.memecoins.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;

public class MemeShopScreen extends AbstractContainerScreen<MemeShopMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.parse("memecoins:textures/gui/meme_shop.png");

    public MemeShopScreen(MemeShopMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title.getString(), (this.imageWidth - this.font.width(this.title.getString())) / 2, 6, 4210752);
        guiGraphics.drawString(this.font, this.playerInventoryTitle.getString(), 8, this.imageHeight - 96 + 2, 4210752);
    }
}
