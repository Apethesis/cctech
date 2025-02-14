package github.shrekshellraiser.cctech.common.block;

import github.shrekshellraiser.cctech.CCTech;
import github.shrekshellraiser.cctech.common.ModCreativeModeTab;
import github.shrekshellraiser.cctech.common.block.tape.CasetteDeckBlock;
import github.shrekshellraiser.cctech.common.block.tape.ReelToReelBlock;
import github.shrekshellraiser.cctech.common.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CCTech.MODID);

    public static final RegistryObject<Block> CASSETTE_DECK = registerBlock("cassette_deck",
            CasetteDeckBlock::new, ModCreativeModeTab.CCTECH_TAB);

    public static final RegistryObject<Block> REEL_TO_REEL = registerBlock("reel_to_reel",
            ReelToReelBlock::new, ModCreativeModeTab.CCTECH_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
