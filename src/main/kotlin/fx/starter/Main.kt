package fx.starter

import fx.starter.application.HelloWorldApplication
import javafx.application.Application

/**
 * JavaFx Application:
 *      javafx.stage.Window: 窗口
 *          javafx.stage.PopupWindow
 *          javafx.stage.Stage
 *      javafx.scene.Scene: 场景, 容器
 *      javafx.scene.Node: 控件元素
 *          javafx.scene.Parent
 *              javafx.scene.layout.Regon
 *                  javafx.scene.control.Control
 *                  javafx.scene.layout.Pane
 *
 */
fun main(args: Array<String>) {
    Application.launch(HelloWorldApplication::class.java, *args)
}
