package net.trique.wardentools.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;

@Environment(EnvType.CLIENT)
public class SculkArrowRenderer extends ProjectileEntityRenderer<SculkArrowEntity> {

    private static final Identifier TEXTURE = Identifier.of(WardenTools.MOD_ID, "textures/entity/projectiles/sculk_arrow.png");

    public SculkArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(SculkArrowEntity entity) {
        return TEXTURE;
    }
}