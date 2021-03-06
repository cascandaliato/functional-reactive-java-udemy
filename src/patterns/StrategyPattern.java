package patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPattern {
  public static void main(String[] args) {
    List<Stock> stockList = new ArrayList<>();

    stockList.add(new Stock("AAPL", 318.65, 10));
    stockList.add(new Stock("MSFT", 166.86, 45));
    stockList.add(new Stock("Google", 99, 12.5));

    StockFilters.bySymbol(stockList, "Google").forEach(System.out::println);
    System.out.println("---");
    StockFilters.byPriceAbove(stockList, 100.0).forEach(System.out::println);
    System.out.println("---");
    StockFilters.filter(stockList, stock -> stock.getSymbol().equals("MSFT"))
        .forEach(System.out::println);
    System.out.println("---");
    StockFilters.filter(stockList, stock -> stock.getPrice() > 100.0).forEach(System.out::println);
  }

  private static class StockFilters {
    public static List<Stock> bySymbol(List<Stock> list, String symbol) {
      List<Stock> filteredData = new ArrayList<>();
      for (Stock stock : list) {
        if (stock.getSymbol().equals(symbol)) {
          filteredData.add(stock);
        }
      }
      return filteredData;
    }

    public static List<Stock> byPriceAbove(List<Stock> list, double price) {
      List<Stock> filteredData = new ArrayList<>();
      for (Stock stock : list) {
        if (stock.getPrice() > price) filteredData.add(stock);
      }
      return filteredData;
    }

    public static List<Stock> filter(List<Stock> list, Predicate<Stock> p) {
      List<Stock> filteredData = new ArrayList<>();
      for (Stock stock : list) {
        if (p.test(stock)) filteredData.add(stock);
      }
      return filteredData;
    }
  }

  private static class Stock {
    private String symbol;
    private double price;
    private double units;

    public Stock(String symbol, double price, double units) {
      this.symbol = symbol;
      this.price = price;
      this.units = units;
    }

    @Override
    public String toString() {
      return "Stock{" + "symbol='" + symbol + '\'' + ", price=" + price + ", units=" + units + '}';
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public double getPrice() {
      return price;
    }

    public void setPrice(double price) {
      this.price = price;
    }

    public double getUnits() {
      return units;
    }

    public void setUnits(double units) {
      this.units = units;
    }
  }
}
