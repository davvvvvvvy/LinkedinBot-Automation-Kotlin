import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.lang.Exception

class LinkedinBot {
    val driver = ChromeDriver()
    val options = ChromeOptions()
    var username : String
    var password : String
    var times : Int
    var path : String

    init {
        System.setProperty("webdriver.chrome.driver", "path\\to\\file") // set webdriver path
        this.options.addArguments("--user-agent='Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1'")
        this.options.addArguments("--dns-prefetch-disable")
        this.options.addArguments("--lang=en-US")
    }

    constructor(username :String, password:String, times:Int = 10, path:String) {
        this.username = username
        this.password = password
        this.times = times
        this.path = path
    }

    fun setOptions(headless : Boolean = true, mute : Boolean = true) {
        if (headless) {
            this.options.addArguments("-headless")
        }

        if (mute) {
            this.options.addArguments("--mute-audio")
        }
    }

    fun login () {
        try {
            this.driver.get("https://www.linkedin.com/login")
            val u = this.driver.findElementById("username")
            u.sendKeys(this.username)
            val p = this.driver.findElementById("password")
            p.sendKeys(this.password)
            val button = this.driver.findElementByXPath("//button[@type='submit']")
            button.click()

            println("Logged in succesfully")
        }

        catch (e:Exception) {
            println("ERROR at\t$e")
        }
    }

    fun clickConn() {
        this.driver.get("https://www.linkedin.com/mynetwork/")
        var i : Int = 0

        (0..this.times).forEach() {
            try {

                val conn = this.driver.findElementByXPath("//button[@data-control-name='invite']")
                conn.click()
                println("Connection sent...")
                if (i == 10) {
                    println("Time to sleep for 10 minutes...")
                    Thread.sleep(600_000)
                }
                i += 1 // i++, i+=1, i = i + 1
            }

            catch (e:Exception) {
                println("ERROR at\t$e")
            }
        }
    }

    fun closeDriver() {
        this.driver.close()
    }
}

fun main () {

    val username:String = "your_username"
    val password:String = "your_password"

    var lb = LinkedinBot(username, password, 20)
    lb.login()
    lb.clickConn()
    lb.closeDriver()
}