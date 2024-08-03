package net.esromethestrange.esromes_apocalypse.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.esromethestrange.esromes_apocalypse.item.ApocalypseItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GlassBottleItem.class)
public abstract class EsromesApocalypseGlassBottleItemMixin {
    @Shadow protected abstract ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack);

    @Inject(
            method = "use",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/component/type/PotionContentsComponent;createStack(Lnet/minecraft/item/Item;Lnet/minecraft/registry/entry/RegistryEntry;)Lnet/minecraft/item/ItemStack;"),
            cancellable = true
    )
    public void esromes_apocalypse$onUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir, @Local BlockPos blockPos, @Local ItemStack itemStack){
        if(world.getFluidState(blockPos).isIn(ApocalypseTags.Fluids.CONTAMINATED_WATER))
            cir.setReturnValue(
                    TypedActionResult.success(this.fill(itemStack, user,
                            ApocalypseItems.CONTAMINATED_WATER_BOTTLE.getDefaultStack()),
                            world.isClient())
            );
    }
}
