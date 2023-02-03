package fx.starter.scene.showcase

import fx.starter.scene.createSection
import javafx.collections.FXCollections
import javafx.scene.control.*
import javafx.scene.layout.VBox

/**
 * JavaFx 内置控件: (javafx.scene.control.Control)
 *      javafx.scene.control.Control
 *          javafx.scene.control.Labeled
 *              javafx.scene.control.Label: 标签
 *              javafx.scene.control.TextInputControl
 *                  javafx.scene.control.TextField: 文本框
 *                      javafx.scene.control.PasswordField: 密码框
 *                  javafx.scene.control.TextArea: 文本域
 *                  javafx.scene.control.TitledPane: 带标题面板
 *              javafx.scene.control.ButtonBase
 *                  javafx.scene.control.Button: 按钮
 *                  javafx.scene.control.ToggleButton: 弹出按钮
 *                      javafx.scene.control.RadioButton: 单选按钮
 *                  javafx.scene.control.Hyperlink: 超链接
 *                  javafx.scene.control.CheckBox: 多选按钮
 *                  javafx.scene.control.MenuButton: 菜单按钮
 *              javafx.scene.control.Cell<T>
 *                  javafx.scene.control.IndexedCell<T>
 *                      javafx.scene.control.ListCell<T>
 *              javafx.scene.control.DateCell
 *              javafx.scene.control.ScrollPane: 可滚动面板
 *              javafx.scene.control.TabPane: 标签页
 *              javafx.scene.control.Accordion: TitlePane 合集
 *          javafx.scene.control.ProgressIndicator: 进度提示提
 *              javafx.scene.control.ProgressBar: 进度条
 *          javafx.scene.control.Spinner<T>: 微调按钮
 *          javafx.scene.control.Slider: 滑条
 *          javafx.scene.control.Pagination: 分页
 *          javafx.scene.control.Separator: 分隔符
 *          javafx.scene.control.ButtonBar: 按钮栏
 *          javafx.scene.control.ToolBar: 工具栏
 *          javafx.scene.control.MenuBar: 菜单栏
 *          javafx.scene.control.ListView<T>: 列表
 *          javafx.scene.control.ChoiceBox<T>: 单项选择框
 *          javafx.scene.control.ComboBoxBase<LocalDate>
 *              javafx.scene.control.ComboBox<T>: 组合框
 *              javafx.scene.control.DatePicker: 时间选择器
 *          javafx.scene.control.TreeView<T>
 *          javafx.scene.control.TableView<S>
 *          javafx.scene.control.TreeTableView<S>
 *      javafx.stage.Window
 *          javafx.stage.PopupWindow
 *              javafx.scene.control.PopupControl
 *                  javafx.scene.control.ContextMenu: 上下文菜单
 *                  javafx.scene.control.Tooltip: 提示框
 *      javafx.scene.control.MenuItem: 菜单项
 *          javafx.scene.control.Menu: 菜单
 *          javafx.scene.control.RadioMenuItem: 单选菜单项
 *          javafx.scene.control.CheckMenuItem: 多选菜单项
 *          javafx.scene.control.CustomMenuItem
 *              javafx.scene.control.SeparatorMenuItem: 菜单分隔符
 **/
fun createControlTab(): Tab {
    val vbox = VBox()
    vbox.styleClass.add("v-box")
    val children = vbox.children
    // Label
    val label = Label("Label")
    children.add(
        createSection(
            "Label",
            label,
        )
    )

    // TextField、PasswordField
    val passwordField = PasswordField()
    passwordField.promptText = "PromptText"
    val textField = TextField("TextField")
    children.add(
        createSection(
            "TextField、PasswordField",
            textField,
            passwordField,
        )
    )

    // TextArea
    val textArea = TextArea()
    textArea.promptText = "PromptText"
    children.add(
        createSection(
            "TextArea",
            textArea,
        )
    )

    // Button、ToggleButton、Hyperlink
    val button = Button("Button")
    val toggleButton = ToggleButton("ToggleButton")
    val hyperlink = Hyperlink("Hyperlink")
    children.add(
        createSection(
            "Button、ToggleButton、Hyperlink",
            button,
            toggleButton,
            hyperlink
        )
    )

    // RadioButton
    val radioGroup = ToggleGroup()
    val radioBtn1 = RadioButton("RadioButton A")
    radioBtn1.toggleGroup = radioGroup
    val radioBtn2 = RadioButton("RadioButton B")
    radioBtn2.toggleGroup = radioGroup
    val radioBtn3 = RadioButton("RadioButton C")
    radioBtn3.toggleGroup = radioGroup
    children.add(
        createSection(
            " RadioButton",
            radioBtn1,
            radioBtn2,
            radioBtn3,
        )
    )

    // CheckBox
    val checkBox1 = CheckBox("CheckBox A")
    val checkBox2 = CheckBox("CheckBox B")
    val checkBox3 = CheckBox("CheckBox C")
    children.add(
        createSection(
            " CheckBox",
            checkBox1,
            checkBox2,
            checkBox3,
        )
    )

    // ButtonBar、ToolBar
    val yesButton = Button("Yes")
    ButtonBar.setButtonData(yesButton, ButtonBar.ButtonData.YES)
    val noButton = Button("No")
    ButtonBar.setButtonData(noButton, ButtonBar.ButtonData.NO)
    val buttonBar = ButtonBar()
    buttonBar.buttons.addAll(yesButton, noButton)
    val toolBar = ToolBar(
        Button("New"),
        Button("Open"),
        Button("Close"),
    )
    children.add(
        createSection(
            "ButtonBar、ToolBar",
            buttonBar,
            toolBar,
        )
    )

    // ProgressIndicator、ProgressBar
    val progressIndicator = ProgressIndicator()
    val progressBar = ProgressBar()
    children.add(
        createSection(
            "ProgressIndicator、ProgressBar",
            progressIndicator,
            progressBar,
        )
    )

    // Spinner、Slider
    val spinner = Spinner<Int>(0, 10, 5)
    val slider = Slider(0.0, 10.0, 5.0)
    children.add(
        createSection(
            "Spinner、Slider",
            spinner,
            slider,
        )
    )

    // Pagination
    val pagination = Pagination(3)
    children.add(
        createSection(
            "Pagination",
            pagination,
        )
    )

    // MenuBar、Menu、MenuItem
    val menu1 = Menu("File")
    menu1.items.addAll(
        MenuItem("MenuItem"),
        SeparatorMenuItem(),
        RadioMenuItem("RadioMenuItem"),
        CheckMenuItem("CheckMenuItem"),
    )
    val menu2 = Menu("Options")
    val menu3 = Menu("Help")
    val menuBar = MenuBar(menu1, menu2, menu3)
    children.add(
        createSection(
            "MenuBar、Menu、MenuItem",
            menuBar,
        )
    )

    val items = FXCollections.observableList(mutableListOf("Item A", "Item B", "Item C"))

    // ListView
    val listView = ListView<String>()
    listView.items.addAll(items)
    children.add(
        createSection(
            "ListView",
            listView,
        )
    )

    // ChoiceBox、ComboBox
    val choiceBox = ChoiceBox<String>()
    choiceBox.items.addAll(items)
    val comboBox = ComboBox<String>()
    comboBox.items.addAll(items)
    children.add(
        createSection(
            "ChoiceBox、ComboBox",
            choiceBox,
            comboBox,
        )
    )

    // DatePicker
    val datePicker = DatePicker()
    children.add(
        createSection(
            "DatePicker",
            datePicker,
        )
    )

    val scrollPane = ScrollPane()
    scrollPane.content = vbox
    scrollPane.styleClass.add("scroll-pane")
    return Tab("Control Showcase", scrollPane)
}

