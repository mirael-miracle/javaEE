package ejb3_2_components;
import java.util.concurrent.Future;

import javax.ejb.AccessTimeout;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Lock;
import javax.ejb.Singleton;

@Singleton
public class MailerBean {
@Asynchronous

@AccessTimeout(-1)
public Future<String> addJob(String jobName) {

    // Pretend this job takes a while
    doSomeHeavyLifting();

    // Return our result
    return new AsyncResult<String>(jobName);
}

private void doSomeHeavyLifting() {
    try {
        Thread.sleep(SECONDS.toMillis(10));
    } catch (InterruptedException e) {
        Thread.interrupted();
        throw new IllegalStateException(e);
    }
  }
}