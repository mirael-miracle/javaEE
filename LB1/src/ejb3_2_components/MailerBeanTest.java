package ejb3_2_components;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

public class MailerBeanTest extends TestCase {

public void test() throws Exception {

    final Context context = EJBContainer.createEJBContainer().getContext();

    final JobProcessor processor = (JobProcessor) context.lookup("java:global/async-methods/JobProcessor");

    final long start = System.nanoTime();

    // Queue up a bunch of work
    final Future<String> red = processor.addJob("red");
    final Future<String> orange = processor.addJob("orange");
    final Future<String> yellow = processor.addJob("yellow");
    final Future<String> green = processor.addJob("green");
    final Future<String> blue = processor.addJob("blue");
    final Future<String> violet = processor.addJob("violet");

    // Wait for the result -- 1 minute worth of work
    assertEquals("blue", blue.get());
    assertEquals("orange", orange.get());
    assertEquals("green", green.get());
    assertEquals("red", red.get());
    assertEquals("yellow", yellow.get());
    assertEquals("violet", violet.get());

    // How long did it take?
    final long total = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - start);

    // Execution should be around 9 - 21 seconds
    // The execution time depends on the number of threads available for asynchronous execution.
    // In the best case it is 10s plus some minimal processing time. 
    assertTrue("Expected > 9 but was: " + total, total > 9);
    assertTrue("Expected < 21 but was: " + total, total < 21);

  }
}