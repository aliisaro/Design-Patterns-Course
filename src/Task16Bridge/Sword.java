package Task16Bridge;

public class Sword implements Weapon {

    private final Enchantment enchantment;
    private final Blessing blessing;

    public Sword(Enchantment enchantment, Blessing blessing) {
        this.enchantment = enchantment;
        this.blessing = blessing;
    }

    @Override
    public void wield() {
        System.out.println("The sword is wielded.");
        blessing.bestow();
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("The sword is swung.");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        System.out.println("The sword is unwielded.");
        enchantment.onDeactivate();
        blessing.withdraw();
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