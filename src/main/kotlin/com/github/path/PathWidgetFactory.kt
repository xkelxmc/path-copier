package com.github.path

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory

class AbsolutePathWidgetFactory : StatusBarWidgetFactory {
    override fun getId(): String = "PathCopier.AbsolutePath"
    override fun getDisplayName(): String = "Copy Absolute Path"
    override fun isAvailable(project: Project): Boolean = true
    override fun createWidget(project: Project): StatusBarWidget = AbsolutePathWidget(project)
    override fun canBeEnabledOn(statusBar: StatusBar): Boolean = true
}

class RelativePathWidgetFactory : StatusBarWidgetFactory {
    override fun getId(): String = "PathCopier.RelativePath"
    override fun getDisplayName(): String = "Copy Relative Path"
    override fun isAvailable(project: Project): Boolean = true
    override fun createWidget(project: Project): StatusBarWidget = RelativePathWidget(project)
    override fun canBeEnabledOn(statusBar: StatusBar): Boolean = true
}
