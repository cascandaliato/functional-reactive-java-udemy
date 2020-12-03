package patterns;

import java.util.function.Function;

public class DecoratorPattern {
  public static void main(String[] args) {
    Burger myOrder =
        new BurgerShop(Burger::addCheese).use(new BurgerShop(Burger::addVeggies).use(new Burger()));
    System.out.println("I get " + myOrder);
  }

  private static class BurgerShop {
    Function<Burger, Burger> decoration;

    public BurgerShop(Function<Burger, Burger> decoration) {
      this.decoration = decoration;
    }

    public Burger use(Burger baseBurger) {
      System.out.println("Base Burger: " + baseBurger);
      return decoration.apply(baseBurger);
    }
  }

  private static class Burger {

    private String burgerType;

    public Burger() {

      this.burgerType = "";
    }

    private Burger(String type) {
      this.burgerType = type;
    }

    public Burger addVeggies() {
      System.out.println("Adding vegies to the burger");
      return new Burger(this.burgerType += " Veggie");
    }

    public Burger addCheese() {
      System.out.println("Adding cheese to the burger");
      return new Burger(this.burgerType += " Cheese");
    }

    public String toString() {
      return String.format("%s", burgerType + " burger");
    }
  }
}
