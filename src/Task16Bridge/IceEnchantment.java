package Task16Bridge;

// New concrete class to implement Enchantment interface

public class IceEnchantment implements Enchantment{
    @Override
    public void onActivate() {
        System.out.println("The item begins to form ice crystals.");
    }

    @Override
    public void apply() {
        System.out.println("The item freezes the enemy upon touch.");
    }

    @Override
    public void onDeactivate() {
        System.out.println("The item's ice crystals melt.");
    }
}
