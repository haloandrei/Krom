package com.haloandrei.pj1game1.entity.spawner;

import com.haloandrei.pj1game1.entity.particle.Particle;
import com.haloandrei.pj1game1.entity.spawner.Spawner.Type;
import com.haloandrei.pj1game1.level.Level;

public class ParticleSpawner extends Spawner{

	private int life;
	
	public ParticleSpawner(int x, int y,int life, int amount, Level level,int type) {
		super(x, y, Type.PARTICLE, amount, level);
		this.life= life;
		for(int i= 0;i< amount ;i++)
			{
				level.add(new Particle(x,y,life,type));
			}
	}

}
