package List;

import java.util.ArrayList;

import Item.Gear;

public class GearList {
	
	public static ArrayList<Gear> getAllGear(){
		ArrayList<Gear> gears = new ArrayList<Gear>();
		gears.add(AbdominalArmor());
		gears.add(CapeArmor());
		gears.add(HeartArmor());
		gears.add(Lamellar());
		gears.add(LeatherArmor());
		gears.add(ShoulderArmor());
		gears.add(ChainMail());
		gears.add(Breastplate());
		gears.add(BrutalHelm());
		gears.add(BlackKnightHelm());
		gears.add(ClosedBarbute());
		gears.add(CrenelCrown());
		gears.add(JesterHat());
		gears.add(SamuraiHelmet());
		gears.add(ElfHelmet());
		gears.add(OverlordHelm());
		gears.add(TabiBoot());
		gears.add(CowboyBoot());
		gears.add(FurBoot());
		gears.add(LegArmor());
		gears.add(MetalBoot());
		gears.add(SonicShoes());
		gears.add(WalkingBoot());
		gears.add(Wingfoot());
		gears.add(Crossbow());
		gears.add(PocketBow());
		gears.add(BarbedSpear());
		gears.add(SpearHook());
		gears.add(Broadsword());
		gears.add(RelicBlade());
		gears.add(DragonShield());
		gears.add(WingedScepter());
		gears.add(OldPants());
		gears.add(DragonScales());
		gears.add(SteelLeggings());
		gears.add(ElfLeggings());
		gears.add(LeggingsEarth());
		gears.add(LeatherLeggings());
		gears.add(SpiritLeggings());
		return gears;
	}
	
	public static ArrayList<Gear> getAllArmor() {
		ArrayList<Gear> armors = new ArrayList<Gear>();
		armors.add(AbdominalArmor());
		armors.add(CapeArmor());
		armors.add(HeartArmor());
		armors.add(Lamellar());
		armors.add(LeatherArmor());
		armors.add(ShoulderArmor());
		armors.add(ChainMail());
		armors.add(Breastplate());
		return armors;
	}
	
	public static Gear AbdominalArmor() {
		String name = "Abdoinial Armor";
		String description = "Increased all stats.";
		int price = 300;
		int stats[] = {200, 2, 200, 2, 2, 2};
		String url = "NewItem/A1.png";
		Gear abdominalArmor = new Gear(name, description, price, stats);
		abdominalArmor.setType(2);
		abdominalArmor.setUrl(url);
		return abdominalArmor;
	}
	
	public static Gear CapeArmor() {
		String name = "Cape Armor";
		String description = "Increased Attack Damage and Critical chance.";
		int price = 200;
		int stats[] = {0, 0, 100, 10, 0, 0};
		String url = "NewItem/A4.png";
		Gear capeArmor = new Gear(name, description, price, stats);
		capeArmor.setType(2);
		capeArmor.setUrl(url);
		return capeArmor;
	}
	
	public static Gear HeartArmor() {
		String name = "Heart Armor";
		String description = "Increased Max HP.";
		int price = 200;
		int stats[] = {200, 0, 0, 0, 0, 0};
		String url = "NewItem/A3.png";
		Gear heartArmor = new Gear(name, description, price, stats);
		heartArmor.setType(2);
		heartArmor.setUrl(url);
		return heartArmor;
	}
	
	public static Gear LeatherArmor() {
		String name = "Leather Armor";
		String description = "Increased all stats.";
		int price = 150;
		int stats[] = {100, 1, 100, 1, 1, 1};
		String url = "NewItem/A8.png";
		Gear leatherArmor = new Gear(name, description, price, stats);
		leatherArmor.setType(2);
		leatherArmor.setUrl(url);
		return leatherArmor;
	}
	
	public static Gear ShoulderArmor() {
		String name = "Shoulder Armor";
		String description = "Increased all stats. \n(Highly Increase Critical Damage)";
		int price = 900;
		int stats[] = {800, 8, 800, 8, 25, 8};
		String url = "NewItem/A5.png";
		Gear shoulderArmor = new Gear(name, description, price, stats);
		shoulderArmor.setType(2);
		shoulderArmor.setUrl(url);
		return shoulderArmor;
	}
	
	public static Gear Lamellar() {
		String name = "Heavy Armor";
		String description = "Increased all stats. \n(Highly Increase Defense)";
		int price = 1250;
		int stats[] = {1000, 50, 1000, 10, 10, 10};
		String url = "NewItem/A2.png";
		Gear lamellar = new Gear(name, description, price, stats);
		lamellar.setType(2);
		lamellar.setUrl(url);
		return lamellar;
	}
	
	public static Gear ChainMail() {
		String name = "Lamellar";
		String description = "Increased all stats. \n(Highly Increase Dodge Chance.)";
		int price = 2500;
		int stats[] = {1200, 12, 1200, 12, 12, 35};
		String url = "NewItem/A7.png";
		Gear chainMail = new Gear(name, description, price, stats);
		chainMail.setType(2);
		chainMail.setUrl(url);
		return chainMail;
	}
	
	public static Gear Breastplate() {
		String name = "Breastplate";
		String description = "Highly Increased all stats.";
		int price = 4500;
		int stats[] = {2000, 20, 2000, 20, 20, 20};
		String url = "NewItem/A6.png";
		Gear breastplate = new Gear(name, description, price, stats);
		breastplate.setType(2);
		breastplate.setUrl(url);
		return breastplate;
	}
	
	public static ArrayList<Gear> getAllHelmet() {
		ArrayList<Gear> helmets = new ArrayList<Gear>();
		helmets.add(BrutalHelm());
		helmets.add(BlackKnightHelm());
		helmets.add(ClosedBarbute());
		helmets.add(CrenelCrown());
		helmets.add(JesterHat());
		helmets.add(SamuraiHelmet());
		helmets.add(ElfHelmet());
		helmets.add(OverlordHelm());
		return helmets;
	}
	
	public static Gear BrutalHelm() {
		String name = "Brutal Helm";
		String description = "Increased Attack Damage.";
		int price = 1500;
		int stats[] = {0, 0, 1000, 0, 0, 0};
		String url = "NewItem/H2.png";
		Gear brutalHelm = new Gear(name, description, price, stats);
		brutalHelm.setType(1);
		brutalHelm.setUrl(url);
		return brutalHelm;
	}
	
	public static Gear BlackKnightHelm() {
		String name = "Black Knight Helm";
		String description = "Increased Critical chance and Critical Damage.";
		int price = 500;
		int stats[] = {0, 0, 0, 15, 15, 0};
		String url = "NewItem/H3.png";
		Gear blackKnightHelm = new Gear(name, description, price, stats);
		blackKnightHelm.setType(1);
		blackKnightHelm.setUrl(url);
		return blackKnightHelm;
	}
	
	public static Gear ClosedBarbute() {
		String name = "Closed Barbute";
		String description = "Increased Defense and Dodge chance.";
		int price = 500;
		int stats[] = {0, 15, 0, 0, 0, 15};
		String url = "NewItem/H5.png";
		Gear closedBarbute = new Gear(name, description, price, stats);
		closedBarbute.setType(1);
		closedBarbute.setUrl(url);
		return closedBarbute;
	}
	
	public static Gear CrenelCrown() {
		String name = "Crenel Crown";
		String description = "Increased all stats.";
		int price = 2800;
		int stats[] = {1000, 10, 1000, 10, 10, 10};
		String url = "NewItem/H6.png";
		Gear crenelCrown = new Gear(name, description, price, stats);
		crenelCrown.setType(1);
		crenelCrown.setUrl(url);
		return crenelCrown;
	}
	
	public static Gear JesterHat() {
		String name = "Chain Helmet";
		String description = "Increased all stats. \n(Highly increased Dodge Chance)";
		int price = 1700;
		int stats[] = {500, 5, 500, 5, 5, 20};
		String url = "NewItem/H8.png";
		Gear jesterHat = new Gear(name, description, price, stats);
		jesterHat.setType(1);
		jesterHat.setUrl(url);
		return jesterHat;
	}
	
	public static Gear SamuraiHelmet() {
		String name = "Last Hope";
		String description = "Increased all stats. \n(Highly increased Attack)";
		int price = 5000;
		int stats[] = {800, 8, 3000, 8, 8, 8};
		String url = "NewItem/H7.png";
		Gear samuraiHelm = new Gear(name, description, price, stats);
		samuraiHelm.setType(1);
		samuraiHelm.setUrl(url);
		return samuraiHelm;
	}
	
	public static Gear ElfHelmet() {
		String name = "Elf Helmet";
		String description = "Increased all stats. \n(Highly increased Max HP and Crit chance)";
		int price = 3500;
		int stats[] = {2000, 7, 700, 20, 7, 7};
		String url = "NewItem/H1.png";
		Gear elfHelm = new Gear(name, description, price, stats);
		elfHelm.setType(1);
		elfHelm.setUrl(url);
		return elfHelm;
	}
	
	public static Gear OverlordHelm() {
		String name = "Overlord helm";
		String description = "Highly increased all stats.";
		int price = 4500;
		int stats[] = {2000, 20, 2000, 20, 20, 20};
		String url = "NewItem/H4.png";
		Gear overlordHelm = new Gear(name, description, price, stats);
		overlordHelm.setType(1);
		overlordHelm.setUrl(url);
		return overlordHelm;
	}
	
	public static ArrayList<Gear> getAllShoes() {
		ArrayList<Gear> shoes = new ArrayList<Gear>();
		shoes.add(TabiBoot());
		shoes.add(CowboyBoot());
		shoes.add(FurBoot());
		shoes.add(LegArmor());
		shoes.add(MetalBoot());
		shoes.add(SonicShoes());
		shoes.add(WalkingBoot());
		shoes.add(Wingfoot());
		return shoes;
	}
	
	public static Gear TabiBoot() {
		String name = "Tabi boot";
		String description = "Increased all stats.";
		int price = 500;
		int stats[] = {200, 2, 200, 2, 2, 2};
		String url = "NewItem/B3.png";
		Gear tabiBoot = new Gear(name, description, price, stats);
		tabiBoot.setType(4);
		tabiBoot.setUrl(url);
		return tabiBoot;
	}
	
	public static Gear CowboyBoot() {
		String name = "Pirate boot";
		String description = "Increased Crit chance.";
		int price = 100;
		int stats[] = {0, 0, 0, 10, 0, 0};
		String url = "NewItem/B1.png";
		Gear cowboyBoot = new Gear(name, description, price, stats);
		cowboyBoot.setType(4);
		cowboyBoot.setUrl(url);
		return cowboyBoot;
	}
	
	public static Gear FurBoot() {
		String name = "Fur boot";
		String description = "Increased Max HP.";
		int price = 1390;
		int stats[] = {1000, 0, 0, 0, 0, 0};
		String url = "NewItem/B6.png";
		Gear furBoot = new Gear(name, description, price, stats);
		furBoot.setType(4);
		furBoot.setUrl(url);
		return furBoot;
	}
	
	public static Gear LegArmor() {
		String name = "Leg armor";
		String description = "Increased all stats.\n(Highly Increased Defense)";
		int price = 999;
		int stats[] = {300, 20, 300, 3, 3, 3};
		String url = "NewItem/B4.png";
		Gear legArmor = new Gear(name, description, price, stats);
		legArmor.setType(4);
		legArmor.setUrl(url);
		return legArmor;
	}
	
	public static Gear MetalBoot() {
		String name = "Metal boot";
		String description = "Increased all stats.\n(Highly increased Dodge Chance)";
		int price = 1750;
		int stats[] = {200, 2, 200, 2, 2, 25};
		String url = "NewItem/B8.png";
		Gear metalBoot = new Gear(name, description, price, stats);
		metalBoot.setType(4);
		metalBoot.setUrl(url);
		return metalBoot;
	}
	
	public static Gear SonicShoes() {
		String name = "Sonic Shoes";
		String description = "Increased all stats.\n(Highly increased Attack and Defense)";
		int price = 3200;
		int stats[] = {500, 25, 2500, 5, 5, 5};
		String url = "NewItem/B5.png";
		Gear tabiBoot = new Gear(name, description, price, stats);
		tabiBoot.setType(4);
		tabiBoot.setUrl(url);
		return tabiBoot;
	}
	
	public static Gear WalkingBoot() {
		String name = "Walking boot";
		String description = "Increased all stats.\n(Highly increased Critical chance and Critical damage)";
		int price = 1200;
		int stats[] = {200, 2, 200, 30, 30, 2};
		String url = "NewItem/B7.png";
		Gear walkingBoot = new Gear(name, description, price, stats);
		walkingBoot.setType(4);
		walkingBoot.setUrl(url);
		return walkingBoot;
	}
	
	public static Gear Wingfoot() {
		String name = "Heavy Boots";
		String description = "Highly increased all stats.";
		int price = 4100;
		int stats[] = {2000, 20, 2000, 20, 20, 20};
		String url = "NewItem/B2.png";
		Gear wingfoot = new Gear(name, description, price, stats);
		wingfoot.setType(4);
		wingfoot.setUrl(url);
		return wingfoot;
	}
	
	public static ArrayList<Gear> getAllWeapons() {
		ArrayList<Gear> weapons = new ArrayList<Gear>();
		weapons.add(Crossbow());
		weapons.add(PocketBow());
		weapons.add(BarbedSpear());
		weapons.add(SpearHook());
		weapons.add(Broadsword());
		weapons.add(RelicBlade());
		weapons.add(DragonShield());
		weapons.add(WingedScepter());
		return weapons;
	}
	
	public static Gear Crossbow() {
		String name = "Crossbow";
		String description = "Increased Attack and Dodge chance.";
		int price = 1950;
		int stats[] = {0, 0, 2000, 0, 0, 20};
		String url = "NewItem/W1.png";
		Gear crossbow = new Gear(name, description, price, stats);
		crossbow.setType(0);
		crossbow.setUrl(url);
		return crossbow;
	}
	
	public static Gear PocketBow() {
		String name = "Pocket Bow";
		String description = "Increased Attack and Dodge chance.";
		int price = 1100;
		int stats[] = {1000, 10, 0, 10, 10, 40};
		String url = "NewItem/W2.png";
		Gear pocketBow = new Gear(name, description, price, stats);
		pocketBow.setType(0);
		pocketBow.setUrl(url);
		return pocketBow;
	}
	
	public static Gear BarbedSpear() {
		String name = "Barbed Hammer";
		String description = "Increased Attack and Crit chance.";
		int price = 2225;
		int stats[] = {0, 0, 2000, 20, 0, 0};
		String url = "NewItem/W3.png";
		Gear barbedSpear = new Gear(name, description, price, stats);
		barbedSpear.setType(0);
		barbedSpear.setUrl(url);
		return barbedSpear;
	}
	
	public static Gear SpearHook() {
		String name = "Mace";
		String description = "Increased Attack and Crit chance.";
		int price = 4200;
		int stats[] = {0, 0, 4000, 40, 0, 0};
		String url = "NewItem/W4.png";
		Gear spearHook = new Gear(name, description, price, stats);
		spearHook.setType(0);
		spearHook.setUrl(url);
		return spearHook;
	}
	
	public static Gear Broadsword() {
		String name = "Broadsword";
		String description = "Increased Attack and Crit damage.";
		int price = 2175;
		int stats[] = {0, 0, 2000, 0, 20, 0};
		String url = "NewItem/W5.png";
		Gear broadsword = new Gear(name, description, price, stats);
		broadsword.setType(0);
		broadsword.setUrl(url);
		return broadsword;
	}
	
	public static Gear RelicBlade() {
		String name = "Relic blade";
		String description = "Increased Attack and Crit damage.";
		int price = 4100;
		int stats[] = {0, 0, 4000, 0, 40, 0};
		String url = "NewItem/W6.png";
		Gear relicBlade = new Gear(name, description, price, stats);
		relicBlade.setType(0);
		relicBlade.setUrl(url);
		return relicBlade;
	}
	
	public static Gear DragonShield() {
		String name = "Dragon Shield";
		String description = "Increased HP and Defense";
		int price = 2500;
		int stats[] = {1000, 35, 200, 10, 10, 10};
		String url = "NewItem/W7.png";
		Gear broadsword = new Gear(name, description, price, stats);
		broadsword.setType(0);
		broadsword.setUrl(url);
		return broadsword;
	}
	
	public static Gear WingedScepter() {
		String name = "Flame Staff";
		String description = "Increased all stats.";
		int price = 6500;
		int stats[] = {5000, 10, 1000, 10, 40, 10};
		String url = "NewItem/W8.png";
		Gear wingedScepter = new Gear(name, description, price, stats);
		wingedScepter.setType(0);
		wingedScepter.setUrl(url);
		return wingedScepter;
	}
	
	public static Gear OldPants() {
		String name = "Old pants";
		String description = "Increases all stats.";
		int price = 220;
		int stats[] = {100, 5, 100, 2, 2, 10};
		String url = "NewItem/P1.png";
		Gear gear = new Gear(name, description, price, stats);
		gear.setType(3);
		gear.setUrl(url);
		return gear;
	}
	
	public static Gear DragonScales() {
		String name = "Dragon Scales";
		String description = "Highly increases HP and Defense.";
		int price = 4500;
		int stats[] = {0, 50, 2000, 0, 0, 0};
		String url = "NewItem/P2.png";
		Gear gear = new Gear(name, description, price, stats);
		gear.setType(3);
		gear.setUrl(url);
		return gear;
	}
	
	public static Gear SteelLeggings() {
		String name = "Steel Leggings";
		String description = "Increases Defense.";
		int price = 1400;
		int stats[] = {0, 30, 500, 0, 0, 0};
		String url = "NewItem/P3.png";
		Gear gear = new Gear(name, description, price, stats);
		gear.setType(3);
		gear.setUrl(url);
		return gear;
	}
	
	public static Gear ElfLeggings() {
		String name = "Elf Leggings";
		String description = "Increases all stats.";
		int price = 1720;
		int stats[] = {850, 10, 500, 10, 10, 10};
		String url = "NewItem/P4.png";
		Gear gear = new Gear(name, description, price, stats);
		gear.setType(3);
		gear.setUrl(url);
		return gear;
	}
	
	public static Gear LeggingsEarth() {
		String name = "Leggings of Earth";
		String description = "Increases all stats.";
		int price = 3920;
		int stats[] = {1850, 5, 1500, 20, 50, 5};
		String url = "NewItem/P5.png";
		Gear gear = new Gear(name, description, price, stats);
		gear.setType(3);
		gear.setUrl(url);
		return gear;
	}
	
	public static Gear LeatherLeggings() {
		String name = "Leather Leggings";
		String description = "Increases Dodge Chance.";
		int price = 1200;
		int stats[] = {0, 0, 0, 0, 0, 30};
		String url = "NewItem/P6.png";
		Gear gear = new Gear(name, description, price, stats);
		gear.setType(3);
		gear.setUrl(url);
		return gear;
	}
	
	public static Gear SpiritLeggings() {
		String name = "Spirit Leggings";
		String description = "Increases Attack and Crit.";
		int price = 1200;
		int stats[] = {1800, 0, 0, 20, 50, 0};
		String url = "NewItem/P7.png";
		Gear gear = new Gear(name, description, price, stats);
		gear.setType(3);
		gear.setUrl(url);
		return gear;
	}
	
}
