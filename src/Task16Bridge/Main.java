package Task16Bridge;

public class Main {
    public static void main(String[] args) {
        System.out.println("The knight receives an enchanted sword.");
        var enchantedSword = new Sword(new SoulEatingEnchantment());
        enchantedSword.wield();
        enchantedSword.swing();
        enchantedSword.unwield();
        System.out.println("\n");

        System.out.println("The valkyrie receives an enchanted hammer.");
        var hammer = new Hammer(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
        System.out.println("\n");

        // New code to demonstrate the new type of weapon with the new enchantment
        System.out.println("The viking receives an enchanted axe.");
        var axe = new Axe(new IceEnchantment());
        axe.wield();
        axe.swing();
        axe.unwield();
        System.out.println("\n");
    }
}