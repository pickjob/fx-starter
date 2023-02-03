package fx.starter.scene

import fx.starter.scene.showcase.createControlTab
import fx.starter.scene.showcase.createLayoutTab
import fx.starter.scene.showcase.createWindowTab
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.layout.HBox

fun createJavaFxScene(vararg tabs: Tab): Scene {
    val tabPane = TabPane()
    for (tab in tabs) {
        tabPane.tabs.add(tab)
    }
    tabPane.tabs.addAll(
        createControlTab(),
        createLayoutTab(),
        createWindowTab(),
    )
    val scene = Scene(tabPane)
    scene.stylesheets.add("/css/default.css")
    scene.stylesheets.add("/css/theme.css")
    scene.stylesheets.add("/showcase/showcase.css")
    return scene
}

fun createSection(label: String, vararg nodes: Node): Node {
    val sectionLabel = Label(label)
    sectionLabel.styleClass.add("section-label")
    val sectionContent = HBox()
    sectionContent.children.addAll(nodes)
    sectionContent.styleClass.add("section-content")
    sectionLabel.labelFor = sectionContent

    val section = HBox()
    section.styleClass.add("section")
    section.children.addAll(sectionLabel, sectionContent)
    return section
}

