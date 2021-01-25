package design_patterns;

interface Burger {
  public void makeBurger();
}

public class DecoratorPattern {
  public static void main(String[] args) {
    Burger burger = new PlainBurger();
    burger.makeBurger();

    new CheeseBurgerDecorator(burger).makeBurger();
  }
}

class PlainBurger implements Burger {

  @Override
  public void makeBurger() {
    System.out.println("Plain burger is ready");
  }
}

abstract class BurgerDecorator extends PlainBurger {
  protected Burger burger;

  public BurgerDecorator(Burger burger) {
    this.burger = burger;
  }
}

class CheeseBurgerDecorator extends BurgerDecorator {

  public CheeseBurgerDecorator(Burger burger) {
    super(burger);
  }

  public void makeBurger() {
    burger.makeBurger();
    System.out.println("Cheese added");
  }
}
