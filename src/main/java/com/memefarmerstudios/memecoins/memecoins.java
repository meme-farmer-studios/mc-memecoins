package com.memefarmerstudios.memecoins;

import com.memefarmerstudios.memecoins.blocks.BlockRegistry;
import com.memefarmerstudios.memecoins.gui.MemeShopMenu;
import com.memefarmerstudios.memecoins.gui.MemeShopScreen;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(memecoins.MODID)
public class memecoins {
    public static final String MODID = "memecoins";
    private static final Logger LOGGER = LogUtils.getLogger();

    // === Deferred Registers ===
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, MODID);

    // === Items ===
    public static final DeferredItem<Item> MEMECOIN =
        ITEMS.registerSimpleItem("memecoin", new Item.Properties().stacksTo(64));

    public static final DeferredItem<Item> MEME_SHOP_BLOCK_ITEM =
        ITEMS.register("meme_shop_block", () -> new BlockItem(BlockRegistry.MEME_SHOP_BLOCK.get(),
            new Item.Properties()));

    // === Creative Tab ===
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MEMECONOMY_TAB = CREATIVE_MODE_TABS.register("memeconomy_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(MEMECOIN.get())) // Use memecoin as the icon
                    .title(Component.translatable("itemGroup.memeconomy")) // Reference the lang key
                    .displayItems((params, output) -> {
                        output.accept(MEMECOIN.get()); // Add memecoin to the tab
                        output.accept(MEME_SHOP_BLOCK_ITEM.get()); // Add meme shop block to the tab
                    })
                    .build());

    // === Menu Types ===
    public static final DeferredHolder<MenuType<?>, MenuType<MemeShopMenu>> MEME_SHOP_MENU =
            MENUS.register("meme_shop_menu", () -> IMenuTypeExtension.create(MemeShopMenu::new));

    // === Constructor ===
    public memecoins(IEventBus modEventBus, ModContainer modContainer) {
        BlockRegistry.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus); // Register the creative tab
        MENUS.register(modEventBus); // Register menus
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void commonSetup(FMLCommonSetupEvent event) {
            LOGGER.info("HELLO FROM COMMON SETUP");
        }
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
    
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            // You can still enqueue work if you want, just not for menu screens
        }
    
        @SubscribeEvent
        public static void registerMenuScreens(net.neoforged.neoforge.client.event.RegisterMenuScreensEvent event) {
            event.register(MEME_SHOP_MENU.get(), MemeShopScreen::new);
        }
    }
}
