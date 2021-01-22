package design_patterns;

public class StrategyDesignPattern {
  public static void main(String[] args) {
  Context con = new Context();
  con.setCompressionStrategy(new CompressToRar());
  con.generateFile("myFile.txt");
  }
}
