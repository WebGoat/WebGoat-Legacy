package org.owasp.webgoat.plugins;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class PluginTest {

    @Test
    public void pathShouldBeRewrittenInHtmlFile() throws Exception {
        Path tmpDir = PluginTestHelper.createTmpDir();
        Path pluginSourcePath = PluginTestHelper.pathForLoading();
        Plugin plugin = PluginTestHelper.createPluginFor(TestPlugin.class);
        Path htmlFile = Paths.get(pluginSourcePath.toString(), "lessonSolutions", "rewrite_test.html");
        plugin.loadFiles(Arrays.asList(htmlFile), true);
        plugin.rewritePaths(tmpDir);
        List<String> allLines = Files.readAllLines(htmlFile, StandardCharsets.UTF_8);

        assertThat(allLines,
            hasItem(containsString("plugin/TestPlugin/lessonSolutions/en/TestPlugin_files/image001.png")));
    }

    @Test
    public void shouldNotRewriteOtherLinks() throws Exception {
        Path tmpDir = PluginTestHelper.createTmpDir();
        Path pluginSourcePath = PluginTestHelper.pathForLoading();
        Plugin plugin = PluginTestHelper.createPluginFor(TestPlugin.class);
        Path htmlFile = Paths.get(pluginSourcePath.toString(), "lessonSolutions", "rewrite_test.html");
        plugin.loadFiles(Arrays.asList(htmlFile), true);
        plugin.rewritePaths(tmpDir);
        List<String> allLines = Files.readAllLines(htmlFile, StandardCharsets.UTF_8);

        assertThat(allLines,
            hasItem(containsString("Unknown_files/image001.png")));
    }
}