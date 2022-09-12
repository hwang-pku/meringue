package edu.neu.ccs.prl.meringue;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Classes implementing {@link FuzzFramework} must declare a public, zero-argument constructor.
 */
public interface FuzzFramework {
    void initialize(CampaignConfiguration config, Properties frameworkArguments)
            throws IOException, ReflectiveOperationException;

    Process startCampaign() throws IOException;

    File[] getCorpusFiles() throws IOException;

    File[] getFailureFiles() throws IOException;

    Class<? extends Replayer> getReplayerClass() throws ReflectiveOperationException;

    Collection<File> getRequiredClassPathElements();

    default boolean canRestartCampaign() {
        return false;
    }

    default Process restartCampaign() throws IOException {
        throw new UnsupportedOperationException();
    }

    default List<String> prepareForAnalysisPhase() throws IOException {
        return Collections.emptyList();
    }
}