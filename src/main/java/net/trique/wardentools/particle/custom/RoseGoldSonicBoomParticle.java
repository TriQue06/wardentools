package net.trique.wardentools.particle.custom;

import net.minecraft.client.particle.ExplosionLargeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class RoseGoldSonicBoomParticle extends ExplosionLargeParticle {
    protected RoseGoldSonicBoomParticle(ClientWorld world, double x, double y, double z, double velocity, SpriteProvider spriteProvider) {
        super(world, x, y, z, velocity, spriteProvider);
        this.maxAge = 16;
        this.scale = 1.5f;
        this.setSpriteForAge(spriteProvider);
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world, double x, double y, double z,
                                       double vx, double vy, double vz) {
            return new RoseGoldSonicBoomParticle(world, x, y, z, vx, spriteProvider);
        }
    }
}