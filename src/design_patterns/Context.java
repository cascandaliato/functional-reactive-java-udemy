package design_patterns;

public class Context {

  Strategy compressionStrategy;

  public void setCompressionStrategy(Strategy compressionStrategy) {
    this.compressionStrategy = compressionStrategy;
  }

  public void generateFile(String file) {
    compressionStrategy.compressFile(file);
  }
}
