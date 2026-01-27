package io.github.suel_ki.beautify.particle;

import io.github.suel_ki.beautify.Beautify;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleInit {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
            .create(Registries.PARTICLE_TYPE, Beautify.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GLOWESSENCE_PARTICLES = PARTICLE_TYPES
            .register("glowessence_particles", () -> new SimpleParticleType(true));

}

