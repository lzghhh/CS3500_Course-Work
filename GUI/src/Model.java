import java.util.Objects;

/**
 * Created by vidojemihajlovikj on 11/5/21.
 */
public class Model implements IModel {
  private String data;
  @Override
  public String getData() {
    return data.toUpperCase();
  }

  @Override
  public void setData(String data) {
    this.data = Objects.requireNonNull(data);
  }
}
