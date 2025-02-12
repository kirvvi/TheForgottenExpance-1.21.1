package net.kirvvi.theforgottenexpance.entity.client.pharaohseat;

import net.kirvvi.theforgottenexpance.entity.custom.PharaohSeatEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PharaohSeatRenderer extends EntityRenderer<PharaohSeatEntity> {
    public PharaohSeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PharaohSeatEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(PharaohSeatEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
