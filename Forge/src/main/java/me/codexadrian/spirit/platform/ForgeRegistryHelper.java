package me.codexadrian.spirit.platform;

import me.codexadrian.spirit.Constants;
import me.codexadrian.spirit.ForgeSpirit;
import me.codexadrian.spirit.blocks.soulcage.SoulCageBlock;
import me.codexadrian.spirit.blocks.soulcage.SoulCageBlockEntity;
import me.codexadrian.spirit.items.DivineCrystalItem;
import me.codexadrian.spirit.platform.services.IRegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ForgeRegistryHelper implements IRegistryHelper {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Constants.MODID);

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return ITEMS.register(id, item);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> item) {
        return BLOCKS.register(id, item);
    }

    @Override
    public <E extends BlockEntity, T extends BlockEntityType<E>> Supplier<T> registerBlockEntity(String id, Supplier<T> item) {
        return BLOCK_ENTITIES.register(id, item);
    }

    @Override
    public <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityFactory<E> factory, Block... blocks) {
        return BlockEntityType.Builder.of(factory::create, blocks).build(null);
    }

    @Override
    public CreativeModeTab registerCreativeTab(ResourceLocation tab, Supplier<ItemStack> supplier) {
        return new CreativeModeTab(tab.getNamespace() + "." + tab.getPath()) {
            @Override
            public ItemStack makeIcon() {
                return supplier.get();
            }
        };
    }


}
