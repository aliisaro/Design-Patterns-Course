package Task16Bridge;

// New concrete class to implement Weapon

public class Axe implements Weapon {
    private final Enchantment enchantment;

    public Axe(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        System.out.println("The axe is wielded.");
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
}
