
import java.util.*;
import java.util.stream.*;


/**
  * Generates an account number using a generation strategy
  */
class NumberGenerator {

    // This may be any subclass of GenerationStrategy
    private final GenerationStrategy strategy;

    public NumberGenerator(GenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public String generate() {
        return strategy.generate();
    }

    public GenerationStrategy getStrategy() {
        return strategy;
    }
}

/**
  * Abstract generation strategy
  */
abstract class GenerationStrategy {

    abstract String generate();
}

/**
  * Concrete generation strategy. It generates number based on UUID
  */
class UUIDGenerationStrategy extends GenerationStrategy {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}

/**
  * Concrete generation strategy. It generates number based on the prefix and a random value
  */
class FormattedRandomGenerationStrategy extends GenerationStrategy {
    private final Random random = new Random();

    @Override
    public String generate() {
        return "111-123-" + Math.abs(random.nextInt());
    }
}

/*

// an example of using UUIDGeneratingStrategy
final NumberGenerator uuidGenerator = new NumberGenerator(new UUIDGeneratingStrategy());

System.out.println(uuidGenerator.generate());

// an example of using FormattedRandomGenerationStrategy
final NumberGenerator randomGenerator = new NumberGenerator(new FormattedRandomGenerationStrategy());

System.out.println(randomGenerator.generate());

*/

/**
  * Functional interface for the abstract generation strategy.
  * It's a String supplier
  */
@FunctionalInterface
interface GenerationStrategy {

    String generate();

}

/*

// It's instead of UUIDGeneratingStrategy
final NumberGenerator uuidGenerator = new NumberGenerator(() -> UUID.randomUUID().toString());
System.out.println(uuidGenerator.generate());

final Random random = new Random();
// Another simple generator for tests purposes
final NumberGenerator testGenerator = new NumberGenerator(() -> "test-" + String.valueOf(random.nextInt(100)));

System.out.println(testGenerator.generate());

*/


