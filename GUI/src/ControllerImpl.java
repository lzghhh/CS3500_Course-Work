import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

/**
 * Created by vidojemihajlovikj on 11/5/21.
 */
public class ControllerImpl implements IController, ViewListener {
  private final IModel model;
  private final IView view;

  public ControllerImpl(IModel model, IView view){
    this.model = Objects.requireNonNull(model);
    this.view = Objects.requireNonNull(view);
    this.view.addListener(this);
  }

  @Override
  public void go() {
    this.view.showView(true);
  }

  @Override
  public void saveDataEvent(String data) {
    model.setData(data);
  }

  @Override
  public void retrieveData() {
    String retrieved = model.getData();
    this.view.setData( retrieved );
  }


}
