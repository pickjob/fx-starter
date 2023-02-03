package fx.starter

import fx.starter.application.JavaFxApplication
import javafx.application.Application

/**
 * JavaFx Application:
 *      javafx.stage.Window: 窗口
 *          javafx.stage.PopupWindow
 *          javafx.stage.Stage
 *      javafx.scene.Scene: 场景, 容器
 *      javafx.scene.Node: 控件元素
 *          javafx.scene.Parent
 *              javafx.scene.layout.Region
 *                  javafx.scene.control.Control: 控件
 *                  javafx.scene.layout.Pane: 布局
 *          javafx.scene.shape.Shape: 图形
 */
fun main(args: Array<String>) {
//    Application.launch(HelloWorldApplication::class.java, *args)
    Application.launch(JavaFxApplication::class.java, *args)
}
