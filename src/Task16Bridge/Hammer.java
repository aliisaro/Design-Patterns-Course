package Task16Bridge;

public class Hammer implements Weapon {

    private final Enchantment enchantment;
    private final Blessing blessing;

    public Hammer(Enchantment enchantment, Blessing blessing) {
        this.enchantment = enchantment;
        this.blessing = blessing;
    }

    @Override
    public void wield() {
        System.out.println("The hammer is wielded.");
        blessing.bestow();
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("The hammer is swung.");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        System.out.println("The hammer is unwielded.");
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