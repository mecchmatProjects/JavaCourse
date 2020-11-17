import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;
public class MyShowDocument extends JApplet {
private URL knu = null;
public String getMyURL() {
return "http://www.univ.kiev.ua";
}
public void paint(Graphics g) {
int timer = 0;
g.drawString("Завантаження сторінки", 10, 10);
try {
 for (; timer < 30; timer++) {
  g.drawString(".", 10 + timer * 5, 25);
  Thread.sleep(100);
 }
  knu = new URL(getMyURL());
  getAppletContext().showDocument(knu, "_blank");
 } catch (InterruptedException e) {
  e.printStackTrace();
} catch (MalformedURLException e) {
// некорректно задан протокол, доменное имя или путь к файлу
e.printStackTrace();
}
}
}
