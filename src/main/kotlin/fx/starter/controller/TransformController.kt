package fx.starter.controller

import fx.starter.service.Transform
import fx.starter.service.impl.Base64Transform
import fx.starter.service.impl.Base64UrlTransform
import fx.starter.service.impl.UrlTransform
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ComboBox
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.TextArea
import javafx.scene.input.MouseEvent
import javafx.util.Callback
import mu.KotlinLogging
import org.slf4j.Logger
import java.lang.Exception
import java.net.URL
import java.util.*

class TransformController: Initializable {
    private val logger: Logger = KotlinLogging.logger {}
    private val transTypeList = FXCollections.observableArrayList<Transform>(
        Base64Transform(),
        Base64UrlTransform(),
        UrlTransform()
    )
    @FXML private lateinit var srcText: TextArea
    @FXML private lateinit var destText: TextArea
    @FXML private lateinit var transType: ComboBox<Transform>

    @FXML
    private fun transform(event: MouseEvent) {
        try {
            val selected = transType.selectionModel.selectedItem
            destText.text = selected.transfrom(srcText.text)
        } catch (e: Exception) {
            logger.error(e.message, e)
        }
    }

    @FXML
    private fun reverse(event: MouseEvent) {
        try {
            val selected = transType.selectionModel.selectedItem
            destText.text = selected.reverse(srcText.text)
        } catch (e: Exception) {
            logger.error(e.message, e)
        }
    }

    override fun initialize(location: URL, resources: ResourceBundle?) {
        transType.items = transTypeList
        val cellFactory = Callback<ListView<Transform>, ListCell<Transform>> {
            val transTypeRegex = Regex("(.+)\\.(.+)Transform")

            object: ListCell<Transform>() {
                override fun updateItem(item: Transform?, empty: Boolean) {
                    super.updateItem(item, empty)
                    if (empty || item == null) {
                        text = null;
                        graphic = null;
                    } else {
                        val transType = item.javaClass.name
                        val (_, transTypeName) = transTypeRegex.find(transType)!!.destructured
                        text = transTypeName
                    }
                }
            }
        }
        transType.buttonCell = cellFactory.call(null)
        transType.cellFactory = cellFactory
        transType.value = transType.items.get(0)
    }
}
