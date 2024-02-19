package com.eternalcode.core.scheduler;

public interface Task {

    void cancel();

    boolean isCancelled();

    boolean isAsync();

}
