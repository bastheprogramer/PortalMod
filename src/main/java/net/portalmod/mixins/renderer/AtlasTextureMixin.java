package net.portalmod.mixins.renderer;

import net.minecraft.client.renderer.texture.AtlasTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AtlasTexture.class)
public class AtlasTextureMixin {
    @Inject(
            remap = false,
            method = "tick",
            at = @At("HEAD"),
            cancellable = true
    )
    private void pmFreezeAnimatedTextures(CallbackInfo info) {
        info.cancel();
    }
}