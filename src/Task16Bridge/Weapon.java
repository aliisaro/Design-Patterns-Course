package Task16Bridge;

public interface Weapon {
    void wield();
    void swing();
    void unwield();

    Enchantment getEnchantment();
    Blessing getBlessing(); // new code
}

