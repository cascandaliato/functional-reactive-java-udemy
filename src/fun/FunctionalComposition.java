package fun;

public class FunctionalComposition {
  public static void main(String[] args) {
    //    Function<Square, Integer> fun1 = s -> s.getArea();
    Function<Square, Integer> fun1 = Square::getArea;
    Function<Integer, Double> fun2 = Math::sqrt;

    Function<Square, Double> getSide = fun2.compose(fun1);

    Square s = new Square();
    s.setArea(100);

    Double side = getSide.apply(s);
    System.out.println(side);
  }

  private interface Function<T, R> {
    R apply(T t);

    default <V> Function<V, R> compose(Function<V, T> before) {
      return v -> this.apply(before.apply(v));
    }
  }

  private static class Square {
    private int area;

    public int getArea() {
      return area;
    }

    public void setArea(int area) {
      this.area = area;
    }
  }
}
