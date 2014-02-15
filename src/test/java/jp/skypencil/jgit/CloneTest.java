package jp.skypencil.jgit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CloneTest {
    @Rule
    public TemporaryFolder directory = new TemporaryFolder();

    @Test
    public void cloneHttps() throws InvalidRemoteException, TransportException, GitAPIException, IOException {
        File local = directory.newFolder();
        CloneCommand clone = new CloneCommand();
        ProgressMonitor monitor = new SimpleProgressMonitor();
        clone.setBranch("master").setDirectory(local).setURI("https://github.com/eller86/jgit-trial.git").setProgressMonitor(monitor);
        clone.call();

        assertThat(new File(local, ".git").isDirectory(), is(true));
    }
}
