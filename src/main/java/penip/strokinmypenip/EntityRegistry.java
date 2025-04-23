package penip.strokinmypenip;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penip.strokinmypenip.events.CustomExperienceBottleEntity;

public class EntityRegistry {
    public static final String MOD_ID = "strokin-my-penip";
    public static final EntityType<CustomExperienceBottleEntity> CUSTOM_XP_BOTTLE =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MOD_ID, "custom_xp_bottle"),
                    FabricEntityTypeBuilder.<CustomExperienceBottleEntity>create(
                                    SpawnGroup.MISC,
                                    CustomExperienceBottleEntity::new
                            )
                            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                            .trackRangeBlocks(80)
                            .trackedUpdateRate(10)
                            .build()
            );

    public static void registerAll() {
    }
}
