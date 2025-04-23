package penip.strokinmypenip.events;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChangeToSandEffect implements LuckyBlockEffect {
    @Override
    public void apply(World world, BlockPos pos) {
        world.setBlockState(pos, Blocks.SAND.getDefaultState());
    }
}
