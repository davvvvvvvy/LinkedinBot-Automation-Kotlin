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


# Contribution [![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/dwyl/esta/issues)

- Fork this repo

- Add new features

- Create a new pull request for this branch
