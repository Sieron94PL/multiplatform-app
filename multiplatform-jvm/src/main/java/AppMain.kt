import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class AppMain : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root : Parent = FXMLLoader.load(AppMain::class.java.classLoader.getResource("main.fxml"))
        val scene = Scene(root, 600.0, 400.0)
        primaryStage.title = "MP Weather"
        primaryStage.scene = scene
        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(AppMain::class.java)
        }
    }
}
