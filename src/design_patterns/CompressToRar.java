package design_patterns;

public class CompressToRar implements Strategy {
  @Override
  public void compressFile(String fileName) {
    System.out.println(fileName + " has been compressed to .rar");
  }
}
