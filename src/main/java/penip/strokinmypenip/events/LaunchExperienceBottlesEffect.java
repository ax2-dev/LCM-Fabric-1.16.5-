package penip.strokinmypenip.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import penip.strokinmypenip.EntityRegistry;
import java.util.Random;

public class LaunchExperienceBottlesEffect implements LuckyBlockEffect {
    @Override
    public void apply(World world, BlockPos pos) {
        if (world.isClient) return;

        final int bottleCount = 15;
        Random rand = world.random;
        int targetLevel = rand.nextInt(13) + 11;
        int totalXP = xpToReachLevel(targetLevel);
        int xpEach = totalXP / bottleCount;
        int remainder = totalXP % bottleCount;

        for (int i = 0; i < bottleCount; i++) {
            int xpValue = xpEach + (i < remainder ? 1 : 0);
            CustomExperienceBottleEntity bottle = new CustomExperienceBottleEntity(
                    EntityRegistry.CUSTOM_XP_BOTTLE,
                    world,
                    pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                    xpValue
            );
            double dx = (rand.nextDouble() - 0.5) * 0.5;
            double dz = (rand.nextDouble() - 0.5) * 0.5;
            bottle.setVelocity(dx, 0.7, dz);

            world.spawnEntity(bottle);
        }
    }

    private int xpToReachLevel(int level) {
        int xp = 0;
        for (int lv = 0; lv < level; lv++) {
            if (lv <= 15) {
                xp += 2 * lv + 7;
            } else if (lv <= 29) {
                xp += 5 * lv - 38;
            } else {
                xp += 9 * lv - 158;
            }
        }
        return xp;
    }
}
