package fx.starter.controller

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.stage.DirectoryChooser
import javafx.util.Callback
import mu.KotlinLogging
import org.slf4j.Logger
import java.io.File
import java.net.URL
import java.util.*

class RegexRenameController : Initializable {
    private val logger: Logger = KotlinLogging.logger {}

    @FXML lateinit var rootDirectory: TextField
    @FXML lateinit var chooseDirectoryBtn: Button
    @FXML lateinit var filterRegex: TextArea
    @FXML lateinit var filterBtn: Button
    @FXML lateinit var filteredList: ListView<File>
    @FXML lateinit var renameOriginRegex: TextArea
    @FXML lateinit var renameReplaceRegex: TextArea
    @FXML lateinit var renamePreviewBtn: Button
    @FXML lateinit var renameBtn: Button
    @FXML lateinit var renamedList: ListView<File>

    override fun initialize(location: URL, resources: ResourceBundle?) {
        chooseDirectoryBtn.setOnAction {
            val directoryChooser = DirectoryChooser()
            directoryChooser.title = "Choose RegexRename Directory"
            val file = directoryChooser.showDialog((it.source as Button).scene.window)
            file?.run {
                rootDirectory.userData = this
                rootDirectory.text = this.absolutePath
                filterBtn.fire()
            }
        }
        filterBtn.setOnAction {
            rootDirectory.userData?.also {
                val root = rootDirectory.userData as File
                val filterPattern = if (null != filterRegex.text && "" != filterRegex.text) {
                    Regex(filterRegex.text)
                } else {
                    Regex(".*")
                }
                filteredList.items.clear()
                for (f in root.listFiles()!!) {
                    if (filterPattern.matches(f.name)) {
                        filteredList.items.add(f)
                    }
                }
            }
        }
        renamePreviewBtn.setOnAction {
            if (null == renameOriginRegex.text || "".equals(renameOriginRegex.text)
                || null == renameReplaceRegex.text || "".equals(renameReplaceRegex.text)) {
                return@setOnAction
            }
            val originPattern = Regex(renameOriginRegex.text)
            renamedList.items.clear()
            for (f in filteredList.items) {
                val parent = f.absoluteFile.parent
                val child = originPattern.replace(f.name, renameReplaceRegex.text)
                val renameFile = File(parent + File.separator + child)
                renamedList.items.add(renameFile)
                logger.info("Rename Preview: {} -> {}", f.name, renameFile.name)
            }
        }
        renameBtn.setOnAction {
            if (filteredList.items.size != renamedList.items.size) {
                logger.error("filteredList != renamedList")
                return@setOnAction
            }
            for (i in filteredList.items.indices) {
                filteredList.items[i].renameTo(renamedList.items[i])
            }
            filterBtn.fire()
            renamePreviewBtn.fire()
        }
        val cellFactory = Callback<ListView<File>, ListCell<File>> {
            object : ListCell<File>() {
                override fun updateItem(item: File?, empty: Boolean) {
                    super.updateItem(item, empty)
                    if (empty || item == null) {
                        text = null;
                        graphic = null;
                    } else {
                        text = item.name
                    }
                }
            }
        }
        filteredList.cellFactory = cellFactory
        renamedList.cellFactory = cellFactory
    }
}
