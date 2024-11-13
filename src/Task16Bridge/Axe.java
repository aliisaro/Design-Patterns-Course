package Task16Bridge;

// New concrete class to implement Weapon

public class Axe implements Weapon {
    private final Enchantment enchantment;
    private final Blessing blessing;

    public Axe(Enchantment enchantment, Blessing blessing) {
        this.enchantment = enchantment;
        this.blessing = blessing;
    }

    @Override
    public void wield() {
        System.out.println("The axe is wielded.");
        blessing.bestow();
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("The axe is swung.");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        System.out.println("The axe is unwielded.");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
    @Override
    public Blessing getBlessing() {
        return blessing;
    }
}
