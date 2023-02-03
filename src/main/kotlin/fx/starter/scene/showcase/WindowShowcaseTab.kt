package fx.starter.scene.showcase

import javafx.scene.control.ScrollPane
import javafx.scene.control.Tab
import javafx.scene.layout.VBox

/**
 * javafx窗口:
 *      javafx.stage.Window
 *          javafx.stage.Stage
 *          javafx.stage.PopupWindow
 *              javafx.stage.Popup
 *              javafx.scene.control.PopupControl
 *                  javafx.scene.control.Tooltip: 提示框
 *                  javafx.scene.control.ContextMenu: 上下文菜单, 弹出菜单
 **/
fun createWindowTab(): Tab {
    val vBox = VBox()
    val children = vBox.children

    val scrollPane = ScrollPane()
    scrollPane.content = vBox
    scrollPane.styleClass.add("scroll-pane")
    return Tab("Window Showcase", scrollPane)
}
