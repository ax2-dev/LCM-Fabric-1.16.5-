package penip.strokinmypenip.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface LuckyBlockEffect {
    void apply(World world, BlockPos pos);
}