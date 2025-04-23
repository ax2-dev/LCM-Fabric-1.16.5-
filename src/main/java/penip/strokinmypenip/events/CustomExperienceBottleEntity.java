package penip.strokinmypenip.events;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class CustomExperienceBottleEntity extends ExperienceBottleEntity {
    private final int xpValue;
    public CustomExperienceBottleEntity(EntityType<? extends CustomExperienceBottleEntity> type, World world) {
        super(type, world);
        this.xpValue = 0;
    }
    public CustomExperienceBottleEntity(EntityType<? extends CustomExperienceBottleEntity> type,
                                        World world,
                                        double x, double y, double z,
                                        int xpValue) {
        super(type, world);
        this.xpValue = xpValue;
        this.refreshPositionAndAngles(x, y, z, this.yaw, this.pitch);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!world.isClient && world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) world;
            // spawn a single orb with xpValue
            ExperienceOrbEntity orb = new ExperienceOrbEntity(
                    world,
                    this.getX(), this.getY(), this.getZ(),
                    xpValue
            );
            serverWorld.spawnEntity(orb);
            this.remove();
        }
    }
}
