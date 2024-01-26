package net.zepalesque.redux.block.natural.cloudcap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.zepalesque.redux.data.resource.ReduxConfiguredFeatures;

public class FungalGrowthBlock extends MossBlock {
    public FungalGrowthBlock(Properties p_153790_) {
        super(p_153790_);
    }

    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap((configuredFeatures) -> {
            return configuredFeatures.getHolder(ReduxConfiguredFeatures.FUNGAL_PATCH_BONEMEAL);
        }).ifPresent((feature) -> {
            feature.value().place(level, level.getChunkSource().getGenerator(), rand, pos.above());
        });
    }
}
