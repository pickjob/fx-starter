package fx.starter.scene

import fx.starter.application.HelloWorldApplication
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.VBox

fun codingScene(): Scene {
    val vBox = VBox()
    vBox.children.add(Label("Hello World"))
    val scene = Scene(vBox)
    scene.stylesheets.add("hello_world/hello_world.css")
    return scene
}

fun fxmlScene(): Scene {
    val root: Parent = FXMLLoader.load(HelloWorldApplication::class.java.getResource("/hello_world/hello_world.fxml"));
    return Scene(root)
}
