package b11.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.entities.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import b11.*;
import b11.content.*;
import b11.graphics.*;
// import b11.world.blocks.*;

import static mindustry.type.ItemStack.*;
import static mindustry.type.ItemStack.with;

public class B11Blocks implements ContentList{
	public static Block
	// distribution (d)
	d000, d001,
	// walls (w)
	w000, w001, w010, w011, w100, w101,
	// production (c)
	c0000, c0001, c0010, c0011, c0100, c0101,
	// power (p)
	p0000, p0001, p0010, p0011, p0100, p0101, p0110, p0111, p1000,
	// turret (t)
	t0000, t0001, t0010, t0011, t0100, t0101, t0110, t0111, t1000, t1001, t1010, t1011, t1100, t1101, t1110, t1111, tNUMBER_OVERFLOW
	;
	@Override
	public void load(){
		final int x = 5;
		final int y = 140;
		// distribution start
		d000 = new StackConveyor("d000"){{
			requirements(Category.distribution, with(B11Items.item00, 1));
			health = 10;
			localizedName = "d000";
			speed = 5.5f / 60f;
			itemCapacity = 2;
		}};
		d001 = new StackConveyor("d001"){{
			requirements(Category.distribution, with(B11Items.item00, 2, B11Items.item01, 1));
			health = 20;
			localizedName = "d001";
			speed = 11f / 60f;
			itemCapacity = 4;
		}};
		// distribution end
		// walls start
		w000 = new Wall("w000"){{
			requirements(Category.defense, with(B11Items.item00, 3, B11Items.item01, 3));
			localizedName = "w000";
			health = 80 * x;
			absorbLasers = true;
		}};
		w001 = new Wall("w001"){{
			requirements(Category.defense, with(B11Items.item01, 3, B11Items.item10, 3));
			localizedName = "w001";
			health = 95 * x;
			lightningChance = 0.05f;
		}};
		w010 = new Wall("w010"){{
			requirements(Category.defense, with(B11Items.item00, 6, B11Items.item01, 6));
			localizedName = "w010";
			size = 2;
			health = 80 * x * x;
			absorbLasers = true;
		}};
		w011 = new Wall("w011"){{
			requirements(Category.defense, with(B11Items.item01, 6, B11Items.item10, 6));
			localizedName = "w011";
			size = 2;
			health = 95 * x * x;
			lightningChance = 0.5f;
		}};
		w100 = new Wall("w100"){{
			requirements(Category.defense, with(B11Items.item00, 6, B11Items.item01, 6));
			localizedName = "w100";
			size = 3;
			health = 80 * x * x * x;
			absorbLasers = true;
		}};
		w101 = new Wall("w101"){{
			requirements(Category.defense, with(B11Items.item01, 6, B11Items.item10, 6));
			localizedName = "w101";
			size = 3;
			health = 95 * x * x * x;
			lightningChance = 0.5f;
		}};
		// walls end
		// production start
		c0000 = new GenericCrafter("c0000"){{
			requirements(Category.crafting, with(Items.copper, 20));
			craftEffect = B11Fx.craft;
			outputItem = new ItemStack(B11Items.item00, 2);
			craftTime = 35f;
			localizedName = "c0000";
			size = 1;
			health = y;
			hasPower = hasLiquids = false;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.05f;
			consumes.items(with(Items.copper, 2));
		}};
		c0001 = new GenericCrafter("c0001"){{
			requirements(Category.crafting, with(Items.copper, 45, Items.lead, 30));
			craftEffect = B11Fx.craft;
			updateEffect = Fx.none;
			outputItem = new ItemStack(B11Items.item01, 2);
			craftTime = 30f;
			localizedName = "c0001";
			size = 2;
			health = y * size * size;
			hasPower = true;
			hasLiquids = false;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.05f;
			consumes.power(0.5f);
			consumes.items(with(Items.copper, 2, Items.lead, 1));
		}};
		c0010 = new GenericCrafter("c0010"){{
			requirements(Category.crafting, with(Items.copper, 80, Items.lead, 45, Items.graphite, 28));
			craftEffect = B11Fx.craft;
			outputItem = new ItemStack(B11Items.item10, 3);
			craftTime = 54f;
			localizedName = "c0010";
			health = y * size * size;
			size = 3;
			hasPower = true;
			hasLiquids = false;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.05f;
			consumes.power(1.25f);
			consumes.items(with(Items.lead, 3, Items.coal, 2));
		}};
		c0011 = new GenericCrafter("c0011"){{
			requirements(Category.crafting, with(Items.copper, 115, Items.lead, 85, Items.graphite, 70, Items.silicon, 20));
			craftEffect = B11Fx.craft;
			health = y * size * size;
			updateEffect = Fx.pulverizeMedium;
			outputItem = new ItemStack(B11Items.item11, 5);
			craftTime = 54f;
			localizedName = "c0011";
			size = 4;
			hasPower = true;
			hasLiquids = false;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.05f;
			consumes.power(3f);
			consumes.items(with(Items.copper, 4, Items.silicon, 3));
		}};
		c0100 = new LiquidConverter("c0100"){{
			requirements(Category.crafting, with(B11Items.item00, 50, B11Items.item01, 35));
			outputLiquid = new LiquidStack(B11Liquids.liquid0, 1f);
			craftTime = 30f;
			localizedName = "c0100";
			size = 2;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			rotate = false;
			solid = true;
			outputsLiquid = true;
			consumes.power(1f);
			consumes.item(B11Items.item00);
			consumes.liquid(Liquids.water, 0.1f);
		}};
		c0101 = new LiquidConverter("c0101"){{
			requirements(Category.crafting, with(B11Items.item00, 65, B11Items.item01, 40, B11Items.item10, 25));
			outputLiquid = new LiquidStack(B11Liquids.liquid1, 1.5f);
			craftTime = 45f;
			localizedName = "c0101";
			size = 2;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			rotate = false;
			solid = true;
			outputsLiquid = true;
			consumes.power(1.1f);
			consumes.item(B11Items.item01);
			consumes.liquid(Liquids.water, 0.2f);
		}};
		// production end
		// power start
		p0000 = new BurnerGenerator("p0000"){{
			requirements(Category.power, with(B11Items.item00, 20, B11Items.item01, 20));
			powerProduction = 1f;
			localizedName = "p0000";
			itemDuration = 180f;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.03f;
		}};
		p0001 = new BurnerGenerator("p0001"){{
			requirements(Category.power, with(B11Items.item00, 45, B11Items.item01, 30));
			powerProduction = 1.75f;
			localizedName = "p0001";
			size = 2;
			itemDuration = 190f;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.03f;
		}};
		p0010 = new BurnerGenerator("p0010"){{
			requirements(Category.power, with(B11Items.item00, 60, B11Items.item01, 47, B11Items.item10, 20));
			powerProduction = 2.5f;
			localizedName = "p0010";
			size = 3;
			itemDuration = 190f;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.03f;
		}};
		p0011 = new PowerNode("p0011"){{
			requirements(Category.power, with(B11Items.item00, 4));
			localizedName = "p0011";
			maxNodes = 14;
			laserRange = 12;
		}};
		p0100 = new PowerNode("p0100"){{
			requirements(Category.power, with(B11Items.item00, 4));
			localizedName = "p0100";
			maxNodes = 21;
			size = 2;
			laserRange = 18;
		}};
		p0101 = new Battery("p0101"){{
			requirements(Category.power, with(B11Items.item00, 13, B11Items.item01, 12));
			consumes.powerBuffered(8000f);
			localizedName = "p0101";
			baseExplosiveness = 2.5f;
		}};
		p0110 = new Battery("p0110"){{
			requirements(Category.power, with(B11Items.item00, 39, B11Items.item01, 36));
			consumes.powerBuffered(150000f);
			localizedName = "p0110";
			baseExplosiveness = 8f;
		}};
		p0111 = new SolarGenerator("p0111"){{
			requirements(Category.power, with(B11Items.item00, 40, B11Items.item01, 55, B11Items.item10, 8));
			size = 2;
			localizedName = "p0111";
			powerProduction = 0.78f;
		}};
		p1000 = new SolarGenerator("p1000"){{
			requirements(Category.power, with(B11Items.item00, 80, B11Items.item01, 110, B11Items.item10, 15));
			size = 3;
			localizedName = "p1000";
			powerProduction = 1.59f;
		}};
		// power end
		// turret start
		t0000 = new ItemTurret("t0000") {{
			requirements(Category.turret, with(
				B11Items.item00, 25
			));
			size = 1;
			localizedName = "t0000";
			health = 200 * size * size;
			reloadTime = 20f;
			shots = 1;
			range = 18f * 8f;
			maxAmmo = 200;
			restitution = 0.02f;
			inaccuracy = 0f;
			ammo(
				B11Items.item00, B11Bullets.basicbullet1,
				B11Items.item01, B11Bullets.basicbullet2
			);
		}};
		t0001 = new ItemTurret("t0001") {{
			requirements(Category.turret, with(
				B11Items.item00, 30,
				B11Items.item01, 20
			));
			size = 2;
			localizedName = "t0001";
			health = 200 * size * size;
			reloadTime = 20f;
			shots = 2;
			range = 27f * 8f;
			maxAmmo = 200;
			restitution = 0.02f;
			inaccuracy = 0f;
			ammo(
				B11Items.item00, B11Bullets.basicbullet1,
				B11Items.item01, B11Bullets.basicbullet2
			);
		}};
		t0010 = new ItemTurret("t0010") {{
			requirements(Category.turret, with(
				B11Items.item00, 50,
				B11Items.item01, 25
			));
			size = 3;
			localizedName = "t0010";
			health = 200 * size * size;
			reloadTime = 20f;
			shots = 4;
			range = 36f * 8f;
			maxAmmo = 200;
			restitution = 0.04f;
			inaccuracy = 0.1f;
			heatColor = Color.valueOf("FF0000AA");
			ammo(
				B11Items.item00, B11Bullets.basicbullet3,
				B11Items.item01, B11Bullets.basicbullet4
			);
		}};
		t0011 = new PowerTurret ("t0011"){{
			requirements(Category.turret, with(B11Items.item00, 50, B11Items.item01, 25));
			shootType = B11Bullets.lightningbullet1;
			localizedName = "t0011";
			reloadTime = 30f;
			shootCone = 40f;
			rotateSpeed = 8f;
			powerUse = 2.8f;
			targetAir = true;
			range = 90f;
			shootEffect = Fx.lightningShoot;
			heatColor = Color.red;
			recoilAmount = 1f;
			size = 1;
			health = 260;
			shootSound = Sounds.spark;
		}};
		t0100 = new PowerTurret("t0100"){{
			requirements(Category.turret, with(B11Items.item00, 30, B11Items.item01, 35));
			range = 192f;
			localizedName = "t0100";
			chargeTime = 40f;
			chargeMaxDelay = 30f;
			recoilAmount = 2f;
			reloadTime = 60f;
			cooldown = 0.03f;
			powerUse = 5.7f;
			shootShake = 2f;
			heatColor = Color.red;
			size = 1;
			health = 260;
			targetAir = true;
			shootSound = Sounds.laser;
			shootType = B11Bullets.laserbullet1;
		}};
		t0101 = new PowerTurret("t0101"){{
			requirements(Category.turret, with(B11Items.item00, 50, B11Items.item01, 60, B11Items.item10, 30));
			range = 288f;
			localizedName = "t0101";
			chargeTime = 20f;
			chargeMaxDelay = 10f;
			recoilAmount = 2f;
			reloadTime = 60f;
			cooldown = 0.03f;
			powerUse = 5.7f;
			shootShake = 2f;
			heatColor = Color.red;
			size = 2;
			health = 260 * size * size;
			targetAir = true;
			shootSound = Sounds.laser;
			shootType = B11Bullets.laserbullet2;
		}};
		t0110 = new PowerTurret("t0110"){{
			requirements(Category.turret, with(B11Items.item00, 175, B11Items.item01, 154, B11Items.item10, 100));
			range = 288f;
			localizedName = "t0110";
			chargeTime = 120f;
			chargeMaxDelay = 60f;
			recoilAmount = 2f;
			reloadTime = 60f * 2f;
			cooldown = 0.03f;
			powerUse = 10f;
			shootShake = 2f;
			heatColor = Color.red;
			size = 3;
			health = 260 * size * size;
			targetAir = true;
			shootSound = Sounds.laser;
			shootType = B11Bullets.biglaserbullet;
		}};
		t0111 = new ItemTurret("t0111"){{
			requirements(Category.turret, with(B11Items.item00, 25, B11Items.item01, 8));
			ammo(
				B11Items.item00, B11Bullets.artillerybullet1,
				B11Items.item10, B11Bullets.artillerybullet2
			);
			localizedName = "t0111";
			heatColor = Color.red;
			targetAir = false;
			reloadTime = 50f;
			recoilAmount = 2f;
			range = 240f;
			inaccuracy = 0f;
			shootCone = 10f;
			health = 280;
			shootSound = Sounds.bang;
			limitRange(0f);
		}};
		t1000 = new ItemTurret("t1000"){{
			requirements(Category.turret, with(B11Items.item00, 60, B11Items.item01, 35, B11Items.item10, 30));
			ammo(
				B11Items.item00, B11Bullets.artillerybullet1,
				B11Items.item10, B11Bullets.artillerybullet2
			);
			localizedName = "t1000";
			heatColor = Color.red;
			shots = 2;
			size = 2;
			targetAir = false;
			reloadTime = 25f;
			recoilAmount = 2f;
			range = 280f;
			inaccuracy = 0f;
			shootCone = 10f;
			health = 280 * size * size;
			shootSound = Sounds.bang;
			limitRange(0f);
		}};
		t1001 = new ItemTurret("t1001"){{
			requirements(Category.turret, with(B11Items.item00, 120, B11Items.item01, 90, B11Items.item10, 75));
			ammo(
				B11Items.item00, B11Bullets.artillerybullet1,
				B11Items.item10, B11Bullets.artillerybullet2
			);
			localizedName = "t1001";
			heatColor = Color.red;
			shots = 4;
			size = 3;
			targetAir = false;
			reloadTime = 20f;
			recoilAmount = 2f;
			range = 300f;
			inaccuracy = 0f;
			shootCone = 10f;
			health = 285 * size * size;
			shootSound = Sounds.bang;
			limitRange(0f);
		}};
		int a = 6;
		t1010 = new ItemTurret("t1010"){{
			requirements(Category.turret, with(B11Items.item00, 25, B11Items.item01, 20, B11Items.item10, 15));
			ammo(
				B11Items.item10, B11Bullets.missile1,
				B11Items.item11, B11Bullets.missile2
			);
			reloadTime = 50f;
			burstSpacing = a;
			localizedName = "t1010";
			shots = 2;
			inaccuracy = xRand = 6f;
			range = 192f;
			size = 1;
			health = 300 * size * size;
			shootSound = Sounds.missile;

			limitRange(5f);
		}};
		t1011 = new ItemTurret("t1011"){{
			requirements(Category.turret, with(B11Items.item00, 70, B11Items.item01, 40, B11Items.item10, 30, B11Items.item11, 40));
			ammo(
				B11Items.item10, B11Bullets.missile1,
				B11Items.item11, B11Bullets.missile2
			);
			reloadTime = 30f;
			localizedName = "t1011";
			shots = 4;
			burstSpacing = a;
			inaccuracy = xRand = 7f;
			range = 240f;
			size = 2;
			health = 300 * size * size;
			shootSound = Sounds.missile;

			limitRange(5f);
		}};
		t1100 = new ItemTurret("t1100"){{
			requirements(Category.turret, with(B11Items.item00, 85, B11Items.item01, 55, B11Items.item10, 45, B11Items.item11, 55));
			ammo(
				B11Items.item10, B11Bullets.missile1,
				B11Items.item11, B11Bullets.missile2
			);
			reloadTime = 26f;
			localizedName = "t1100";
			shots = 6;
			burstSpacing = a;
			inaccuracy = xRand = 7f;
			range = 256f;
			size = 2;
			health = 300 * size * size;
			shootSound = Sounds.missile;

			limitRange(5f);
		}};
		t1101 = new ItemTurret("t1101"){{
			requirements(Category.turret, with(B11Items.item00, 50, B11Items.item01, 25));
			ammo(
				B11Items.item01, B11Bullets.flak1,
				B11Items.item10, B11Bullets.flak2,
				B11Items.item11, B11Bullets.flak3
			);
			xRand = 4f;
			localizedName = "t1101";
			reloadTime = 20f;
			range = 100f;
			size = 1;
			recoilAmount = 1f;
			rotateSpeed = 10f;
			inaccuracy = 0f;
			shootCone = 30f;
			shootSound = Sounds.shootSnap;
			health = 150 * size * size;
			limitRange();
		}};
		t1110 = new ItemTurret("t1110"){{
			requirements(Category.turret, with(B11Items.item00, 100, B11Items.item01, 75, B11Items.item11, 55));
			ammo(
				B11Items.item01, B11Bullets.flak1,
				B11Items.item10, B11Bullets.flak2,
				B11Items.item11, B11Bullets.flak3
			);
			xRand = 4f;
			localizedName = "t1110";
			reloadTime = 12f;
			range = 180f;
			size = 2;
			recoilAmount = 2f;
			rotateSpeed = 10f;
			inaccuracy = 0f;
			shootCone = 30f;
			shootSound = Sounds.shootSnap;
			health = 150 * size * size;
			limitRange();
		}};
		t1111 = new ItemTurret("t1111"){{
			requirements(Category.turret, with(B11Items.item00, 175, B11Items.item01, 160, B11Items.item11, 180));
			ammo(
				B11Items.item01, B11Bullets.flak1,
				B11Items.item10, B11Bullets.flak2,
				B11Items.item11, B11Bullets.flak3
			);
			xRand = 6f;
			localizedName = "t1111";
			reloadTime = 5f;
			range = 240f;
			size = 3;
			recoilAmount = 3f;
			rotateSpeed = 10f;
			inaccuracy = 0f;
			shootCone = 30f;
			heatColor = Color.valueOf("ffffff");
			shootSound = Sounds.shootSnap;
			health = 150 * size * size;
			limitRange();
		}};
		// turret end
	}
}
