package jp.skypencil.jgit;

import org.eclipse.jgit.lib.ProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProgressMonitor implements ProgressMonitor {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void update(int arg0) {
        log.info("update: {}", arg0);
    }

    @Override
    public void start(int arg0) {
        log.info("started: {}", arg0);
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void endTask() {
        log.info("end");
    }

    @Override
    public void beginTask(String arg0, int arg1) {
        log.info("begin: {}, {}", arg0, arg1);
    }
}