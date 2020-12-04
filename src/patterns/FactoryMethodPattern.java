package patterns;

import java.util.function.Supplier;

public class FactoryMethodPattern {
  public static void main(String[] args) {
    Flooring floor = FlooringFactory.getFlooring(13, 46);
    floor.installation();
  }

  private interface Flooring {
    public void installation();
  }

  private static class FlooringFactory {
    static Supplier<Flooring> flooring;

    public static Flooring getFlooring(int minTemperature, int maxTemperature) {
      if (minTemperature <= 5 && maxTemperature <= 20) {
        flooring = WoodenFlooring::new;
      } else if (minTemperature <= 5 && maxTemperature >= 45) {
        flooring = CorkFlooring::new;
      } else {
        flooring = ConcreteFlooring::new;
      }

      return flooring.get();
    }
  }

  private static class WoodenFlooring implements Flooring {
    @Override
    public void installation() {
      System.out.println("The Wooden flooring is installed! ");
    }
  }

  private static class ConcreteFlooring implements Flooring {
    @Override
    public void installation() {
      System.out.println("The Concrete flooring is installed! ");
    }
  }

  private static class CorkFlooring implements Flooring {
    @Override
    public void installation() {
      System.out.println("The Cork flooring is installed! ");
    }
  }
}
