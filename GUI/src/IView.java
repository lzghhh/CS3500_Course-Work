import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by vidojemihajlovikj on 11/5/21.
 */
public interface IView extends IReadOnlyView, ViewEmitterFunctionality {
  void setData(String data);
  void requestViewFocus();
  void showView(boolean show);
}
