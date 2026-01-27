package io.github.suel_ki.beautify.client;

import io.github.suel_ki.beautify.Beautify;
import io.github.suel_ki.beautify.client.tooltip.ClientPlantableItemStackTooltip;
import io.github.suel_ki.beautify.common.tooltip.PlantableItemStackTooltip;
import io.github.suel_ki.beautify.particle.ParticleInit;
import io.github.suel_ki.beautify.particle.custom.GlowEssenceParticles;
import io.github.suel_ki.beautify.util.ConfigScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@Mod(value = Beautify.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Beautify.MODID, value = Dist.CLIENT)
public class BeautifyClient  {

    public BeautifyClient(ModContainer container) {
        if (ModList.get().isLoaded("cloth_config")) ConfigScreen.register(container);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event){
        event.registerSpriteSet(ParticleInit.GLOWESSENCE_PARTICLES.get(), GlowEssenceParticles.Provider::new);
    }

    @SubscribeEvent
    public static void registerTooltipComponent(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(PlantableItemStackTooltip.class, ClientPlantableItemStackTooltip::get);
    }
}
