package com.github.path

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.impl.status.EditorBasedWidget
import com.intellij.util.Consumer
import git4idea.repo.GitRepositoryManager
import java.awt.datatransfer.StringSelection
import java.awt.event.MouseEvent

class AbsolutePathWidget(project: Project) : EditorBasedWidget(project), StatusBarWidget.IconPresentation {

    override fun ID(): String = "PathCopier.AbsolutePath"

    override fun getPresentation(): StatusBarWidget.WidgetPresentation = this

    override fun getIcon() = com.intellij.icons.AllIcons.Actions.Copy

    override fun getClickConsumer(): Consumer<MouseEvent> = Consumer {
        val file = FileEditorManager.getInstance(project).selectedEditor?.file ?: return@Consumer
        CopyPasteManager.getInstance().setContents(StringSelection(file.path))
    }

    override fun getTooltipText(): String = "Copy absolute path"
}

class RelativePathWidget(project: Project) : EditorBasedWidget(project), StatusBarWidget.IconPresentation {

    override fun ID(): String = "PathCopier.RelativePath"

    override fun getPresentation(): StatusBarWidget.WidgetPresentation = this

    override fun getIcon() = com.intellij.icons.AllIcons.Nodes.Module

    override fun getClickConsumer(): Consumer<MouseEvent> = Consumer {
        val file = FileEditorManager.getInstance(project).selectedEditor?.file ?: return@Consumer
        val filePath: String = file.path

        // Use already loaded repositories to avoid EDT sync issue
        val gitRepoManager = GitRepositoryManager.getInstance(project)
        val repository = gitRepoManager.repositories.find { repo ->
            filePath.startsWith(repo.root.path)
        }

        val relativePath = if (repository != null) {
            val repoRoot: String = repository.root.path
            filePath.removePrefix(repoRoot).removePrefix("/")
        } else {
            val projectBasePath: String? = project.basePath
            if (projectBasePath != null && filePath.startsWith(projectBasePath)) {
                filePath.removePrefix(projectBasePath).removePrefix("/")
            } else {
                filePath
            }
        }

        CopyPasteManager.getInstance().setContents(StringSelection(relativePath))
    }

    override fun getTooltipText(): String = "Copy relative path"
}
