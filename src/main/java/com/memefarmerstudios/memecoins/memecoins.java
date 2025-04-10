package com.memefarmerstudios.memecoins;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(memecoins.MODID)
public class memecoins {
    public static final String MODID = "memecoins";
    private static final Logger LOGGER = LogUtils.getLogger();

    // === Deferred Registers ===
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // === Items ===
    public static final DeferredItem<Item> MEMECOIN = ITEMS.registerSimpleItem("memecoin", new Item.Properties().stacksTo(64));

    // === Constructor ===
    public memecoins(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);
    }

    // === Client Events ===
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
        }
    }
}
