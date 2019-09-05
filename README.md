# LinkedinBot-Automation-Kotlin

Automation for Linkedin

# Usage

-> define username, password and how many times to repeat it.

-> login() : Login into Linkedin

-> clickConn() : Clicks on every connection button

-> closeDriver() : closes driver


    val username:String = "your_username"
        val password:String = "your_password"

        var lb = LinkedinBot(username, password, 20)
        lb.login()
        lb.clickConn()
        lb.closeDriver()
