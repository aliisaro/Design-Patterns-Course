package Task16Bridge;

public class ShieldingBlessing implements Blessing {
    @Override
    public void bestow() {
        System.out.println("A protective aura surrounds the weapon.");
    }

    @Override
    public void withdraw() {
        System.out.println("The protective aura fades away.");
    }
}

