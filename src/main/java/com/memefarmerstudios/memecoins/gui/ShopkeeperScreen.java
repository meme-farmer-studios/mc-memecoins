package com.memefarmerstudios.memecoins.gui;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import javax.annotation.Nonnull;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

public class ShopkeeperScreen extends Screen {

    public ShopkeeperScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Map<String, Object>>>() {}.getType();
        Map<String, Map<String, Object>> itemValues;

        try (InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/memeconomy.json"))) {
            itemValues = gson.fromJson(reader, type);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int y = 20;
        for (Map.Entry<String, Map<String, Object>> entry : itemValues.entrySet()) {
            String itemName = entry.getKey();
            Map<String, Object> details = entry.getValue();
            int reward = ((Double) details.get("reward")).intValue();

            this.addRenderableWidget(Button.builder(Component.literal(itemName + " - Reward: " + reward), button -> {
                // Example trade logic: Print item name and reward to console
                System.out.println("Trading item: " + itemName + " with reward: " + reward);
            }).bounds(this.width / 2 - 100, y, 200, 20).build());

            y += 25;
        }
    }

    @Override
    public void render(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }
    @Override
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
