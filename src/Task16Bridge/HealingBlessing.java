package Task16Bridge;

public class HealingBlessing implements Blessing {
    @Override
    public void bestow() {
        System.out.println("A warm aura surrounds the weapon, promoting healing.");
    }

    @Override
    public void withdraw() {
        System.out.println("The healing aura fades away.");
    }
}

