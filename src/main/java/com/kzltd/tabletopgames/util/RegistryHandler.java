package com.kzltd.tabletopgames.util;

import com.kzltd.tabletopgames.TabletopGames;
import com.kzltd.tabletopgames.blocks.BlockItemBase;
import com.kzltd.tabletopgames.blocks.TableBlock;
import com.kzltd.tabletopgames.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TabletopGames.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TabletopGames.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> UNO_UPGRADE = ITEMS.register("uno_upgrade", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> TABLE_BLOCK = BLOCKS.register("table_block", TableBlock::new);

    // Block Items
    public static final RegistryObject<Item> TABLE_BLOCK_ITEM = ITEMS.register("table_block", () -> new BlockItemBase(TABLE_BLOCK.get()));

}
