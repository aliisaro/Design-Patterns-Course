package Task16Bridge;

public class ReflectionBlessing implements Blessing {
    @Override
    public void bestow() {
        System.out.println("The blessing reflects part of the damage back to enemies.");
    }

    @Override
    public void withdraw() {
        System.out.println("The reflective aura fades.");
    }
}

