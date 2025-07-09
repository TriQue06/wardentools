package net.trique.wardentools.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;
import net.trique.wardentools.entity.custom.SculkArrowEntity;

public class WardenEntities {

    public static final EntityType<SculkArrowEntity> SCULK_ARROW_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(WardenTools.MOD_ID, "sculk_arrow"),
            FabricEntityTypeBuilder.<SculkArrowEntity>create(SpawnGroup.MISC, SculkArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4)
                    .trackedUpdateRate(20)
                    .build()
    );

    public static void registerWardenEntities() {
        WardenTools.LOGGER.info("Register Warden Entities");
    }
}