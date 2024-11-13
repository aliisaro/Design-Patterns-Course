package Task16Bridge;

public class Main {
    public static void main(String[] args) {
        System.out.println("The knight receives an enchanted and blessed sword.");
        var enchantedSword = new Sword(new SoulEatingEnchantment(), new HealingBlessing());
        enchantedSword.wield();
        enchantedSword.swing();
        enchantedSword.unwield();
        System.out.println("\n");

        System.out.println("The valkyrie receives an enchanted and blessed hammer.");
        var hammer = new Hammer(new FlyingEnchantment(), new ReflectionBlessing());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
        System.out.println("\n");

        System.out.println("The viking receives an enchanted and blessed axe.");
        var axe = new Axe(new IceEnchantment(), new ShieldingBlessing());
        axe.wield();
        axe.swing();
        axe.unwield();
        System.out.println("\n");
    }
}

