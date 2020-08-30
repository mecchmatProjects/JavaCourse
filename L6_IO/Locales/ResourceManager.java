package class1;
import java.util.Locale;
import java.util.ResourceBundle;
public enum ResourceManager {
  INSTANCE;
  private ResourceBundle resourceBundle;
  private final String resourceName = "property.text";
  private ResourceManager() {
         resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
  }
  public void changeResource(Locale locale) {
         resourceBundle = ResourceBundle.getBundle(resourceName, locale);
  }
  public String getString(String key) {
         return resourceBundle.getString(key);
  }
}