package penip.strokinmypenip.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LuckyBlockEventManager {
    private static final List<LuckyBlockEffect> EFFECTS = new ArrayList<>();

    public static void register(LuckyBlockEffect effect) {
        EFFECTS.add(effect);
    }

    public static void triggerRandom(World world, BlockPos pos) {
        if (EFFECTS.isEmpty()) return;
        Random rand = world.random;
        EFFECTS.get(rand.nextInt(EFFECTS.size())).apply(world, pos);
    }
}
