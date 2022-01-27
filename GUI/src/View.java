import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by vidojemihajlovikj on 11/5/21.
 */
public class View extends JFrame implements IView, ActionListener, KeyListener, MouseListener {
  private final JButton submit;
  private final JButton retrieve;
  private final JButton submitItAgain;
  private final JTextField textArea;
  private final List<ViewListener> listenerList;

  public View(){
    super();
    setLayout( new FlowLayout());
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

    this.listenerList = new ArrayList<>();

    this.submitItAgain = new JButton("Submit it again");
    this.submitItAgain.setActionCommand("Submit");

    this.submit = new JButton("Submit");
    this.submit.setActionCommand("Submit");

    this.retrieve = new JButton("Retrieve");
    this.retrieve.setActionCommand("Retrieve");
    this.textArea = new JTextField(30);

    this.submit.addActionListener(this);
    this.retrieve.addActionListener(this);
    this.addKeyListener(this);

    add(this.submit);
    add(this.retrieve);
    add(this.textArea);
    add(this.submitItAgain);

    this.setFocusable(true);
    this.requestFocus();
    this.addMouseListener(this);

    this.pack();

  }
  //If we want to save more than one text:
  //change switch to use function objects.





  @Override
  public void showView(boolean show){
    this.setVisible(show);
  }


  @Override
  public void mouseClicked(MouseEvent e) {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public String getData() {
    return this.textArea.getText();
  }

  @Override
  public void setData(String data) {
    this.textArea.setText( Objects.requireNonNull(data));
  }

  @Override
  public void requestViewFocus() {
    this.setFocusable(true);
    this.requestFocus(true);
  }

  @Override
  public void addListener(ViewListener listener) {
    this.listenerList.add( Objects.requireNonNull(listener));
  }

  protected void emitSaveEvent(String data){
    for ( ViewListener listener : listenerList ){
      listener.saveDataEvent(data);
    }
  }

  protected void emitRetrieveEvent(){
    for ( ViewListener listener : listenerList ){
      listener.retrieveData();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch ( e.getActionCommand() ){
      case "Submit":
        emitSaveEvent( this.textArea.getText() );
        break;
      case "Retrieve":
       emitRetrieveEvent();
        break;
      default:
        throw new IllegalStateException("Unknown button pressed.");

    }

    this.requestViewFocus();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if ( e.getKeyChar() == 'g'){
     emitSaveEvent( this.textArea.getText() );
    }else if ( e.getKeyChar() == 'r'){
     emitRetrieveEvent();
    }
  }


  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
