package bin0011.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import bin0011.content.*;

import static mindustry.type.ItemStack.with;

public class Bin0011Blocks implements ContentList {
	public static Block 
		
		
		// defense
		wall00, wallLarge00, wall01, wallLarge01,
		// power
		node000, node001, gen0000, gen0001, burner000, panel00, panel01,
		// turrets
		turret0000, turret0001, turret0010, turret0011, turret0100, turret0101,
		// production
		crft0000, crft0001, crft0010, crft0011, mcrft0000, mcrft0001;

	@Override
	public void load() {
		// reg defense
		wall00 = new Wall("wall00") {{
			requirements(Category.defense, with(
				Bin0011Items.item00, 6
			));
			localizedName = "wall00";
			size = 1;
			health = 400;
		}};
		wallLarge00 = new Wall("wall-large00") {{
			requirements(Category.defense, with(
				Bin0011Items.item00, 12
			));
			localizedName = "wallLarge00";
			size = 2;
			health = 1600;
		}};
		wall01 = new Wall("wall01") {{
			requirements(Category.defense, with(
				Bin0011Items.item01, 6
			));
			localizedName = "wall01";
			size = 1;
			health = 500;
			insulated = true;
			absorbLasers = true;
		}};
		wallLarge01 = new Wall("wall-large01") {{
			requirements(Category.defense, with(
				Bin0011Items.item01, 12
			));
			localizedName = "wallLarge01";
			size = 2;
			health = 2500;
			insulated = true;
			absorbLasers = true;
		}};
		// end defense
		// reg power
		node000 = new PowerNode("node000") {{
			requirements(Category.power, with(
				Bin0011Items.item00, 1,
				Bin0011Items.item01, 2
			));
			localizedName = "node000";
			health = 135;
			maxNodes = 25;
			laserRange = 19f;
		}};
		node001 = new PowerNode("node001") {{
			requirements(Category.power, with(
				Bin0011Items.item00, 4,
				Bin0011Items.item01, 8
			));
			localizedName = "node001";
			health = 270;
			maxNodes = 35;
			laserRange = 120f;
			size = 2;
		}};
		gen0000 = new SingleTypeGenerator("gen0000") {{
			requirements(Category.power, with(Bin0011Items.item00, 60, Bin0011Items.item01, 45, Bin0011Items.item10, 30));
			localizedName = "gen0000";
			health = 750;
			powerProduction = 4.2f;
			itemDuration = 240f;
			hasItems = true;
			size = 2;
			ambientSound = Sounds.steam;
			ambientSoundVolume = 0.03f;
			heatColor = Color.valueOf("FFFFFF99");
			consumes.item(Bin0011Items.item10);
		}};
		gen0001 = new SingleTypeGenerator("gen0001") {{
			requirements(Category.power, with(Bin0011Items.item00, 75, Bin0011Items.item01, 60, Bin0011Items.item10, 35, Bin0011Items.item11, 40));
			localizedName = "gen0001";
			health = 900;
			powerProduction = 7.5f;
			itemDuration = 240f;
			hasItems = true;
			hasLiquids = true;
			size = 2;
			ambientSound = Sounds.steam;
			ambientSoundVolume = 0.03f;
			heatColor = Color.valueOf("FFFFFF66");
			consumes.item(Bin0011Items.item10);
			consumes.liquid(Liquids.water, 0.1f);
		}};
		burner000 = new BurnerGenerator("burner000") {{
			requirements(Category.power, with(Bin0011Items.item00, 28, Bin0011Items.item01, 15));
			localizedName = "burner000";
			health = 185;
			powerProduction = 1.2f;
			itemDuration = 200f;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.04f;
			size = 2;
		}};
		panel00 = new SolarGenerator("panel00") {{
			requirements(Category.power, with(Bin0011Items.item00, 65, Bin0011Items.item01, 40, Bin0011Items.item10, 55));
			localizedName = "panel00";
			health = 175 * size * size;
			size = 2;
			powerProduction = 0.65f;
		}};
		panel01 = new SolarGenerator("panel01") {{
			requirements(Category.power, with(Bin0011Items.item00, 100, Bin0011Items.item01, 65, Bin0011Items.item10, 70));
			localizedName = "panel01";
			health = 200 * size * size;
			size = 3;
			powerProduction = 1.42f;
		}};
		// reg turret
		turret0000 = new ItemTurret("turret0000"){{
			requirements(Category.turret, with(Bin0011Items.item00, 28), true);
            		ammo(
				Bin0011Items.item00, Bullets.standardCopper,
				Bin0011Items.item01, Bullets.standardHoming,
				Bin0011Items.item11, Bullets.missileSurge
            		);
			localizedName = "turret0000";
            		spread = 4f;
           		shots = 2;
          		alternate = true;
           		reloadTime = 17.5f;
           		restitution = 0.03f;
           		range = 152;
           		shootCone = 15f;
           		ammoUseEffect = Fx.casing1;
           		health = 250;
           	 	inaccuracy = 2f;
           		rotateSpeed = 10f;

            		limitRange(0f);
        	}};
        	turret0001 = new ItemTurret("turret0001"){{
            		requirements(Category.turret, with(Bin0011Items.item00, 32, Bin0011Items.item01, 15));
            		ammo(
				Bin0011Items.item00, Bullets.artilleryDense,
				Bin0011Items.item01, Bullets.artilleryHoming
			);
			localizedName = "turret0001";
            		targetAir = false;
            		reloadTime = 50f;
            		recoilAmount = 1f;
           	 	range = 256f;
            		inaccuracy = 0.5f;
            		shootCone = 10f;
            		health = 325;
            		shootSound = Sounds.bang;
            		limitRange(0f);
        	}};
		turret0010 = new PowerTurret("turret0010"){{
			requirements(Category.turret, with(Bin0011Items.item00, 75, Bin0011Items.item01, 45, Bin0011Items.item10, 30));
            		localizedName = "turret0010";
			range = 192f;
            		chargeTime = 40f;
            		chargeMaxDelay = 25f;
            		chargeEffects = 9;
            		recoilAmount = 1.5f;
            		reloadTime = 50f;
            		cooldown = 0.05f;
            		powerUse = 4.7f;
            		shootShake = 2f;
            		shootEffect = Fx.shootBig;
            		smokeEffect = Fx.smokeCloud;
            		chargeEffect = Fx.none;
            		chargeBeginEffect = Fx.none;
            		size = 2;
            		health = 290 * size * size;
            		targetAir = true;
            		shootSound = Sounds.laser;
			
			shootType = new LaserBulletType(140){{
                		colors = new Color[]{Pal.darkestGray.a(1f), Pal.darkishGray, Color.white};
                		hitEffect = Fx.hitLancer;
                		hitSize = 6;
                		lifetime = 18f;
                		drawSize = 400f;
                		collidesAir = true;
                		length = 192f;
                		ammoMultiplier = 2f;
            		}};
        	}};
        	turret0011 = new TractorBeamTurret("turret0011"){{
            		requirements(Category.turret, with(Bin0011Items.item00, 100, Bin0011Items.item01, 70, Bin0011Items.item10, 45));

			localizedName = "turret0011";
            		hasPower = true;
            		size = 2;
            		force = 24f;
            		scaledForce =12f;
            		range = 360f;
            		damage = 1f;
            		health = 160 * size * size;
            		rotateSpeed = 10;

            		consumes.powerCond(3.5f, (TractorBeamBuild e) -> e.target != null);
		}};
        	turret0100 = new ItemTurret("turret0100"){{
            		requirements(Category.turret, with(Bin0011Items.item00, 250, Bin0011Items.item01, 75, Bin0011Items.item11, 57));
            		ammo(
				Bin0011Items.item00, Bullets.standardThorium,
				Bin0011Items.item01, Bullets.standardDenseBig,
				Bin0011Items.item10, Bullets.standardIncendiaryBig,
				Bin0011Items.item11, Bullets.standardThoriumBig
			);
			localizedName = "turret0100";
            		targetAir = true;
            		reloadTime = 90f;
			shots = 7;
            		recoilAmount = 1f;
			size = 2;
           	 	range = 192f;
            		inaccuracy = 0f;
            		shootCone = 10f;
            		health = 325 * size * size;
            		limitRange(0f);
        	}};
        	turret0101 = new ItemTurret("turret0101") {{
            		requirements(Category.turret, with(
				Bin0011Items.item00, 250, 
				Bin0011Items.item01, 175, 
				Bin0011Items.item11, 100
			));
            		ammo(
				Bin0011Items.item01, Bullets.missileExplosive,
				Bin0011Items.item10, Bullets.missileIncendiary,
				Bin0011Items.item11, Bullets.missileSurge
			);
			localizedName = "turret0101";
            		targetAir = true;
            		reloadTime = 3.5f;
			shots = 2;
            		recoilAmount = 1f;
			size = 2;
           	 	range = 250f;
            		inaccuracy = 0f;
            		shootCone = 10f;
            		health = 400 * size * size;
            		limitRange(0f);
        	}};
		// end turret
		// reg production
		crft0000 = new GenericCrafter("crft0000") {{
			requirements(Category.crafting, with(
				Items.copper, 60,
				Items.lead, 35
			));
			size = 3;
			localizedName = "crft0000";
			health = 280 * size * size;
			itemCapacity = 50;
			craftTime = 60f;
			craftEffect = Fx.smelt;
			drawer = new DrawSmelter(Color.valueOf("FFFFFF"));
			consumes.items(with(
				Items.copper, 2,
				Items.coal, 1
			));
			consumes.power(1.2f);
			outputItem = new ItemStack(Bin0011Items.item00, 2);
		}};
		crft0001 = new GenericCrafter("crft0001") {{
			requirements(Category.crafting, with(
				Items.copper, 45,
				Items.lead, 25,
				Items.silicon, 15
			));
			size = 3;
			localizedName = "crft0001";
			health = 290 * size * size;
			itemCapacity = 50;
			craftTime = 60f;
			craftEffect = Fx.smelt;
			drawer = new DrawSmelter(Color.valueOf("FFFFFF"));
			consumes.items(with(
				Items.copper, 2,
				Items.metaglass, 1,
				Items.lead, 1
			));
			consumes.power(1.3f);
			outputItem = new ItemStack(Bin0011Items.item01, 2);
		}};
		crft0010 = new GenericCrafter("crft0010") {{
			requirements(Category.crafting, with(
				Items.copper, 60,
				Items.lead, 45,
				Items.silicon, 40,
				Items.titanium, 35
			));
			size = 3;
			localizedName = "crft0010";
			health = 300 * size * size;
			itemCapacity = 65;
			craftTime = 45f;
			craftEffect = Fx.smokeCloud;
			consumes.items(with(
				Items.graphite, 2,
				Items.titanium, 1
			));
			consumes.power(1.4f);
			outputItem = new ItemStack(Bin0011Items.item10, 2);
		}};
		crft0011 = new GenericCrafter("crft0011") {{
			requirements(Category.crafting, with(
				Items.copper, 85,
				Items.silicon, 75,
				Items.titanium, 50
			));
			size = 3;
			localizedName = "crft0011";
			health = 325 * size * size;
			itemCapacity = 65;
			craftTime = 45f;
			craftEffect = Fx.smokeCloud;
			consumes.items(with(
				Items.titanium, 2,
				Items.silicon, 1
			));
			consumes.power(1.5f);
			outputItem = new ItemStack(Bin0011Items.item11, 2);
		}};
		// reg m i n i c r a f t e r s
		mcrft0000 = new GenericCrafter("mcrft0000") {{
			requirements(Category.crafting, with(
				Items.copper, 35,
				Items.lead, 12
			));
			size = 2;
			localizedName = "mcrft0000";
			health = 145 * size * size;
			itemCapacity = 25;
			craftTime = 90f;
			craftEffect = Fx.smelt;
			consumes.items(with(
				Items.copper, 1,
				Items.coal, 1
			));
			outputItem = new ItemStack(Bin0011Items.item00, 1);
		}};
		mcrft0001 = new GenericCrafter("mcrft0001") {{
			requirements(Category.crafting, with(
				Items.copper, 50,
				Items.graphite, 30,
				Items.lead, 45
			));
			size = 2;
			localizedName = "mcrft0001";
			health = 150 * size * size;
			itemCapacity = 25;
			craftTime = 90f;
			craftEffect = Fx.smokeCloud;
			consumes.items(with(
				Items.copper, 1,
				Items.lead, 2,
				Items.metaglass, 1
			));
			outputItem = new ItemStack(Bin0011Items.item01, 1);
		}};
		// end m i n i c r a f t e r s
		// end production
	}
}
