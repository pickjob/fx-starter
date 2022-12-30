package fx.starter.application

import fx.starter.scene.codingScene
import fx.starter.scene.fxmlScene
import javafx.application.Application
import javafx.stage.Stage
import mu.KotlinLogging
import org.slf4j.Logger

class HelloWorldApplication: Application() {
    private val logger: Logger = KotlinLogging.logger {}

    override fun start(stage: Stage) {
        stage.title = "Hello JavaFX"
        // coding
        stage.scene = codingScene()
        // fxml
        // stage.scene = fxmlScene()
        stage.show()
        logger.info("JavaFx is running ...")
    }
}
