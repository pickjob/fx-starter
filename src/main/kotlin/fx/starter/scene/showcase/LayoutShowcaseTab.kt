package fx.starter.scene.showcase

import fx.starter.scene.createSection
import javafx.scene.control.ScrollPane
import javafx.scene.control.Tab
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.shape.Rectangle

/**
 * JavaFx 内置布局控件:
 *      javafx.scene.layout.Pane
 *          javafx.scene.layout.HBox(水平布局)
 *          javafx.scene.layout.VBox(垂直布局)
 *          javafx.scene.layout.BorderPane(上、下、左、右、居中布局)
 *          javafx.scene.layout.GridPane(表格布局)
 *          javafx.scene.layout.FlowPane(流式布局)
 *          javafx.scene.layout.StackPane(Z-ORDER布局, 栈(允许覆盖))
 *          javafx.scene.layout.AnchorPane(锚布局)
 *          javafx.scene.layout.TilePane(均匀大小布局)
 *
 *          javafx.scene.control.DialogPane(对话框布局)
 **/
fun createLayoutTab(): Tab {
    val vBox = VBox()
    val children = vBox.children

    val width = 40.0
    val height = 40.0

    // HBox
    val hBoxShowcase = HBox()
    val rectangleA1 = Rectangle(width, height)
    rectangleA1.styleClass.add("rectangle-a")
    val rectangleB1 = Rectangle(width, height)
    rectangleB1.styleClass.add("rectangle-b")
    val rectangleC1 = Rectangle(width, height)
    rectangleC1.styleClass.add("rectangle-c")
    val rectangleD1 = Rectangle(width, height)
    rectangleD1.styleClass.add("rectangle-d")
    hBoxShowcase.children.addAll(
        rectangleA1,
        rectangleB1,
        rectangleC1,
        rectangleD1,
    )
    children.add(
        createSection(
            "HBox",
            hBoxShowcase,
        )
    )

    // VBox
    val vBoxShowcase = VBox()
    val rectangleA2 = Rectangle(width, height)
    rectangleA2.styleClass.add("rectangle-a")
    val rectangleB2 = Rectangle(width, height)
    rectangleB2.styleClass.add("rectangle-b")
    val rectangleC2 = Rectangle(width, height)
    rectangleC2.styleClass.add("rectangle-c")
    val rectangleD2 = Rectangle(width, height)
    rectangleD2.styleClass.add("rectangle-d")
    vBoxShowcase.children.addAll(
        rectangleA2,
        rectangleB2,
        rectangleC2,
        rectangleD2,
    )
    children.add(
        createSection(
            "VBox",
            vBoxShowcase,
        )
    )

    // BorderPane
    val borderPaneShowcase = BorderPane()
    val rectangleA3 = Rectangle(width, height)
    rectangleA3.styleClass.add("rectangle-a")
    val rectangleB3 = Rectangle(width, height)
    rectangleB3.styleClass.add("rectangle-b")
    val rectangleC3 = Rectangle(width, height)
    rectangleC3.styleClass.add("rectangle-c")
    val rectangleD3 = Rectangle(width, height)
    rectangleD3.styleClass.add("rectangle-d")
    borderPaneShowcase.left = rectangleA3
    borderPaneShowcase.right = rectangleB3
    borderPaneShowcase.top = rectangleC3
    borderPaneShowcase.bottom = rectangleD3
    children.add(
        createSection(
            "BorderPane",
            borderPaneShowcase,
        )
    )

    // StackPane
    val stackPaneShowcase = StackPane()
    val rectangleA4 = Rectangle(width * 4, height * 4)
    rectangleA4.styleClass.add("rectangle-a")
    val rectangleB4 = Rectangle(width * 3, height * 3)
    rectangleB4.styleClass.add("rectangle-b")
    val rectangleC4 = Rectangle(width * 2, height * 2)
    rectangleC4.styleClass.add("rectangle-c")
    val rectangleD4 = Rectangle(width, height)
    rectangleD4.styleClass.add("rectangle-d")
    stackPaneShowcase.children.addAll(
        rectangleA4,
        rectangleB4,
        rectangleC4,
        rectangleD4,
    )
    children.add(
        createSection(
            "StackPane",
            stackPaneShowcase,
        )
    )

    val scrollPane = ScrollPane()
    scrollPane.content = vBox
    scrollPane.styleClass.add("scroll-pane")
    return Tab("Layout Showcase", scrollPane)
}
