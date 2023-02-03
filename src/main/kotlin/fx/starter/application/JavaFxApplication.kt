package fx.starter.application

import fr.brouillard.oss.cssfx.CSSFX
import fx.starter.scene.createJavaFxScene
import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.control.Tab
import javafx.stage.Screen
import javafx.stage.Stage
import mu.KotlinLogging
import org.slf4j.Logger

class JavaFxApplication: Application() {
    private val logger: Logger = KotlinLogging.logger {}

    override fun start(stage: Stage) {
        val properties = System.getProperties()
        properties["cssfx.log.level"] = "DEBUG"
        CSSFX.start()
        val transformContent: Parent = FXMLLoader.load(javaClass.getResource("/javafx/fxml/1.Transform.fxml"))
        val transformTab = Tab("Transform", transformContent)

        val regexRenameContent: Parent = FXMLLoader.load(javaClass.getResource("/javafx/fxml/2.RegexRename.fxml"))
        val regexRenameTab = Tab("Transform", regexRenameContent)

        stage.scene = createJavaFxScene(
            regexRenameTab,
            transformTab,
        )
        // 居中展示一半
        val bounds = Screen.getPrimary().visualBounds
        stage.width = bounds.width / 2
        stage.height = bounds.height / 2
        stage.title = "JavaFX Application"
        Platform.runLater {
            Thread.currentThread().setUncaughtExceptionHandler { t: Thread, e: Throwable ->
                logger.error(e.message, e)
            }
        }
        logger.info("JavaFx is running")
        stage.show()
    }
}
