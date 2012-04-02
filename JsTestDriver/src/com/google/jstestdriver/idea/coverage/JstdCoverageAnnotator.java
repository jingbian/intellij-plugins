package com.google.jstestdriver.idea.coverage;

import com.intellij.coverage.SimpleCoverageAnnotator;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author Sergey Simonchik
 */
public class JstdCoverageAnnotator extends SimpleCoverageAnnotator {

  public JstdCoverageAnnotator(Project project) {
    super(project);
  }

  public static JstdCoverageAnnotator getInstance(@NotNull Project project) {
    return ServiceManager.getService(project, JstdCoverageAnnotator.class);
  }

  @Override
  protected FileCoverageInfo fillInfoForUncoveredFile(@NotNull VirtualFile file) {
    return new FileCoverageInfo();
  }

  @Override
  protected String getLinesCoverageInformationString(@NotNull FileCoverageInfo info) {
    if (info.totalLineCount == 0) {
      return "not covered";
    }
    else {
      return calcCoveragePercentage(info) + "% lines covered";
    }
  }
}
