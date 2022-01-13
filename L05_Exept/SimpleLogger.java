
// http://www.javapractices.com/topic/TopicAction.do?Id=143

// java -Djava.util.logging.config.file=logging.properties
import java.util.logging.*;

/**
* Demonstrate Java's logging facilities, in conjunction
* with a logging config file.
*/
public final class SimpleLogger {

  public static void main(String... args) {
    SimpleLogger thing = new SimpleLogger();
    thing.doSomething();
  }

  public void doSomething() {
    //Log messages, one for each level
    //The actual logging output depends on the configured
    //level for this package. Calls to "inapplicable"
    //messages are inexpensive.
    logger.finest("this is finest");
    logger.finer("this is finer");
    logger.fine("this is fine");
    logger.config("this is config");
    logger.info("this is info");
    logger.warning("this is a warning");
    logger.severe("this is severe");

    //In the above style, the name of the class and
    //method which has generated a message is placed
    //in the output on a best-efforts basis only.
    //To ensure that this information is always
    //included, use the following "precise log"
    //style instead :
    logger.logp(Level.INFO, this.getClass().toString(), "doSomething", "blah");

    //For the very common task of logging exceptions, there is a
    //method which takes a Throwable :
    Throwable ex = new IllegalArgumentException("Some exception text");
    logger.log(Level.SEVERE, "Some message", ex);

    //There are convenience methods for exiting and
    //entering a method, which are at Level.FINER :
    logger.exiting(this.getClass().toString(), "doSomething");

    //Display user.home directory, if desired.
    //(This is the directory where the log files are generated.)
    //System.out.println("user.home dir: " + System.getProperty("user.home") );
  }

  // PRIVATE

  //This style has no hard-coded literals, and requires the logger
  //to be non-static.
  private final Logger logger=Logger.getLogger(this.getClass().getPackage().getName());

  //This style lets the logger be static, but hard-codes a class literal.
  //private static final Logger logger =
  //  Logger.getLogger(SimpleLogger.class.getPackage().getName())
  //;

  //This style uses a hard-coded literal and should likely be avoided:
  //private static final Logger logger = Logger.getLogger("myapp.business");
} 

