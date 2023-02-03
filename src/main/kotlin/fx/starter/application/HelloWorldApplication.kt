package fx.starter.application

import fx.starter.scene.createCodingScene
import javafx.application.Application
import javafx.stage.Stage
import mu.KotlinLogging
import org.slf4j.Logger

class HelloWorldApplication: Application() {
    private val logger: Logger = KotlinLogging.logger {}

    override fun start(stage: Stage) {
        stage.title = "Hello JavaFX"
        // coding
        stage.scene = createCodingScene()
        // fxml
        // stage.scene = createFxmlScene()
        stage.show()
        logger.info("JavaFx is running ...")
    }
}
