package fx.starter.application

import fr.brouillard.oss.cssfx.CSSFX
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage
import mu.KotlinLogging
import org.slf4j.Logger

class JavaFxApplication: Application() {
    private val logger: Logger = KotlinLogging.logger {}

    override fun start(stage: Stage) {
        val properties = System.getProperties();
        properties["cssfx.log"] = true;
        properties["cssfx.log.level"] = "DEBUG";
        CSSFX.start()
        val root: Parent = FXMLLoader.load(javaClass.getResource("/javafx/fxml/1.Transform.fxml"))
        stage.title = "JavaFX Application"
        stage.scene = Scene(root)
        // 居中展示一半
        val bounds = Screen.getPrimary().visualBounds
        stage.width = bounds.width / 2
        stage.height = bounds.height / 2
        stage.show()
        logger.info("JavaFx is running")
    }
}
