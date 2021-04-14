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
		int price = 100;
		int stats[] = {2, 2, 2, 2, 2, 2};
		String url = "Item/abdominial-armor.png";
		Gear abdominalArmor = new Gear(name, description, price, stats);
		abdominalArmor.setUrl(url);
		return abdominalArmor;
	}
	
	public static Gear CapeArmor() {
		String name = "Cape Armor";
		String description = "Increased Attack Damage and Critical chance.";
		int price = 200;
		int stats[] = {0, 0, 10, 10, 0, 0};
		String url = "Item/cape-armor.png";
		Gear capeArmor = new Gear(name, description, price, stats);
		capeArmor.setUrl(url);
		return capeArmor;
	}
	
	public static Gear HeartArmor() {
		String name = "Heart Armor";
		String description = "Highly increased Max HP.";
		int price = 200;
		int stats[] = {20, 0, 0, 0, 0, 0};
		String url = "Item/heart-armor.png";
		Gear heartArmor = new Gear(name, description, price, stats);
		heartArmor.setUrl(url);
		return heartArmor;
	}
	
	public static Gear LeatherArmor() {
		String name = "Leather Armor";
		String description = "Increased all stats.";
		int price = 50;
		int stats[] = {1, 1, 1, 1, 1, 1};
		String url = "Item/leather-armor.png";
		Gear leatherArmor = new Gear(name, description, price, stats);
		leatherArmor.setUrl(url);
		return leatherArmor;
	}
	
	public static Gear ShoulderArmor() {
		String name = "Shoulder Armor";
		String description = "Increased all stats. (Highly Increase Critical Damage)";
		int price = 500;
		int stats[] = {8, 8, 8, 8, 25, 8};
		String url = "Item/shoulder-armor.png";
		Gear shoulderArmor = new Gear(name, description, price, stats);
		shoulderArmor.setUrl(url);
		return shoulderArmor;
	}
	
	public static Gear Lamellar() {
		String name = "Lamellar";
		String description = "Increased all stats. (Highly Increase Defense)";
		int price = 1000;
		int stats[] = {10, 50, 10, 10, 10, 10};
		String url = "Item/lamellar.png";
		Gear lamellar = new Gear(name, description, price, stats);
		lamellar.setUrl(url);
		return lamellar;
	}
	
	public static Gear ChainMail() {
		String name = "Chain Mail";
		String description = "Increased all stats. (Highly Increase Dodge Chance.)";
		int price = 1000;
		int stats[] = {12, 12, 12, 12, 12, 35};
		String url = "Item/chain-mail.png";
		Gear chainMail = new Gear(name, description, price, stats);
		chainMail.setUrl(url);
		return chainMail;
	}
	
	public static Gear Breastplate() {
		String name = "Breastplate";
		String description = "Highly Increased all stats.";
		int price = 2000;
		int stats[] = {20, 20, 20, 20, 20, 20};
		String url = "Item/breastplate.png";
		Gear breastplate = new Gear(name, description, price, stats);
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
		int price = 100;
		int stats[] = {0, 0, 10, 0, 0, 0};
		String url = "Item/brutal-helm.png";
		Gear brutalHelm = new Gear(name, description, price, stats);
		brutalHelm.setUrl(url);
		return brutalHelm;
	}
	
	public static Gear BlackKnightHelm() {
		String name = "Black Knight Helm";
		String description = "Increased Critical chance and Critical Damage.";
		int price = 500;
		int stats[] = {0, 0, 0, 15, 15, 0};
		String url = "Item/brutal-helm.png";
		Gear blackKnightHelm = new Gear(name, description, price, stats);
		blackKnightHelm.setUrl(url);
		return blackKnightHelm;
	}
	
	public static Gear ClosedBarbute() {
		String name = "Closed Barbute";
		String description = "Increased Defense and Dodge chance.";
		int price = 500;
		int stats[] = {0, 15, 0, 0, 0, 15};
		String url = "Item/closed-barbute.png";
		Gear closedBarbute = new Gear(name, description, price, stats);
		closedBarbute.setUrl(url);
		return closedBarbute;
	}
	
	public static Gear CrenelCrown() {
		String name = "Crenel Crown";
		String description = "Increased all stats.";
		int price = 1000;
		int stats[] = {10, 10, 10, 10, 10, 10};
		String url = "Item/crenel-crown.png";
		Gear crenelCrown = new Gear(name, description, price, stats);
		crenelCrown.setUrl(url);
		return crenelCrown;
	}
	
	public static Gear JesterHat() {
		String name = "Jester hat";
		String description = "Increased all stats. (Highly increased Dodge Chance)";
		int price = 1000;
		int stats[] = {5, 5, 5, 5, 5, 20};
		String url = "Item/jester-hat.png";
		Gear jesterHat = new Gear(name, description, price, stats);
		jesterHat.setUrl(url);
		return jesterHat;
	}
	
	public static Gear SamuraiHelmet() {
		String name = "Samurai Helmet";
		String description = "Increased all stats. (Highly increased Attack)";
		int price = 1500;
		int stats[] = {8, 8, 30, 8, 8, 8};
		String url = "Item/samurai-helmet.png";
		Gear samuraiHelm = new Gear(name, description, price, stats);
		samuraiHelm.setUrl(url);
		return samuraiHelm;
	}
	
	public static Gear ElfHelmet() {
		String name = "Elf Helmet";
		String description = "Increased all stats. (Highly increased Max HP and Crit chance)";
		int price = 1500;
		int stats[] = {20, 7, 7, 20, 7, 7};
		String url = "Item/elf-helmet.png";
		Gear elfHelm = new Gear(name, description, price, stats);
		elfHelm.setUrl(url);
		return elfHelm;
	}
	
	public static Gear OverlordHelm() {
		String name = "Overlord helm";
		String description = "Highly increased all stats.";
		int price = 2000;
		int stats[] = {20, 20, 20, 20, 20, 20};
		String url = "Item/overload-helm.png";
		Gear overlordHelm = new Gear(name, description, price, stats);
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
		int price = 100;
		int stats[] = {2, 2, 2, 2, 2, 2};
		String url = "Item/tabi-boot.png";
		Gear tabiBoot = new Gear(name, description, price, stats);
		tabiBoot.setUrl(url);
		return tabiBoot;
	}
	
	public static Gear CowboyBoot() {
		String name = "Cowboy boot";
		String description = "Increased Crit chance.";
		int price = 500;
		int stats[] = {0, 0, 0, 10, 0, 0};
		String url = "Item/cowboy-boot.png";
		Gear cowboyBoot = new Gear(name, description, price, stats);
		cowboyBoot.setUrl(url);
		return cowboyBoot;
	}
	
	public static Gear FurBoot() {
		String name = "Fur boot";
		String description = "Increased Max HP.";
		int price = 500;
		int stats[] = {10, 0, 0, 0, 0, 0};
		String url = "Item/fur-boot.png";
		Gear furBoot = new Gear(name, description, price, stats);
		furBoot.setUrl(url);
		return furBoot;
	}
	
	public static Gear LegArmor() {
		String name = "Leg armor";
		String description = "Increased all stats.(Highly Increased Defense)";
		int price = 1000;
		int stats[] = {3, 20, 3, 3, 3, 3};
		String url = "Item/leg-armor.png";
		Gear legArmor = new Gear(name, description, price, stats);
		legArmor.setUrl(url);
		return legArmor;
	}
	
	public static Gear MetalBoot() {
		String name = "Metal boot";
		String description = "Increased all stats.(Highly increased Dodge Chance)";
		int price = 1000;
		int stats[] = {2, 2, 2, 2, 2, 25};
		String url = "Item/metal-boot.png";
		Gear metalBoot = new Gear(name, description, price, stats);
		metalBoot.setUrl(url);
		return metalBoot;
	}
	
	public static Gear SonicShoes() {
		String name = "Sonic Shoes";
		String description = "Increased all stats.(Highly increased Attack and Defense)";
		int price = 1500;
		int stats[] = {5, 25, 25, 5, 5, 5};
		String url = "Item/sonic-shoes.png";
		Gear tabiBoot = new Gear(name, description, price, stats);
		tabiBoot.setUrl(url);
		return tabiBoot;
	}
	
	public static Gear WalkingBoot() {
		String name = "Walking boot";
		String description = "Increased all stats.(Highly increased Critical chance and Critical damage)";
		int price = 1500;
		int stats[] = {2, 2, 2, 30, 30, 2};
		String url = "Item/walking-boot.png";
		Gear walkingBoot = new Gear(name, description, price, stats);
		walkingBoot.setUrl(url);
		return walkingBoot;
	}
	
	public static Gear Wingfoot() {
		String name = "Wingfoot";
		String description = "Highly increased all stats.";
		int price = 2000;
		int stats[] = {20, 20, 20, 20, 20, 20};
		String url = "Item/wingfoot.png";
		Gear wingfoot = new Gear(name, description, price, stats);
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
		int price = 500;
		int stats[] = {0, 0, 20, 0, 0, 20};
		String url = "Item/crossbow.png";
		Gear crossbow = new Gear(name, description, price, stats);
		crossbow.setUrl(url);
		return crossbow;
	}
	
	public static Gear PocketBow() {
		String name = "Pocket Bow";
		String description = "Increased Attack and Dodge chance.";
		int price = 2500;
		int stats[] = {10, 10, 40, 10, 10, 40};
		String url = "Item/pocket-bow.png";
		Gear pocketBow = new Gear(name, description, price, stats);
		pocketBow.setUrl(url);
		return pocketBow;
	}
	
	public static Gear BarbedSpear() {
		String name = "Barbed Spear";
		String description = "Increased Attack and Crit chance.";
		int price = 500;
		int stats[] = {0, 0, 20, 20, 0, 0};
		String url = "Item/barbed-spear.png";
		Gear barbedSpear = new Gear(name, description, price, stats);
		barbedSpear.setUrl(url);
		return barbedSpear;
	}
	
	public static Gear SpearHook() {
		String name = "Spear Hook";
		String description = "Increased Attack and Crit chance.";
		int price = 2500;
		int stats[] = {10, 10, 40, 40, 10, 10};
		String url = "Item/spear-hook.png";
		Gear spearHook = new Gear(name, description, price, stats);
		spearHook.setUrl(url);
		return spearHook;
	}
	
	public static Gear Broadsword() {
		String name = "Broadsword";
		String description = "Increased Attack and Crit damage.";
		int price = 500;
		int stats[] = {0, 0, 20, 0, 20, 0};
		String url = "Item/broadsword.png";
		Gear broadsword = new Gear(name, description, price, stats);
		broadsword.setUrl(url);
		return broadsword;
	}
	
	public static Gear RelicBlade() {
		String name = "Relic blade";
		String description = "Increased Attack and Crit damage.";
		int price = 2500;
		int stats[] = {10, 10, 40, 10, 40, 10};
		String url = "Item/relic-blade.png";
		Gear relicBlade = new Gear(name, description, price, stats);
		relicBlade.setUrl(url);
		return relicBlade;
	}
	
	public static Gear DragonShield() {
		String name = "Dragon Shield";
		String description = "Increased Defense";
		int price = 2500;
		int stats[] = {10, 35, 10, 10, 10, 10};
		String url = "Item/broadsword.png";
		Gear broadsword = new Gear(name, description, price, stats);
		broadsword.setUrl(url);
		return broadsword;
	}
	
	public static Gear WingedScepter() {
		String name = "Winged scepter";
		String description = "Increased Max HP.";
		int price = 2500;
		int stats[] = {50, 10, 10, 10, 40, 10};
		String url = "Item/winged-scepter.png";
		Gear wingedScepter = new Gear(name, description, price, stats);
		wingedScepter.setUrl(url);
		return wingedScepter;
	}
	
}
