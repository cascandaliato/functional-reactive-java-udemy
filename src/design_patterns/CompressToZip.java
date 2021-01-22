package design_patterns;

public class CompressToZip implements Strategy {
  @Override
  public void compressFile(String fileName) {
    System.out.println(fileName + " has been compressed to .zip");
  }
}
