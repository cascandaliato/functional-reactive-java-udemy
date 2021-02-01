package generics;

class BaseData<T> {}

public class Data<T> extends BaseData<T> implements IData<T> {

  private T data;

  public Data(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "data is: " + data;
  }
}
