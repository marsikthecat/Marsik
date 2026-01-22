package org.example.internals;

import java.util.HashMap;

public class MarsikThread {

  private static HashMap<Integer, Thread> threads;

  private static final Object GLOBAL_LOCK = new Object();

  public static void create(int id, Runnable job) {
    Thread thread = new Thread(job, String.valueOf(id));
    threads.put(id, thread);
  }

  public static void start(int id) {
    Thread thread = threads.get(id);
    thread.start();
  }

  public void join(int id) {
    Thread thread = threads.get(id);
    if (thread != null) {
      try {
        thread.join();
      } catch (InterruptedException _) {}
    }
  }

  public static void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException _) {}
  }

  public static void locked(Runnable block) {
    synchronized (GLOBAL_LOCK) {
      block.run();
    }
  }

  public static boolean isAlive(int id) {
    Thread thread = threads.get(id);
    if (thread != null) {
      return thread.isAlive();
    }
    return false;
  }
}